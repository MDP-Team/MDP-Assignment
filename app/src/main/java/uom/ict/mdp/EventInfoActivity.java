package uom.ict.mdp;

/**
 * Created by DodoSerebro on 15/12/2014.
 */

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * Where all the EventInfo data will be held. Will be used as intents
 */
public class EventInfoActivity extends FragmentActivity {
    private MapFragment mapFragment;
    private GoogleMap googleMap;
    public static FragmentManager fragmentManager;

    private ScrollView mainScrollView;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
		setTitle("Event Details");
        setContentView(R.layout.event_info_layout);

        // This will make the Maps UI usable as without it the ScrollView would hinder every possibility

        googleMap = ((MapUIControls) getFragmentManager().findFragmentById(R.id.location_map)).getMap();
        mainScrollView = (ScrollView) findViewById(R.id.main_scroll);
        ((MapUIControls) getFragmentManager().findFragmentById(R.id.location_map)).setListener(new MapUIControls.OnTouchListener() {
            @Override
            public void onTouch() {
                mainScrollView.requestDisallowInterceptTouchEvent(true);
            }
        });

        // ----- Intents and data change according to the row number ---- //

        Intent i = getIntent();

        final float xcoor = i.getExtras().getFloat(MainActivity.XCOOR);
        final float ycoor = i.getExtras().getFloat(MainActivity.YCOOR);

        LatLng eventLatLng = new LatLng(xcoor,ycoor);

        // ---- Outputting the Information ---- //

        // -- Title -- //
        String title = i.getStringExtra(MainActivity.TITLE);
        TextView nameText = (TextView) findViewById(R.id.event_name_info);
        nameText.setText(title);

        // -- DESC -- //
        String description = i.getStringExtra(MainActivity.DESCRIPTION);
        TextView descText = (TextView) findViewById(R.id.description_info);
        descText.setText(description);

        // -- LOCATION -- //
        String location = i.getStringExtra(MainActivity.LOCATION);
        TextView locationText = (TextView) findViewById(R.id.street_name_info);
        locationText.setText(location);

        // -- TIME -- //
        String startTime = i.getStringExtra(MainActivity.START_TIME);
		String endTime = i.getStringExtra(MainActivity.END_TIME);
        TextView timeText= (TextView) findViewById(R.id.time_info);
		timeText.setText("Time: " + startTime + " - " + endTime);

        // -- AGE GROUP -- //
        String ageGroup = i.getStringExtra(MainActivity.AGE_GROUP);
        TextView ageGroupText= (TextView) findViewById(R.id.age_info);
		ageGroupText.setText("Age Group: " + ageGroup);

		// -- CATEGORY GROUP -- //
		String category = i.getStringExtra(MainActivity.CATEGORY);
		TextView categoryText = (TextView) findViewById(R.id.category_info);
		categoryText.setText("Category: " + category);

		// -- GOOGLE MAP -- //

		Marker eventMarker = googleMap.addMarker(new MarkerOptions().position(eventLatLng)
										.title(title));
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eventLatLng, 15));
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
		googleMap.getUiSettings().setMapToolbarEnabled(true);
		googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

}
