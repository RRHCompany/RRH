package com.cbkj.rrh.ui.contacts;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 创建团队
 * @author jason
 * @data 2015-11-26
 */
public class ContactCreateTeamActivity extends BaseActivity  {
	private TitleBar titleBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_create_team);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.home_contact_create_team_title);
	}
}
