package com.cbkj.rrh.adapter.contacts;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.adapter.AbstractBaseAdapter;
import com.cbkj.rrh.bean.Business;
import com.cbkj.rrh.bean.Friend;

public class ContactsNewFriendAdapter extends AbstractBaseAdapter<Friend> {
	
    public ContactsNewFriendAdapter(Context context, List<Friend> list) {
        super(context,list);
    }
  
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	Friend friend=list.get(position);
    	ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
    		convertView=mInflater.inflate(R.layout.a_contact_new_friend_listview_item, null);
    		viewHolder.iconView=(ImageView)convertView.findViewById(R.id.contact_new_friend_item_iocn);
    		viewHolder.nameView=(TextView)convertView.findViewById(R.id.contact_new_friend_item_nickName);
    		viewHolder.relationView=(TextView)convertView.findViewById(R.id.contact_new_friend_item_relation);
    		viewHolder.addButton=(Button)convertView.findViewById(R.id.contact_new_friend_item_add_btn);
    		convertView.setTag(viewHolder);
    	}else{
    		viewHolder=(ViewHolder)convertView.getTag();
    	}
		viewHolder.nameView.setText(friend.getNickName());
		
    	return convertView;
    }
    
    public static class ViewHolder {
        public TextView nameView;
        public TextView relationView;
        public ImageView iconView;
        public Button addButton;
    }
}
