package uom.ict.mdp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DodoSerebro on 10/12/2014.
 */
public class EventsListAdapter extends ArrayAdapter<Event> {

    public Context context;
    public int resource;
    public List<Event> objects;


    public EventsListAdapter(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(resource, parent, false);
        }

        ImageView eventIcon = (ImageView) convertView.findViewById(R.id.activity_icon);
        eventIcon.setImageResource(objects.get(position).getIcon());

        TextView eventName = (TextView) convertView.findViewById(R.id.event_name);
        eventName.setText(objects.get(position).getName());

        TextView streetName = (TextView) convertView.findViewById(R.id.street_name);
        streetName.setText("Where: " + objects.get(position).getLocation());

        TextView startTime = (TextView) convertView.findViewById(R.id.start_time);
        startTime.setText("Start Time: " + objects.get(position).getTime());

        TextView endTime = (TextView) convertView.findViewById(R.id.end_time);
        endTime.setText("End Time: " + objects.get(position).getEndTime());

        TextView category = (TextView) convertView.findViewById(R.id.category);
        category.setText("Age Group: " + objects.get(position).getAgeType().toString());

        if (objects.get(position).getAgeType().toString().equals("Children")) {
           convertView.setBackgroundColor(Color.parseColor("#C2E0FF"));
        }
        else if (objects.get(position).getAgeType().toString().equals("General Audience")) {
            convertView.setBackgroundColor(Color.parseColor("#B8E6B8"));
        }
        else {
            convertView.setBackgroundColor(Color.parseColor("#FFC1C1"));
        }

        return convertView;
    }
}
