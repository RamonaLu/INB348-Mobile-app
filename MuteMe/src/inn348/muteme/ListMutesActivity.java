package inn348.muteme;

import java.util.EnumSet;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListMutesActivity extends Activity {

	Button createMuteButton;
	ListView muteListView;
	ListAdapter mutesAdapter;
	
	private Mute[] GetMutes(){
		EnumSet<DayOfWeek> weekdays = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);	
		TimeSpan morning = new TimeSpan(new TimeOfDay(6, 30), new TimeOfDay(9, 30));
		Location home = new Location("-27.455620, 153.059356");
		
		Mute[] sampleMutes = new Mute[] {
			new Mute(
				new GeoCondition(home, 50),
				new ChronoCondition(morning, weekdays)
			)
		};
		return sampleMutes;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_mutes);
		
		muteListView = (ListView)findViewById(R.id.muteListView);
		createMuteButton = (Button)findViewById(R.id.createMuteButton);
				
		mutesAdapter = new ArrayAdapter<Mute> (this, android.R.layout.simple_list_item_1, GetMutes());		
		muteListView.setAdapter(mutesAdapter);
		
		RegisterListeners();
	}

	private void RegisterListeners() {
		createMuteButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				Intent newMute = new Intent(v.getContext(), MuteActivity.class);
				startActivity(newMute);
			}
			
		});
		muteListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int arg2,
					long arg3) {
				Intent editMute = new Intent(ListMutesActivity.this,MuteActivity.class);
				startActivity(editMute);
			}
		});
		
		registerForContextMenu(muteListView);
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
	   	ContextMenuInfo menuInfo) {
		
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mute_item_context, menu);
		
	  }
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
	    switch (item.getItemId()) {
	        case R.id.menu_edit:
	            editMute();
	            return true;
	        case R.id.menu_delete:
	            deleteMute();
	            return true;
	        default:
	            return super.onContextItemSelected(item);
	    }
	}

	private void deleteMute() {
		// TODO Auto-generated method stub
		
	}

	private void editMute() {
		// TODO Auto-generated method stub
		
	}
	
}
