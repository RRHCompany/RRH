
package com.cbkj.rrh.ui.main;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.adapter.AbstractBaseAdapter;

public class MainMenuAdapter extends AbstractBaseAdapter<MenuBean> {

	public MainMenuAdapter(Context context, List<MenuBean> list) {
		super(context, list);
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		final MainMenuHolder holder;
		final MenuBean menuBean=list.get(position);
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.a_main_menu_item_view, null);
			holder = new MainMenuHolder();
			holder.imageView=(ImageView)convertView.findViewById(R.id.main_menu_item_image_view);
			holder.nameView=(TextView)convertView.findViewById(R.id.main_menu_item_name_view);
			convertView.setTag(holder);
		} else {
			holder = (MainMenuHolder) convertView.getTag();
		}
		holder.imageView.setImageResource(menuBean.getImageRes());
		holder.nameView.setText(menuBean.getName());
		return convertView;
	}

	class MainMenuHolder {
		ImageView imageView;
		TextView nameView;
	}
}
