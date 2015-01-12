package uom.ict.mdp;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
//    private MapView mMapView;
    private GoogleMap mGoogleMap;
    private Intent i;
    private List<Events> eventsList = new ArrayList<Events>();



    /**
     *  Static Data for Testing Purposes, Will shows the Events Possible in Notte Biancha as Rows
     */

    public final static String TITLE = "title";
    public final static String LOCATION = "location";
    public final static String START_TIME = "start_time";
    public final static String END_TIME = "end_time";
    public final static String CATEGORY = "age_group";
    public final static String DESCRIPTION = "description";
    public final static String XCOOR = "xcoor";
    public final static String YCOOR = "ycoor";


    /**
	 * Descriptions for Notte Biancha
     */

    public final static String opDesc = "No night of festivities would be complete without a little pomp and circumstance. In that fashion Notte Bianca opens grandiosely with a historical re-enactment by the Inguardia Re-enactors, and Duke of Argyll’s Own Pipe Band marching around Valletta.";
    public final static String zigDesc = "Żigużajg is the International Arts Festival for Children and Young People held annually in Valletta produced by St. James Cavalier Centre for Creativity. The performances target an audience of children and youth, from newborns to 16 year olds. Żigużajg will be giving a very special preview of its programme for 2014 during Notte Bianca. Join the Żigużajg team at the Upper Barracca Gardens on the night for a guaranteed evening of creativity, culture and fun for children of all ages! Participating artists include Trevor Zahra, Drama Unit, Xarulu’ and St James Cavalier Animators. This year Notte Bianca’s children’s area will be taken over by the Żigużajg team";
    public final static String qaddDesc= "Inside tal-Karmnu Church strange happenings are afoot. The traditional vari of our beloved local feasts are coming to life to tell their tales and reminisce the good old days of their respective festas. Even long standing rivals like San Ġorġ and San Bastjan will be trying to settle old scores!";
    public final static String orgDesc = "The Voices form the Cantores choir will give us a concert on one of the hidden musical gems of Valletta, the organ at the church of St Augustine. The programme includes beautiful pieces from Maltese and foreign composers. The programme will be concluded with the premier performance of Salve Regina composed by the organist herself Claudia Grima Tufigno.";
    public final static String bellDesc = "This year Notte Bianca is proud to present the Bellophone; an innovative project which will allow you to play the bells of Valletta! A collaboration between sound designer Mario Sammut, engineers and the Valletta communities has brought us one of the most innovative projects ever programmed for Notte Bianca.\n" +
            "\n" +
            "Set up in Independence Square, the Bellophone is a large scale instrument incorporating two Valletta church bell towers – those of the Anglican and the Karmelite churches – and a state-of-the-art playing console. The console features a playing board, similar to a keyboard of a piano in function, but instead of keys it has large round buttons, which when pressed will ring the bells in the towers wirelessly. This is a once in a lifetime opportunity for people to be able to play the bells of two churches simultaneously.";

    public final static String pintDesc = "Three inventive local theatre groups will be putting up performances inspired by the stories discovered during the Valletta 2018 and Heritage Malta collective memory project Qatt Ma Ninsa, which took place at the Malta Maritime Museum project in June.\n" +
            "\n" + "SENSE OF PLAY performed by Claudio Carta [20.00/21.30/23.00/00.30]"
            +"\n" + "+1 performed by Versilhoss [19.30/21.00/22.30/00.00]"
            +"\n" + "Maleth [20.30/22.00/23.30/01.00]";

    public final static String orkDesc = "As the bells chime midnight, the Malta Youth Orchestra will be kicking off a swing concert in Pjazza Teatru Rjal full of oomph, zing and pzazz. Join this talented young ensemble for what promises to be a great energetic performance.\n" +
            "\n" +
            "The Malta Youth Orchestra is the ‘sister ensemble’ of the Malta Philharmonic Orchestra and is made up of talented young musicians. The target aim of the MYO is to provide an excellent opportunity for budding musicians to gain first-hand experience playing in an orchestra and, more importantly, to participate in the joy of ensemble music-making.";

    public final static String planDesc = "Notte Bianca shall be reviving the traditional Maltese plancier, which were used for concerts of band clubs around Valletta. Creating a beautiful reconstruction of this traditional stage, Notte Bianca will be giving this characteristically Maltese construct back to the city. Showcasing their talents on this stage will be a motley crew of musical variety, including Australian Fusion, samba music, and the Matuto America Folk Band straight from America!"
            + "\n" + "Starting Times will be: 20:30, 22:00 and 00:00";

    public final static String kastDesc = "Fancy a night at the proms?  Then join us at the magisterial Pjazza Kastilja for a night of operatic and classical concerts. Local singers and musicians, will be giving a concert full of the best classical music pieces and popular operatic arias. The evening will also feature a special concert celebrating the Nani family.\n" +
            "\n" +
            "Featuring the harpist Lydia Buttigieg, maestro Dr. Joseph Gatt, tenor Brian Cefai and soprano Kimberly Marie Grech accompanied by pianist Louise Zammit.";

    // --- Static Array For Notte Biancha which will have the events
    public static Events[] notteBiancha = new Events[]
            {
               new Events(1,R.drawable.opening,"Notte Bianca 2015 Opening",opDesc,"Independence Square","19:00","All Night",EventAgeType.GENERAL,35.896782f, 14.510254f),
               new Events(2,R.drawable.ziguzajg,"Ziguzajg Area for Children and Young People",zigDesc,"St James Cavalier Centre for Creativity, Pope Pius V Street, Valletta","19:00","All Night",EventAgeType.CHILD,35.895757f, 14.510243f),
               new Events(3,R.drawable.ilqaddisin,"Il-Qaddisin",qaddDesc,"Old Theatre Street, Valletta","19:00","All Night",EventAgeType.GENERAL,35.899786f, 14.512596f),
               new Events(4,R.drawable.orgni,"Fuq L-Orgni ta' Patri Bert",orgDesc,"St. Augustine Church, Old Bakery Street,","20:30","22:30",EventAgeType.GENERAL,35.898759f, 14.510890f),
               new Events(5,R.drawable.bellophone,"Bellophone",bellDesc,"Misrah l-Indipendenza","19:00","20:30",EventAgeType.GENERAL,35.896782f, 14.510254f),
               new Events(6,R.drawable.pintateatru,"Pintateatru : Qatt Ma Ninsa Qatt",pintDesc,"Palace Courtyard, Republic Street,Palace Courtyard, Republic Street,","19:30","All Night",EventAgeType.ADULT,35.900069f, 14.515345f),
               new Events(7,R.drawable.orkestraswing,"OrkestraSwing",orkDesc,"Pjazza Teatru Rjal","00:00","02:00",EventAgeType.GENERAL,35.896730f, 14.510296f),
               new Events(8,R.drawable.plancier,"Id-Dinja fuq il-Plancier",planDesc,"St.Lucia Street","20:30","01:30",EventAgeType.GENERAL,35.898279f, 14.512579f),
               new Events(9,R.drawable.kastiljaklassika,"Kastilja Klassika",kastDesc,"Pjazza Kastilja","19:00","21:00",EventAgeType.GENERAL,35.895670f, 14.511091f)

            };


    /**
	 * All Arrays And Descriptions used for UOM
     */


    public final static String knightDesc = "Reading of the edict around the historical City of Birgu. There will also be a dramatisation of the Knights Era!"
            +"\n" +"This will be followed by an Activity by Dogs Trust and some Sports Activities. The Police Department will give a show with their canine unit";
    public final static String funtrainDesc = "A Trip around Birgu with our only and only fun train. Enjoy seeing the most important landmarks in this city!";
    public final static String tourDesc = "Several Tours for Children with plenty of landmarks to see! This will include:" +
            "\n" + "- Church of the Annuncation and the Cloister of the Domnican Friar's Convent" +
            "\n" + "- St Lawerence Parish Church" +
            "\n" + "- Inquistor's Palace" +
            "\n" + "- Maritime Museum" +
            "\n" + "- Benedictine Nuns Monastery";

    public final static String couvreDesc = "Traditional Maltese Artisan Market where you find everything traditionally related to Malta, Bizzilla, Maltese Food including the famous gbejna and more";
    public final static String liveconcertDesc = "A Live concert starring 3 bands to keep you entertained during the night"
            + "\n" + "Starting at 19:00 - 20:00 a Band from the US, Matuto, will open the concert"
            + "\n" + "Following at 20:15 - 21:45 will be a local Band, D-Banned"
            + "\n" + "And ending the show we will have the famous Cash&Band who will start from 22:00 - 00:00"
            ;

    public static Events[] birgu = new Events[] {
	   new Events (1,R.drawable.maltaknights,"Knights Enactment",knightDesc,"Misrah Ir-Rebha","09:00","12:00",EventAgeType.CHILD,35.887969f, 14.521910f),
	   new Events (2,R.drawable.funtrain,"Fun Train  Tours",funtrainDesc,"Vittoriosa Bus Terminus","09:00","12:00",EventAgeType.GENERAL,35.884906f, 14.523435f),
	   new Events (3,R.drawable.tours,"Guided Tours  for Children to historical places in the City of Birgu",tourDesc,"Triq Pawlu Boffa", "09:00","22:00",EventAgeType.CHILD, 35.885820f, 14.522933f),
	   new Events (4,R.drawable.artisan,"Couvre Porte Area",couvreDesc,"Couvre Porte, Triq 8 ta' Dicembru", "19:00","23:00",EventAgeType.CHILD, 35.885362f, 14.522634f),
	   new Events (5,R.drawable.liveconcert,"Knights Enactment",liveconcertDesc,"Triq Pawlu Boffa", "19:00","00:00",EventAgeType.CHILD, 35.885820f, 14.522933f),
	   new Events (6,R.drawable.funtrain,"Fun Train  Tours",funtrainDesc,"Vittoriosa Bus Terminus","19:00","00:00",EventAgeType.GENERAL,35.884906f, 14.523435f),

	};







    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ---- Displaying the List according to the Page the User chose in the INTRO page ---- //

        Intent i2 = getIntent();
        final int event = i2.getExtras().getInt(Intro.EVENT_TITLE);
        Toast.makeText(getBaseContext(),""+event,Toast.LENGTH_SHORT).show();


        // According to the event, the List will change.

        switch (event)
        {
            case 0:
                // Notte Biancha
                for (int i=0; i<notteBiancha.length; i++)
                {
                    eventsList.add(notteBiancha[i]);
                }
                break;
            case 1:
                for (int i=0; i<birgu.length; i++)
                {
                    eventsList.add(birgu[i]);
                }
                break;



        }



        // Changing array to List



        ListView eventView = (ListView) findViewById(R.id.event_lists);
        eventView.setAdapter(new EventsListAdapter(this, R.layout.events_list_item,eventsList));



        // Onclick Listener

        eventView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String test = ("This is a test " + position);
                Toast.makeText(getBaseContext(),test,Toast.LENGTH_SHORT).show();


                onClickEvent(position);


            }
        });


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    public void onClickEvent(int position)
    {
        Intent i = new Intent (this, EventInfoActivity.class);

        i.putExtra(TITLE, eventsList.get(position).getName());
        i.putExtra(LOCATION,eventsList.get(position).getLocation());
        i.putExtra(DESCRIPTION,eventsList.get(position).getDescription());
        i.putExtra(START_TIME,eventsList.get(position).getTime());
        i.putExtra(END_TIME, eventsList.get(position).getEndTime());
        i.putExtra(CATEGORY,eventsList.get(position).getAgeType().toString());
        i.putExtra(XCOOR,eventsList.get(position).getxCoordinates());
        i.putExtra(YCOOR,eventsList.get(position).getyCoordinates());
        startActivity(i);



    }



    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                //mTitle = getString(R.string.sort_age);
                Toast.makeText(getApplicationContext(), "This will sort by Age.", Toast.LENGTH_SHORT).show();

                break;
            case 2:
                //mTitle = getString(R.string.sort_name);
                break;
            case 3:
                //mTitle = getString(R.string.sort_time);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }


/*
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.event_info_layout, container, false);
            return rootView;
        }*/


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
//            /*((MainActivity) activity).onSectionAttached(
//                    getArguments().getInt(ARG_SECTION_NUMBER));*/
        }
    }


}
