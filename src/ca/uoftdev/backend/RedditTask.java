package ca.uoftdev.backend;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class RedditTask extends AsyncTask<Void, Void, RedditModel> {
	
	private final Activity activity;
	private ChildrenAdapter adapter;

	public RedditTask(Activity activity, ChildrenAdapter adapter) {
		this.activity = activity;
		this.adapter = adapter;
	}

	@Override
	protected RedditModel doInBackground(Void... params) {
		try {
			URL url = new URL("http://www.reddit.com/.json");
			InputStream stream = url.openStream();
			
			Gson gson = new Gson();
			InputStreamReader inputStreamReader = new InputStreamReader(stream);
			JsonReader jsonReader = new JsonReader(inputStreamReader);
			
			RedditModel model = gson.fromJson(jsonReader, RedditModel.class);
			return model;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(RedditModel result) {
		super.onPostExecute(result);
		if (activity.isDestroyed() || activity.isFinishing())
			return;
		
		adapter.updateData(result.getChildren());
	}
}
