package ca.uoftdev.backend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChildrenAdapter extends BaseAdapter {
	
	private Child[] data;

	@Override
	public int getCount() {
		return data == null ? 0 : data.length;
	}

	@Override
	public Child getItem(int position) {
		return data[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = prepareView(convertView, parent);
		
		// fill it in
		populateView(position, convertView);
		
		return convertView;
	}

	public void populateView(int position, View convertView) {
		Child item = getItem(position);
		TextView textView = (TextView) convertView.findViewById(R.id.list_item_text);
		textView.setText(item.getKind());
	}

	public View prepareView(View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.list_item, parent, false);
		}
		return convertView;
	}


	public void updateData(Child[] data) {
		this.data = data;
		notifyDataSetChanged();
	}
	
}
