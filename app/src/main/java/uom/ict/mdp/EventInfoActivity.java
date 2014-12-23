package uom.ict.mdp;

/**
 * Created by DodoSerebro on 15/12/2014.
 */

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.*;
import com.google.android.gms.maps.*;


/**
 * Where all the EventInfo data will be held. Will be used as intents
 */
public class EventInfoActivity extends FragmentActivity
{
    private MapFragment mapFragment;
    private GoogleMap googleMap;
    public static FragmentManager fragmentManager;
    private Button button;
    private ScrollView mainScrollView;
    private ImageView transparentImageView;


    @Override
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.event_info_layout);

        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.location_map)).getMap();

        Intent i = getIntent();

        final float xcoor = i.getExtras().getFloat(MainActivity.XCOOR);
        final float ycoor = i.getExtras().getFloat(MainActivity.YCOOR);

        LatLng eventLatLng = new LatLng(xcoor,ycoor);


        //---- Outputting the Information ---- //

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

        // -- START TIME -- //
        String startTime = i.getStringExtra(MainActivity.START_TIME);
        TextView startText= (TextView) findViewById(R.id.start_time_info);
        startText.setText("Start Time:" + startTime);

        // -- END TIME -- //
        String endTime = i.getStringExtra(MainActivity.END_TIME);
        TextView endText = (TextView) findViewById(R.id.end_time_info);
        endText.setText("End Time:"+endTime);

        // -- CATEGORY -- //
        String category = i.getStringExtra(MainActivity.CATEGORY);
        TextView categoryText= (TextView) findViewById(R.id.category_info);
        categoryText.setText("Age Group:" + category);



/*
        if (googleMap != null)
        {
            Marker locationMarker = googleMap.addMarker(new MarkerOptions().position())
        }
*/
        button = (Button) findViewById(R.id.google_maps_info);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"" + xcoor,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"" + ycoor,Toast.LENGTH_SHORT).show();
            }
        });

            Marker eventMarker = googleMap.addMarker(new MarkerOptions().position(eventLatLng)
                                            .title(title));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eventLatLng, 20));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(20), 2000, null);




        // This will make the Maps UI usable as without it the ScrollView would hinder every possibility


        mainScrollView  = (ScrollView) findViewById(R.id.main_scroll);
        transparentImageView = (ImageView) findViewById(R.id.transparent_image);











    }








}
