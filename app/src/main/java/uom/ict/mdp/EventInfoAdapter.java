package uom.ict.mdp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DodoSerebro on 15/12/2014.
 */

/**
 * Adapter Class to show the necessary information on screen.
 */
public class EventInfoAdapter extends ArrayAdapter<Event>{

    public Context context;
    public int resource;
    public List<Event> objects;

    public EventInfoAdapter(Context context, int resource, int textViewResourceId, List<Event> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public View getView (int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(resource,parent,false);
        }

        TextView eventName = (TextView) convertView.findViewById(R.id.event_name_info);
        eventName.setText("Event Name: " + objects.get(position).getName());

        TextView streetName = (TextView) convertView.findViewById(R.id.street_name_info);
        streetName.setText("Location:" + objects.get(position).getLocation());

        TextView startTime = (TextView) convertView.findViewById(R.id.start_time_info);
        startTime.setText("Start Time: " + objects.get(position).getTime());

        TextView endTime = (TextView) convertView.findViewById(R.id.end_time_info);
        endTime.setText("Start Time: " + objects.get(position).getTime());

        TextView category = (TextView) convertView.findViewById(R.id.category_info);
        category.setText("Category: " + objects.get(position).getAgeType());

        return convertView;
    }
}
