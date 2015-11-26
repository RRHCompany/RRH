package com.cbkj.rrh.base.fragment;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
/**
 * 基础菜单Fragment. <br/>
 * @version 1.0
 * @since JDK 1.6
 */
public abstract class BaseFragment extends Fragment {

	/** TAG */
	private static final String TAG = BaseFragment.class.getSimpleName();

	/** Tag */
	protected String tag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 检查DBManager
//		checkDBManager();
		super.onCreate(savedInstanceState);
		this.tag = this.getClass().getSimpleName();
	}

	/**
	 * 替换ChildFragment(新构造). <br/>
	 * 
	 * @param fragmentContainerID
	 *            fragment 所在的容器ID
	 * @param fragmentClass
	 * @since JDK 1.6
	 */
	protected void replaceChildFragment(int fragmentContainerID,
			Class<BaseFragment> fragmentClass) {
		try {
			FragmentTransaction ft = this.getChildFragmentManager().beginTransaction();
			ft.replace(fragmentContainerID, fragmentClass.newInstance());
			ft.commit();
		} catch (java.lang.InstantiationException e) {
			Log.e(TAG, "replaceFragment error", e);
		} catch (InstantiationException e) {
			Log.e(TAG, "replaceFragment error", e);
		} catch (IllegalAccessException e) {
			Log.e(TAG, "replaceFragment error", e);
		}
	}

	/**
	 * 替换ChildFragment. <br/>
	 * @param fragmentContainerID
	 *            fragment 所在的容器ID
	 * @param fragmentClass
	 * @since JDK 1.6
	 */
	public void replaceChildFragment(int fragmentContainerID,
			BaseFragment baseFragment) {
		try {
			FragmentTransaction ft = this.getChildFragmentManager()
					.beginTransaction();
			ft.replace(fragmentContainerID, baseFragment);
			ft.commit();
		} catch (Exception e) {
			Log.e(TAG, "replaceFragment error", e);
		}
	}
	/**
	 * 修复Android fragment嵌套的Bug.<br />
	 * https://code.google.com/p/android/issues/detail?id=42601<br />
	 * <pre>
	 * http://stackoverflow.com/questions/15207305/getting-the-error-java-lang-illegalstateexception-activity-has-been-destroyed
	 * </pre>
	 * @see cn.com.zte.android.app.fragment.BaseFragment#onDetach()
	 */
	@Override
	public void onDetach() {
		super.onDetach();
		try {
			Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
