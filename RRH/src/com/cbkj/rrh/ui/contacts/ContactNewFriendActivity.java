package com.cbkj.rrh.ui.contacts;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.adapter.contacts.ContactsNewFriendAdapter;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;
import com.cbkj.rrh.bean.Friend;

/**
 * 新的好友
 * @author jason
 * @data 2015-11-26
 */
public class ContactNewFriendActivity extends BaseActivity implements TitleBar.TitleBarListener  {
	private TitleBar titleBar;
	private ListView listView;
	private ContactsNewFriendAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_new_friend);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.home_contact_new_friend_title);
		titleBar.setOther("", R.drawable.home_add_friend_icon, null);
		titleBar.addTitleBarListener(this);
		
		listView=(ListView)this.findViewById(R.id.contact_new_friend_listview);
		List<Friend> list=new ArrayList<Friend>();
		for(int i=0;i<10;i++){
			list.add(new Friend(i, "老实人"+i,null));
		}
		adapter=new ContactsNewFriendAdapter(this, list);
		listView.setAdapter(adapter);
	}

	@Override
	public void onHeaderOtherButton(View v) {
		//添加好友
		Intent intent=new Intent(this,ContactAddActivity.class);
		this.startActivity(intent);
	}
}
