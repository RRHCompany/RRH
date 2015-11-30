package com.cbkj.rrh.ui.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 设置
 * @author jason
 * @data 2015-11-26
 */
public class SettingActivity extends BaseActivity implements OnClickListener{
	
	private TitleBar titleBar;
	private View pushNoticeBtn,newMsgNoticeBtn,accountSecureBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_setting);
		this.initView();
		this.initListener();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.setting_title);
		pushNoticeBtn=this.findViewById(R.id.setting_push_notice_btn);
		newMsgNoticeBtn=this.findViewById(R.id.setting_new_msg_notice_btn);
		accountSecureBtn=this.findViewById(R.id.setting_account_secure_btn);
	}
	private void initListener(){
		pushNoticeBtn.setOnClickListener(this);
		newMsgNoticeBtn.setOnClickListener(this);
		accountSecureBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent intent=null;
		switch(v.getId()){
			case R.id.setting_account_secure_btn:
				//账户与安全
				intent=new Intent(this,AccountSecureActivity.class);
				this.startActivity(intent);
				break;
			case R.id.setting_push_notice_btn:
				//推送通知
				intent=new Intent(this,PushNoticeActivity.class);
				this.startActivity(intent);
				break;
			case R.id.setting_new_msg_notice_btn:
				//新消息通知
				intent=new Intent(this,NewMsgNoticeActivity.class);
				this.startActivity(intent);
				break;
				
			}
	}
}
