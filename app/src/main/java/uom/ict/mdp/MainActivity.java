package uom.ict.mdp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    private String[] navDrawerEntries;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    // Listing the Available Events in Malta (Hardcoded atm)

    private FrameLayout mFrameLayout;
    private ListView mEventsList;
    private String[] navEventsEntries;


    // Used With Toast for Testing Purposes
    Toast t;
    private Context ct;
    CharSequence text;
    int duration;


    /**
     * @todo Create an alert dialog box on the Drawer for filtering. First click Filter then proceed to choose the options
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navDrawerEntries = getResources().getStringArray(R.array.nav_drawer_entries);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        // Set the adapter for the list view of DRAWER
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, navDrawerEntries));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        /***
         * @todo This has to change into a FRAGMENT! in order for us to switch between events
         */
        // Declaring the List for the events in Main Menu

        navEventsEntries = getResources().getStringArray(R.array.nav_events_entries);
        mFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        mEventsList = (ListView) findViewById(R.id.main_menu);


        // Set Adapter for list view of MAIN MENU
        mEventsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, navEventsEntries));
        // Listener for Click
        mEventsList.setOnItemClickListener(new MainMenuItemClickListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            ct = getApplicationContext();
            CharSequence text = "Settings Pressed";
            int duration = Toast.LENGTH_SHORT;

            t = Toast.makeText(ct, text,duration);
            t.show();

        }
        else if (id == R.id.action_aboutUs)
        {
            ct = getApplicationContext();
            text = "About Us Pressed";
            duration = Toast.LENGTH_SHORT;

            t = Toast.makeText(ct, text,duration);
            t.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /***
     *  @todo different type of sorts according to button pressed
     */

    // Testing with TOAST to see if the list items are being read

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {

        // position starts from 0.

        switch (position)
        {
            case 0:
                ct = getApplicationContext();
                text = "Sort By Name";
                duration = Toast.LENGTH_SHORT;

                t = Toast.makeText(ct, text,duration);
                t.show();
                break;

            case 1:
                ct = getApplicationContext();
                text = "Sort By Time";
                duration = Toast.LENGTH_SHORT;

                Toast t = Toast.makeText(ct, text,duration);
                t.show();
                break;

            case 2:
                ct = getApplicationContext();
                CharSequence text = "Sort By Age";
                int duration = Toast.LENGTH_SHORT;

                t = Toast.makeText(ct, text,duration);
                t.show();

        }




    }

    private class MainMenuItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItemEvents(position);

        }

        // Swaps Fragments
        private void selectItemEvents(int position) {
            switch (position) {
                case 0:
                    ct = getApplicationContext();
                    text = "Birgu Fest";
                    duration = Toast.LENGTH_SHORT;

                    t = Toast.makeText(ct, text, duration);
                    t.show();
                    break;

                case 1:
                    ct = getApplicationContext();
                    text = "Zejt iz-Zejtun";
                    duration = Toast.LENGTH_SHORT;

                    Toast t = Toast.makeText(ct, text, duration);
                    t.show();
                    break;

                case 2:
                    ct = getApplicationContext();
                    CharSequence text = "Mdina Night";
                    int duration = Toast.LENGTH_SHORT;

                    t = Toast.makeText(ct, text, duration);
                    t.show();

            }
        }
    }
}
