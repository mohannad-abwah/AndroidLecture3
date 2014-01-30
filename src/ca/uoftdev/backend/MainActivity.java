package ca.uoftdev.backend;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private ChildrenAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new ChildrenAdapter();
		
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);

		new RedditTask(this, adapter).execute();
		Log.w(TAG, "blah");
	}
	
}
