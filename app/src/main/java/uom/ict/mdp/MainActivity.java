package uom.ict.mdp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import java.net.MalformedURLException;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	public static final boolean DEBUG = false;
	public static final String[] MAIN_EVENT_IDS = {
		"81E19FAB-92F8-4122-B501-5C16F670E814"		// Notte Biancha
	};

	public final static String TITLE = "title";
	public final static String LOCATION = "location";
	public final static String START_TIME = "start_time";
	public final static String END_TIME = "end_time";
	public final static String AGE_GROUP = "age_group";
	public final static String CATEGORY = "category";
	public final static String DESCRIPTION = "description";
	public final static String XCOOR = "xcoor";
	public final static String YCOOR = "ycoor";

	private MobileServiceClient mClient;
	private MobileServiceTable<Event> mEventsTable;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private GoogleMap mGoogleMap;
    private Intent i;
    private EventList eventsList = new EventList();
	private EventsListAdapter eventListAdapter;
	private ListView eventView;
	private String currentMainEventID = "";
	private int currentMainEvent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i2 = getIntent();
		currentMainEvent = i2.getExtras().getInt(Intro.EVENT_TITLE);
		currentMainEventID = MAIN_EVENT_IDS[currentMainEvent];

		try {
			// Create the Mobile Service Client instance, using the provided
			// Mobile Service URL and key
			mClient = new MobileServiceClient(
				"https://mepamdp.azure-mobile.net/",
				"BKMUxLaaeDGwnYFRmZEKEzuMhhMNdT83",
				this
			);

			// Get the Mobile Service Table instance to use
			mEventsTable = mClient.getTable(Event.class);
		} catch (MalformedURLException e) {
			Toast.makeText(getBaseContext(), "There was an error creating the Mobile Service. Verify the URL", Toast.LENGTH_LONG);
		}

		// According to the event, the List will change.
		/*
		EventList[] mainEvents = {
			new EventList(notteBiancha),
			new EventList(birgu)
		};
		eventsList = mainEvents[currentMainEvent];
		eventsList.sortByTime();
		*/

		// Initialize the event view and set the adapter to it
        this.eventView = (ListView) findViewById(R.id.event_lists);
		refreshItemsFromTable();
		updateEventList();

        // Onclick Listener
        this.eventView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				debugToast("This is a test " + position);
                onEventClick(position);
            }
        });

		// Get the fragment for the navigation drawer
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);

		// Set up the drawer with the DrawerLayout
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }


	/**
	 * Initializes the activity menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * Select an option from the menu
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_refresh) {
			this.refreshItemsFromTable();
		}

		return true;
	}


	/**
	 * ON CLICK ON AN EVENT
	 *
	 * @param position Position of the event clicked.
	 */
    public void onEventClick(int position) {
        Intent i = new Intent (this, EventInfoActivity.class);
		Event e = eventsList.get(position);
		i.putExtra(TITLE,  e.getName());
		i.putExtra(LOCATION, e.getLocation());
		i.putExtra(DESCRIPTION, e.getDescription());
		i.putExtra(START_TIME, e.getTime());
		i.putExtra(END_TIME,  e.getEndTime());
		i.putExtra(AGE_GROUP, e.getAgeType().toString());
		i.putExtra(CATEGORY, e.getCategory());
		i.putExtra(XCOOR, e.getxCoordinates());
		i.putExtra(YCOOR, e.getyCoordinates());
        startActivity(i);
    }


	private void updateEventList() {
		this.eventListAdapter = new EventsListAdapter(this, R.layout.events_list_item, this.eventsList);
		this.eventView.setAdapter(this.eventListAdapter);
	}


    @Override
    public void onNavigationDrawerItemSelected(int position) {
		switch (position) {
			case 0:
				this.eventsList.sortByTime();
				debugToast("Sorted by time");
				break;
			case 1:
				this.eventsList.sortByName();
				debugToast("Sorted by name");
				break;
			case 2:
				this.eventsList.sortByAgeType();
				debugToast("Sorted by age type");
				break;
			case 3:
				this.eventsList.sortByLocation();
				debugToast("Sorted by location");
				break;
		}
		if (this.eventListAdapter != null) {
			updateEventList();
		}
	}


	/**
	 * Add a new item
	 */
	public void addItem() {

		// Create a new item
		final Event event = new Event();
		event.setMainEventId("81E19FAB-92F8-4122-B501-5C16F670E814");

		event.setName("Destroying Azure");
		event.setDescription("The time has come for Azure to get dragged into the Recycling bin.");

		// Insert the new item
		new AsyncTask<Void, Void, Void>() {
	        @Override
	        protected Void doInBackground(Void... params) {
	            try {
					Log.v("MEPA", "Attempting to insert a test item");
	                mEventsTable.insert(event).get();
	            } catch (Exception exception) {
					Log.v("MEPA", "Error: " + exception.getMessage());
	            }
	            return null;
	        }
	    }.execute();
	}


	/**
	 * Refresh the list with the items in the Mobile Service Table
	 */
	private void refreshItemsFromTable() {
		// Get the items that weren't marked as completed and add them in the adapter
	    new AsyncTask<Void, Void, Void>() {
	        @Override
	        protected Void doInBackground(Void... params) {
	            try {
	                final MobileServiceList<Event> result = mEventsTable.where().field("mainEventID").eq(currentMainEventID).execute().get();
	                runOnUiThread(new Runnable() {

	                    @Override
	                    public void run() {
							eventsList.clear();
	                        for (Event item : result) {
								eventsList.add(item);
								Log.v("MEPA", "Received an item");
							}
							Log.v("MEPA", "Total "+eventsList.size()+" items");
							updateEventList();
	                    }
	                });
	            } catch (Exception exception) {
					Log.v("MEPA", "Error: " + exception.getMessage());
	            }
	            return null;
	        }
	    }.execute();
	}



	public void debugToast(String message) {
		if (DEBUG) Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
		}
	}

}
