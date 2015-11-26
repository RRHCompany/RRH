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

public class ContactsAdapter extends AbstractBaseAdapter<Friend> {
	
	private Map<String,Integer> letterIndexMap=new HashMap<String,Integer>();;
	
	private static int typeCount=2;
	
	private static int TYPE_0=0;//好友
	
	private static int TYPE_1=1;//A/B/C/D....
	
	public static int TYPE_ID_GROUP=-1;//群组
	
	public static int TYPE_ID_CREATE_TEAM=-2;//创建企业团队
	
	public static int TYPE_ID_GOODS_BUSINESS=-3;//合作商品企业
	
	public static int TYPE_ID_NEW_FRIEND=-4;//新的好友
	
    public ContactsAdapter(Context context, List<Friend> friends) {
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
	        		convertView=mInflater.inflate(R.layout.a_contact_listview_user_item, null);
	        		friendHolder.iconView=(ImageView)convertView.findViewById(R.id.contact_listview_user_iocn_item);
	        		friendHolder.nickNameView=(TextView)convertView.findViewById(R.id.contact_listview_user_nickName_item);
	        		friendHolder.numberView=(TextView)convertView.findViewById(R.id.contact_listview_user_number_item);
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
	        		convertView=mInflater.inflate(R.layout.a_contact_listview_text_item, null);
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
        friendList.add(new Friend(TYPE_ID_GROUP, mContext.getResources().getString(R.string.home_contact_group), R.drawable.contacts_group_icon));
        friendList.add(new Friend(TYPE_ID_CREATE_TEAM, mContext.getResources().getString(R.string.home_contact_create_team),R.drawable.contacts_create_team_icon));
        friendList.add(new Friend(TYPE_ID_GOODS_BUSINESS, mContext.getResources().getString(R.string.home_contact_goods_business),R.drawable.contacts_goods_business_icon));
        friendList.add(new Friend(TYPE_ID_NEW_FRIEND, mContext.getResources().getString(R.string.home_contact_new_friend), R.drawable.contacts_new_friend_icon));
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
    public Map<String, Integer> getLetterIndexMap() {
		return letterIndexMap;
	}

	public void setLetterIndexMap(Map<String, Integer> letterIndexMap) {
		this.letterIndexMap = letterIndexMap;
	}

	@Override
    public int getViewTypeCount() {
    	return typeCount;
    }
    public static class FriendHolder {
        public TextView nickNameView;
        public ImageView iconView;
        public TextView numberView;
    }
    public static class TextHolder {
        public TextView textView;
    }
}
