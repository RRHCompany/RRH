package com.cbkj.rrh.ui.contacts;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.adapter.contacts.ContactsGroupAdapter;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;
import com.cbkj.rrh.bean.Group;

/**
 * 群组
 * @author jason
 * @data 2015-11-26
 */
public class ContactGroupActivity extends BaseActivity implements TitleBar.TitleBarListener  {
	private TitleBar titleBar;
	private ListView listView;
	private ContactsGroupAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_group);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.home_contact_group_title);
		titleBar.setOther("", R.drawable.contacts_create_group_icon, null);
		titleBar.addTitleBarListener(this);
		
		listView=(ListView)this.findViewById(R.id.contact_group_listview);
		List<Group> list=new ArrayList<Group>();
		for(int i=0;i<10;i++){
			list.add(new Group(i, "深圳市xxx科技有限公司"+i, i));
		}
		adapter=new ContactsGroupAdapter(this, list);
		listView.setAdapter(adapter);
	}

	@Override
	public void onHeaderOtherButton(View v) {
		//创建群组
		Intent intent=new Intent(this,ContactCreateGroupActivity.class);
		this.startActivity(intent);
	}
}
