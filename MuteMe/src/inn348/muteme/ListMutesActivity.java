package inn348.muteme;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListMutesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_mutes);
		
		ListView muteListView = (ListView)findViewById(R.id.muteListView);
		String[] muteListData = new String[]{"Time and Location1","Time1","Location1"};
		ListAdapter mutesAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, muteListData);
		
		muteListView.setAdapter(mutesAdapter);
	}
}
