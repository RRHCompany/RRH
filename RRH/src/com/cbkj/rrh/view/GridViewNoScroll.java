package com.cbkj.rrh.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/**
 * 无滚动条
 * @author jason
 * */
public class GridViewNoScroll extends GridView {
	public GridViewNoScroll(Context context) {
		super(context);
	}

	public GridViewNoScroll(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GridViewNoScroll(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, mExpandSpec);
	}
}
