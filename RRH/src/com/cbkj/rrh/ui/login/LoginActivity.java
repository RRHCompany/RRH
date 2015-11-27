package com.cbkj.rrh.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.code.im.rong.RongCore;
import com.cbkj.rrh.ui.main.MainActivity;
/**
 * 登录页面
 * */
public class LoginActivity extends BaseActivity implements OnClickListener {
	private Button loginButton;//登录
	private EditText userNameView,passwordView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_login);
		this.initView();
		this.initListener();
	}

	private void initView() {
		TextView titleView = (TextView) this.findViewById(R.id.header_title_view);
		titleView.setText("登陆");
		userNameView= (EditText) this.findViewById(R.id.me_login_mobile_et);
		passwordView= (EditText) this.findViewById(R.id.me_login_password_et);
		loginButton = (Button) this.findViewById(R.id.me_login_bt);
	}
	
	private void initListener() {
		loginButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(v==loginButton){
			//正常登录
			RongCore.connect(this, "zQzCQAcsG3YMWUJqAswUjHd4E6mTUXoALTP/VaI7U7Bfo203mxcMcWtCfj2k+OEHiUirQ4F1POdaX2P2brnAhw==");
			String mobile = userNameView.getText().toString().trim().toLowerCase();
			String password = passwordView.getText().toString().trim();
			
		}
	}
}
