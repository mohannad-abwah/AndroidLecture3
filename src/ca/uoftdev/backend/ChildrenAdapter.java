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
		ViewHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.list_item, parent, false);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// fill it in
		Child item = getItem(position);
		holder.textView.setText(item.getKind());

		return convertView;
	}

	public void updateData(Child[] data) {
		this.data = data;
		notifyDataSetChanged();
	}

	private static class ViewHolder {

		private TextView textView;

		public ViewHolder(View convertView) {
			this.textView = (TextView) convertView.findViewById(R.id.list_item_text);
		}

	}

}
