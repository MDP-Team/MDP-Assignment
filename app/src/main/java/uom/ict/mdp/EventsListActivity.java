package uom.ict.mdp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by DodoSerebro on 08/12/2014.
 */
public class EventsListActivity extends Activity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_list_item);

    }

}



