package com.cbkj.rrh.adapter.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.adapter.AbstractBaseAdapter;
import com.cbkj.rrh.bean.Friend;

public class ContactsCreateGroupAdapter extends AbstractBaseAdapter<Friend> {
	
	private Map<String,Integer> letterIndexMap=new HashMap<String,Integer>();;
	
	private static int typeCount=2;
	
	private static int TYPE_0=0;//好友
	
	private static int TYPE_1=1;//A/B/C/D....
	
    public ContactsCreateGroupAdapter(Context context, List<Friend> friends) {
        super(context,friends);
    }
  
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	Friend friend=list.get(position);
    	int viewType=getItemViewType(position);
    	switch(viewType){
	    	case 0:
	    		FriendHolder friendHolder=null;
	    		if(convertView==null){
	    			friendHolder=new FriendHolder();
	        		convertView=mInflater.inflate(R.layout.a_contact_create_group_listview_item, null);
	        		friendHolder.iconView=(ImageView)convertView.findViewById(R.id.contact_create_group_item_user_iocn);
	        		friendHolder.nickNameView=(TextView)convertView.findViewById(R.id.contact_create_group_item_nickName);
	        		friendHolder.relationView=(TextView)convertView.findViewById(R.id.contact_create_group_item_relation);
	        		convertView.setTag(friendHolder);
	        	}else{
	        		friendHolder=(FriendHolder)convertView.getTag();
	        	}
	    		friendHolder.nickNameView.setText(friend.getNickName());
	    		if(friend.getPortraitResId()!=0){
	    			friendHolder.iconView.setImageResource(friend.getPortraitResId());
	    		}else{
	    			friendHolder.iconView.setImageDrawable(null);
	    		}
	    		break;
	    	case 1:
	    		TextHolder textHolder=null;
	    		if(convertView==null){
	    			textHolder=new TextHolder();
	        		convertView=mInflater.inflate(R.layout.a_comment_contact_listview_text_item, null);
	        		textHolder.textView=(TextView)convertView.findViewById(R.id.contact_listview_text_item);
	        		convertView.setTag(textHolder);
	        	}else{
	        		textHolder=(TextHolder)convertView.getTag();
	        	}
	    		textHolder.textView.setText(friend.getNickName());
	    		break;
    	}
    	return convertView;
    }
    @Override
    public int getItemViewType(int position) {
    	int userID=list.get(position).getUserId();
    	if(userID==0){
    		//A,B,C....
    		return TYPE_1;
    	}else{
    		return TYPE_0;
    	}
    }
    public Map<String, Integer> getLetterIndexMap() {
		return letterIndexMap;
	}
    @Override
    public void setList(List<Friend> list) {
    	letterIndexMap.clear();
    	List<Friend> friendsList=this.sortFriends(list);
    	super.setList(friendsList);
    }
    
    /**好友数据排序 */
    private ArrayList<Friend> sortFriends(List<Friend> list) {
        String[] letters = mContext.getResources().getStringArray(R.array.search_letters);
        HashMap<String, ArrayList<Friend>> userMap = new HashMap<String, ArrayList<Friend>>();
        for (Friend friend : list) {
            String letter = new String(new char[]{friend.getSearchKey()});
            if (userMap.containsKey(letter)) {
                ArrayList<Friend> friendList = userMap.get(letter);
                friendList.add(friend);
            } else {
                ArrayList<Friend> friendList = new ArrayList<Friend>();
                friendList.add(friend);
                userMap.put(letter, friendList);
            }
        }
        ArrayList<Friend> friendList = new ArrayList<Friend>();
        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            ArrayList<Friend> fArrayList = userMap.get(letter);
            if (fArrayList != null) {
            	letterIndexMap.put(letter, friendList.size());
            	friendList.add(new Friend(0, letter, null));
            	friendList.addAll(fArrayList);
            }
        }
        return friendList;
    }

	@Override
    public int getViewTypeCount() {
    	return typeCount;
    }
    public static class FriendHolder {
        public TextView nickNameView;
        public ImageView iconView;
        public TextView relationView;
    }
    public static class TextHolder {
        public TextView textView;
    }
}
