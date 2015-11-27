package com.cbkj.rrh.ui.more;

import android.os.Bundle;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;

/**
 * 反馈与帮助
 * @author jason
 * @data 2015-11-26
 */
public class ReactionActivity extends BaseActivity {
	
	private TitleBar titleBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_reaction);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.reaction_title);
	}
}
