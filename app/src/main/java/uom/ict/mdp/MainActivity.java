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


    public static String descICT = "Open Day at the ICT Building which hosts lots of activities for everybody. Games created by our development crew" +
            " or cheeky robots and AI from the engineering and science students are for you to see and try! So come and join us in the ICT Building" +
            "where we assured you, you will not regret it";
    public static String descRobotica = "Robotica in the Engineering Building features Robots built by our students. Come and join us and you will have " +
            "the opportunity to control some of our gadgets! some come and join us!";
    public static String descFood = "All types of Food found at our canteen to satisfy that tummy of yours";
    public static String descHistory = "Come and learn what used to happen back in the dark middle ages. Join us in " +
            "journey, where our actors will be showing all the atrocities that used to happen. Viewers at their own discretion";
    public static String descScience = "Explosions and tricks and fun! Come and see what us chemists do! I'm sure you kids love it!";
    public static String musicShow = " The Best talent from our students in a music show in the Quadrangle, guaranteed to offer you a show " +
            "better than show exists in the country!";
    /**
     *  Static Data for Testing Purposes, Will shows the Events Possible in BIRGU FEST as Rows
     */

    public final static String TITLE = "title";
    public final static String LOCATION = "location";
    public final static String START_TIME = "start_time";
    public final static String END_TIME = "end_time";
    public final static String CATEGORY = "age_group";
    public final static String DESCRIPTION = "description";
    public final static String XCOOR = "xcoor";
    public final static String YCOOR = "ycoor";



    public static Events[] events = new Events[]
            {
                    new Events (1,R.drawable.ictb1, "ICT Open Day", descICT, "ICT Building", "08:00", "22:00",EventAgeType.GENERAL,35.901762f, 14.485334f),
                    new Events (2,R.drawable.eng1, "Robotica", descRobotica, "Engineering Building", "08:00", "22:00",EventAgeType.GENERAL,35.90338f, 14.484725f),
                    new Events (3,R.drawable.canteen1, "Food Haven", descFood, "Canteen", "08:00", "02:00", EventAgeType.GENERAL,35.90338f, 14.484725f),
                    new Events (4,R.drawable.hist1, "Mediveal History", descHistory, "Erin Serracino Hall", "08:00", "22:00",EventAgeType.ADULT,35.90338f, 14.484725f),
                    new Events (5,R.drawable.sc1, "Exploding Sci", descScience, "Engineering Building", "08:00", "22:00",EventAgeType.CHILD,35.90338f, 14.484725f),
                    new Events (6,R.drawable.rock, "Rock on", musicShow, "Quadrangle", "08:00", "22:00",EventAgeType.GENERAL,35.90338f, 14.484725f),

            };




    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ---- Displaying the List ---- //

        // Changing array to List

        for (int i=0; i<events.length; i++)
        {
            eventsList.add(events[i]);
        }

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


        // --- SETTING UP UNIVERSAL IMAGE LOADER ----- //

        /**
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache (new WeakMemoryCache())
                .discCacheSize (100*1024*1024).build();

        ImageLoader.getInstance().init(config);
         */
    }

    public void onClickEvent(int position)
    {
        Intent i = new Intent (this, EventInfoActivity.class);

        i.putExtra(TITLE,eventsList.get(position).getName());
        i.putExtra(LOCATION,eventsList.get(position).getLocation());
        i.putExtra(DESCRIPTION,eventsList.get(position).getDescription());
        i.putExtra(START_TIME,eventsList.get(position).getTime());
        i.putExtra(END_TIME,eventsList.get(position).getEndTime());
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
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
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
