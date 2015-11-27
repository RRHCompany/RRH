package com.cbkj.rrh.adapter.contacts;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.adapter.AbstractBaseAdapter;
import com.cbkj.rrh.bean.Group;

public class ContactsGroupAdapter extends AbstractBaseAdapter<Group> {
	
    public ContactsGroupAdapter(Context context, List<Group> friends) {
        super(context,friends);
    }
  
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	Group group=list.get(position);
    	ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
    		convertView=mInflater.inflate(R.layout.a_contact_group_listview_item, null);
    		viewHolder.iconView=(ImageView)convertView.findViewById(R.id.contact_group_listview_iocn_item);
    		viewHolder.groupNameView=(TextView)convertView.findViewById(R.id.ccontact_group_listview_groupName_item);
    		viewHolder.typeView=(ImageView)convertView.findViewById(R.id.contact_group_listview_type_item);
    		convertView.setTag(viewHolder);
    	}else{
    		viewHolder=(ViewHolder)convertView.getTag();
    	}
		viewHolder.groupNameView.setText(group.getGroupName());
		if(group.getType()==1){
			//核心群
			viewHolder.typeView.setVisibility(View.VISIBLE);
			viewHolder.typeView.setImageResource(R.drawable.contacts_group_core_icon);
		}else if(group.getType()==2){
			//副群
			viewHolder.typeView.setVisibility(View.VISIBLE);
			viewHolder.typeView.setImageResource(R.drawable.contacts_group_deputy_icon);
		}else{
			//普通群
			viewHolder.typeView.setVisibility(View.GONE);
			viewHolder.typeView.setImageDrawable(null);
		}
		
    	return convertView;
    }
    
    public static class ViewHolder {
        public TextView groupNameView;
        public ImageView iconView;
        public ImageView typeView;
    }
}
