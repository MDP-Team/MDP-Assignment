package uom.ict.mdp;

/**
 * Created by DodoSerebro on 15/12/2014.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Where all the EventInfo data will be held. Will be used as intents
 */
public class EventInfoActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);

        setContentView(R.layout.event_info_layout);
        Intent i = getIntent();

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


    }




}
