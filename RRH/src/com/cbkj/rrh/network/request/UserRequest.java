package com.cbkj.rrh.network.request;

import org.json.JSONObject;

import android.content.Context;

import com.cbkj.rrh.network.http.HttpRequest;
import com.cbkj.rrh.network.http.HttpRequestAsyncTask;
import com.cbkj.rrh.network.http.HttpRequestAsyncTask.TaskListenerWithState;
import com.cbkj.rrh.network.http.HttpURL;

/**
 * @todo:用户模块的请求
 * @date:2015-4-20 上午11:50:28
 * @author:hg_liuzl@163.com
 */
public class UserRequest extends HttpRequest {
	private static UserRequest instance = null;

	public synchronized static UserRequest getInstance() {
		if (null == instance)
			instance = new UserRequest();

		return instance;
	}
	/**
	 * 
	 * @todo:获取职业列表
	 * @date:2015-4-20 下午3:44:57
	 * @author:hg_liuzl@163.com
	 * @params:@param mHttpTaskListener
	 * @params:@param context
	 * @params:@param phoneNumber
	 */
	public void requestPositonList(TaskListenerWithState mHttpTaskListener,Context context) {
		setRequestUrl(HttpURL.URL_POSITION_LIST);
		JSONObject body = new JSONObject();
		setBody(body, context);
		new HttpRequestAsyncTask(false,this, mHttpTaskListener, context).execute();
	}
}
