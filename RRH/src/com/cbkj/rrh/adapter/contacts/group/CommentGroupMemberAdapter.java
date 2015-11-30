package com.cbkj.rrh.adapter.contacts.group;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.adapter.AbstractBaseAdapter;
import com.cbkj.rrh.bean.Friend;
/**
 * 组成员 公共 adapter
 * */
public class CommentGroupMemberAdapter extends AbstractBaseAdapter<Friend> {
	
    public CommentGroupMemberAdapter(Context context, List<Friend> list) {
        super(context,list);
    }
  
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	Friend friend=list.get(position);
    	ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
    		convertView=mInflater.inflate(R.layout.a_comment_contact_group_member_gridview_item, null);
    		viewHolder.imageView=(ImageView)convertView.findViewById(R.id.comment_contact_group_member_item_iv);
    		convertView.setTag(viewHolder);
    	}else{
    		viewHolder=(ViewHolder)convertView.getTag();
    	}
		viewHolder.imageView.setImageResource(friend.getPortraitResId());
    	return convertView;
    }
    
    public static class ViewHolder {
        public ImageView imageView;
    }
}
