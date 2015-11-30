package com.cbkj.rrh.ui.contacts.persion;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 个人资料
 * @author jason
 * @data 2015-11-26
 */
public class PersionInfoMainActivity extends BaseActivity  {
	private TitleBar titleBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_persion_info_main);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this);
		titleBar.setTitle("张三");
		titleBar.setOther("更多", 0, null);
	}
}
