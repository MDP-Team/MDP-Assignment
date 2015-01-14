package uom.ict.mdp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
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

    public View getView (int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(resource,parent,false);
        }

		Event e = objects.get(position);

        TextView eventName = (TextView) convertView.findViewById(R.id.event_name_info);
        eventName.setText("Event Name: " + e.getName());

        TextView streetName = (TextView) convertView.findViewById(R.id.street_name_info);
        streetName.setText("Location: " + e.getLocation());

        TextView time = (TextView) convertView.findViewById(R.id.time_info);
		SimpleDateFormat dateFormat = new SimpleDateFormat("K:mm");
        time.setText("Time: " + dateFormat.format(e.getTime()) + " - " + dateFormat.format(e.getEndTime()));

        TextView ageText = (TextView) convertView.findViewById(R.id.category_info);
		ageText.setText("Age Group: " + e.getAgeType());

        return convertView;
    }
}
