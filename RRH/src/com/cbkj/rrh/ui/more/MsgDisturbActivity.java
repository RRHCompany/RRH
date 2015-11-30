package com.cbkj.rrh.ui.more;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 消息免打扰
 * @author jason
 * @data 2015-11-26
 */
public class MsgDisturbActivity extends BaseActivity {
	
	private TitleBar titleBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_msg_disturb);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.msg_disturb_title);
	}
}
