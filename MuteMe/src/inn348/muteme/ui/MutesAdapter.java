package inn348.muteme.ui;

import inn348.muteme.model.ChronoCondition;
import inn348.muteme.model.GeoCondition;
import inn348.muteme.model.Mute;
import inn348.muteme.R;

import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class MutesAdapter extends BaseAdapter {
    private LayoutInflater inflater;
 
    private List<Mute> mutes;
    private Context context;
    
    public MutesAdapter(Context context, List<Mute> mutes) {
    	this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.mutes = mutes;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.two_line_list_item, parent, false);
        }
        TextView titleView = (TextView) convertView.findViewById(android.R.id.text1);
        TextView subTitleView = (TextView) convertView.findViewById(android.R.id.text2);
 
        Mute mute = mutes.get(position);
        GeoCondition geoCondition = mute.getGeoCondition();
        ChronoCondition chronoCondition = mute.getChronoCondition();  
        
        String title = geoCondition==null? 
        		context.getString(R.string.geo_everywhere) 
        		: (geoCondition.getLatitude() + ", " + geoCondition.getLongitude());
        titleView.setText(title);

        String subTitle = chronoCondition == null?
        		context.getString(R.string.chrono_always) 
        		: (chronoCondition.getTimeSpan().toString());
        subTitleView.setText(subTitle);
        
        return convertView;
    }
 
    public int getCount() {
        return mutes.size();
    }
 
    public Object getItem(int arg0) {
        return mutes.get(arg0);
    }
 
    public long getItemId(int arg0) {
        return arg0;
    }
}
