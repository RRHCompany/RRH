package com.cbkj.rrh.ui.more;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 账号与安全
 * @author jason
 * @data 2015-11-26
 */
public class AccountSecureActivity extends BaseActivity {
	
	private TitleBar titleBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_account_secure);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.account_secure_title);
	}
}
