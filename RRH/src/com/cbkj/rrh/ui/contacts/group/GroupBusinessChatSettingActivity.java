package com.cbkj.rrh.ui.contacts.group;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.adapter.contacts.group.CommentGroupMemberAdapter;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;
import com.cbkj.rrh.bean.Friend;

/**
 * 认证群设置
 * @author jason
 * @data 2015-11-26
 */
public class GroupBusinessChatSettingActivity extends BaseActivity implements TitleBar.TitleBarListener {
	
	private TitleBar titleBar;
	
	private GridView friendsGridView;
	private CommentGroupMemberAdapter adapter;
	private GroupBusinessChatSettingPopupMenu popupMenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_group_business_chat_setting);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.contact_group_business_chat_setting_title);
		titleBar.setOther("更多", 0, null);
		titleBar.addTitleBarListener(this);
		
		friendsGridView=(GridView)this.findViewById(R.id.group_business_chat_setting_friends_gv);
		List<Friend> list=new ArrayList<Friend>();
		for(int i=1;i<8;i++){
			list.add(new Friend(i, "昵称"+i, R.drawable.me_head_icon));
		}
		list.add(new Friend(0, null, R.drawable.contacts_group_add_friend_icon));
		adapter=new CommentGroupMemberAdapter(this, list);
		friendsGridView.setAdapter(adapter);
	}

	@Override
	public void onHeaderOtherButton(View v) {
		if(popupMenu==null){
			popupMenu=new GroupBusinessChatSettingPopupMenu(this);
		}
		popupMenu.showLocation(R.id.header_other_view);
	}
	
}
