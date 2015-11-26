package com.cbkj.rrh.view.me;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.view.AbstractBannerView;
/**
 * 我的--顶部切换view
 * */
public class MeTopView extends AbstractBannerView{

	public MeTopView(Context context) {
		super(context);
	}

	public MeTopView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MeTopView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public void createView(List<View> viewList) {
		super.createView(viewList);
	}
	@Override
	protected int getIndicatorUnfocusedIcon() {
		return R.drawable.me_indicator_unfocused;
	}

	@Override
	protected int getIndicatorFocusedIcon() {
		return R.drawable.me_indicator_focused;
	}
}
