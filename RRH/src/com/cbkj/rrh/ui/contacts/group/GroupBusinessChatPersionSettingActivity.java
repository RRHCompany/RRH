package com.cbkj.rrh.ui.contacts.group;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 认证群个人设置
 * @author jason
 * @data 2015-11-26
 */
public class GroupBusinessChatPersionSettingActivity extends BaseActivity  {
	
	private TitleBar titleBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_group_business_chat_persion_setting);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.contact_group_business_chat_persion_setting_title);
	}

}
