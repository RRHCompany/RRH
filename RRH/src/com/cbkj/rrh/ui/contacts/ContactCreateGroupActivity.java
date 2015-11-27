package com.cbkj.rrh.ui.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.adapter.contacts.ContactsAdapter;
import com.cbkj.rrh.adapter.contacts.ContactsCreateGroupAdapter;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;
import com.cbkj.rrh.bean.Friend;
import com.cbkj.rrh.widget.SwitchGroup;
import com.cbkj.rrh.widget.SwitchItemView;

/**
 * 创建群组
 * 
 * @author jason
 * @data 2015-11-26
 */
public class ContactCreateGroupActivity extends BaseActivity implements SwitchGroup.ItemHander,  AdapterView.OnItemClickListener{

	private TitleBar titleBar;
	private ContactsCreateGroupAdapter adapter;
	private ListView listView;
	private SwitchGroup switchGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_create_group);
		this.initView();
		this.initListener();
	}

	private void initView() {
		titleBar = new TitleBar(this, R.string.home_contact_create_group_title);

		listView = (ListView) this.findViewById(R.id.comment_contact_listview_lv);
		listView.setFastScrollEnabled(false);
		listView.setHeaderDividersEnabled(false);
		listView.setFooterDividersEnabled(false);
		switchGroup = (SwitchGroup) this.findViewById(R.id.comment_contact_listview_pinned);

		
		List<Friend> friendsList = new ArrayList<Friend>();
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "A木头"+i, R.drawable.contacts_default_boy_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "B木头"+i, R.drawable.contacts_default_girl_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "C木头"+i, R.drawable.contacts_default_boy_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "D木头"+i, R.drawable.contacts_default_girl_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "E木头"+i, R.drawable.contacts_default_boy_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "F木头"+i, R.drawable.contacts_default_girl_icon));
        }
		adapter = new ContactsCreateGroupAdapter(this, new ArrayList<Friend>());
		listView.setAdapter(adapter);
		adapter.setList(friendsList);
		adapter.notifyDataSetChanged();
	}
	
	private void initListener() {
		listView.setOnItemClickListener(this);
		switchGroup.setItemHander(this);
	}

	@Override
	public void onSwitchGroupItem(SwitchItemView switchItemView) {
		// 单机又边字母时，设置listview位置
		CharSequence tag = switchItemView.getText();
		if (adapter != null && adapter.getSize() != 0) {
			Map<String, Integer> letterIndexMap = adapter.getLetterIndexMap();
			for (String key : letterIndexMap.keySet()) {
				if (key.equals(tag)) {
					listView.setSelection(letterIndexMap.get(key));
				}
			}
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		Friend friend = adapter.getItem(position);
	}
}
