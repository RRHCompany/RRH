package com.cbkj.rrh.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
/**
 * 无滚动条
 * @author jason
 * */
public class ListViewNoScroll extends ListView {
	public ListViewNoScroll(Context context) {
		super(context);
	}

	public ListViewNoScroll(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ListViewNoScroll(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, mExpandSpec);
	}
}
