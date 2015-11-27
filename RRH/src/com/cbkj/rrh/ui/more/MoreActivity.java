package com.cbkj.rrh.ui.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 设置主页面
 * @author jason
 * @data 2015-11-26
 */
public class MoreActivity extends BaseActivity implements OnClickListener {
	
	private TitleBar titleBar;
	
	private View myBusinessBtn,authCentreBtn,bindSocialAccountBtn,reactionBtn,settingBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_more);
		this.initView();
		this.initListener();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.more_title);
		myBusinessBtn=this.findViewById(R.id.more_my_business_rl);
		authCentreBtn=this.findViewById(R.id.more_auth_centre_btn);
		bindSocialAccountBtn=this.findViewById(R.id.more_bind_social_account_btn);
		reactionBtn=this.findViewById(R.id.more_reaction_btn);
		settingBtn=this.findViewById(R.id.more_setting_btn);
	}
	private void initListener(){
		myBusinessBtn.setOnClickListener(this);
		authCentreBtn.setOnClickListener(this);
		bindSocialAccountBtn.setOnClickListener(this);
		reactionBtn.setOnClickListener(this);
		settingBtn.setOnClickListener(this);
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
			case R.id.more_bind_social_account_btn:
				//绑定社交账号
				intent=new Intent(this,BindSocialAccountActivity.class);
				this.startActivity(intent);
				break;
			case R.id.more_reaction_btn:
				//反馈与帮助
				intent=new Intent(this,ReactionActivity.class);
				this.startActivity(intent);
				break;
			case R.id.more_setting_btn:
				//设置
				intent=new Intent(this,SettingActivity.class);
				this.startActivity(intent);
				break;
			}
		
	}
}
