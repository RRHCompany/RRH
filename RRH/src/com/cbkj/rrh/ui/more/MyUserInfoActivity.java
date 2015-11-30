package com.cbkj.rrh.ui.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;
import com.cbkj.rrh.ui.home.UploadImageActivity;

/**
 * 编辑资料
 * @author jason
 * @data 2015-11-26
 */
public class MyUserInfoActivity extends BaseActivity implements OnClickListener{
	
	private TitleBar titleBar;
	private ImageView portraitView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_my_user_info);
		this.initView();
		this.initListener();
//		UploadImageActivity
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.my_user_info_title);
		
		portraitView=(ImageView)this.findViewById(R.id.my_user_info_portrait_iv);
	}
	
	private void initListener(){
		portraitView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.my_user_info_portrait_iv:
			Intent intent=new Intent(this,UploadImageActivity.class);
			this.startActivity(intent);
			break;
		}
	}
}
