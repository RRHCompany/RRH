package com.cbkj.rrh.ui.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 绑定社交账号
 * @author jason
 * @data 2015-11-26
 */
public class BindSocialAccountActivity extends BaseActivity implements OnClickListener {
	
	private TitleBar titleBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_bind_social_account);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.bind_social_account_title);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent=null;
		switch(v.getId()){
			case R.id.more_my_business_rl:
				//我的企业
				intent=new Intent(this,MyBusinessActivity.class);
				this.startActivity(intent);
				break;
			case R.id.more_auth_centre_btn:
				//认证中心
				intent=new Intent(this,AuthCentreActivity.class);
				this.startActivity(intent);
				break;
			}
	}
}
