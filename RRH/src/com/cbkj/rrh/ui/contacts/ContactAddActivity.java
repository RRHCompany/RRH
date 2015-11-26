package com.cbkj.rrh.ui.contacts;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 添加好友
 * @author jason
 * @data 2015-11-26
 */
public class ContactAddActivity extends BaseActivity  {
	private TitleBar titleBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_add_friend);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.home_contact_add_friend_title);
	}
}
