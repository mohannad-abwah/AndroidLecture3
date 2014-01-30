package ca.uoftdev.backend;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class RedditTask extends AsyncTask<Void, Void, String> {
	
	private final Activity activity;

	public RedditTask(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(Void... params) {
		String json = null;
		try {
			URL url = new URL("http://www.reddit.com/.json");
			InputStream stream = url.openStream();
			json = convertStreamToString(stream);
			Log.d("TAG", json);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (activity.isDestroyed() || activity.isFinishing())
			return;
		
		TextView textView = (TextView) activity.findViewById(R.id.text_view);
		textView.setText(result);
	}

	static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    String string = s.hasNext() ? s.next() : "";
	    s.close();
		return string;
	}
	
}
