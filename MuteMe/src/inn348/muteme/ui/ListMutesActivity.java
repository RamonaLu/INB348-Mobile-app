package inn348.muteme.ui;

import inn348.muteme.R;
import inn348.muteme.model.ChronoCondition;
import inn348.muteme.model.DayOfWeek;
import inn348.muteme.model.GeoCondition;
import inn348.muteme.model.Mute;
import inn348.muteme.model.TimeOfDay;
import inn348.muteme.model.TimeSpan;
import inn348.muteme.persistence.MuteRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListMutesActivity extends Activity {

	Button createMuteButton;
	ListView muteListView;
	MutesAdapter mutesAdapter;
	ArrayList<Mute> mutes;
	MuteRepository muteRepo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_mutes);
		muteRepo = new MuteRepository(this);
		muteListView = (ListView)findViewById(R.id.muteListView);
		createMuteButton = (Button)findViewById(R.id.createMuteButton);
		
		//For testing purposes only. Remove before release.
		muteRepo.Write(MuteRepository.CreateSampleMutes());	
		
		mutes =  new ArrayList<Mute>(Arrays.asList(muteRepo.Read()));
		mutesAdapter = new MutesAdapter(this,mutes);		
		muteListView.setAdapter(mutesAdapter);
		
		RegisterListeners();
	}

	private void RegisterListeners() {
		createMuteButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				ListMutesActivity.this.createMute();
			}
			

		});
		muteListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int pos,
					long id) {
				Mute clickedMute = (Mute)adapterView.getItemAtPosition(pos);
				ListMutesActivity.this.editMute(clickedMute);
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
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		Mute associatedMute = (Mute)mutesAdapter.getItem((int)info.id);
		
	    switch (item.getItemId()) {
	        case R.id.menu_edit:
	            editMute(associatedMute);
	            return true;
	        case R.id.menu_delete:
	            deleteMute(associatedMute);
	            return true;
	        default:
	            return super.onContextItemSelected(item);
	    }
	}

	private void createMute() {
		//TODO: Allow user to edit mute before creating it.
		Mute mute = new Mute();
		mutes.add(mute);
		muteRepo.Write(mutes.toArray(new Mute[mutes.size()]));
		mutesAdapter.notifyDataSetChanged();	
	}
	private void deleteMute(Mute mute) {
		mutes.remove(mute);
		muteRepo.Write(mutes.toArray(new Mute[mutes.size()]));
		mutesAdapter.notifyDataSetChanged();		
	}
	
	private void editMute(Mute mute) {
		
	}
	
}
