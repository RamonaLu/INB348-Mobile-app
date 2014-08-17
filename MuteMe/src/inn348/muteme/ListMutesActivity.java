package inn348.muteme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ListMutesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_mutes);
		
		ListView muteListView = (ListView)findViewById(R.id.muteListView);
		String[] muteListData = new String[]{"Time and Location1","Time1","Location1"};
		ListAdapter mutesAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, muteListData);
		
		muteListView.setAdapter(mutesAdapter);
		
		Button createMuteButton = (Button)findViewById(R.id.createMuteButton);
		
		OnClickListener createMuteListener = new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				Intent newMute = new Intent(v.getContext(), MuteActivity.class);
				startActivity(newMute);
			}
			
		};
		createMuteButton.setOnClickListener(createMuteListener);
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
