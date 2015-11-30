package com.cbkj.rrh.ui.contacts.persion;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 个人聊天设置
 * @author jason
 * @data 2015-11-26
 */
public class PersionChatSettingActivity extends BaseActivity  {
	private TitleBar titleBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_persion_chat_setting);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.contact_persion_chat_setting_title);
	}
}
