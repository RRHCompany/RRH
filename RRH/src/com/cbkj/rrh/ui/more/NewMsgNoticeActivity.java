package com.cbkj.rrh.ui.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 新消息通知
 * @author jason
 * @data 2015-11-26
 */
public class NewMsgNoticeActivity extends BaseActivity implements OnClickListener{
	
	private TitleBar titleBar;
	private View distrubBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_new_msg_notice);
		this.initView();
		this.initListener();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.new_msg_notice_title);
		distrubBtn=this.findViewById(R.id.new_msg_notice_distrub_btn);
	}
	private void initListener(){
		distrubBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.new_msg_notice_distrub_btn:
			//消息免打扰
			Intent intent=new Intent(this,MsgDisturbActivity.class);
			this.startActivity(intent);
			break;
		}
	}
}
