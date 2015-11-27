package com.cbkj.rrh.code.im.rong;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.RongIMClient.ErrorCode;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.cbkj.rrh.comment.utils.SystemUtils;
import com.cbkj.rrh.ui.main.MainActivity;

public class RongCore {
	/**
	 * 建立与融云服务器的连接
	 * @param token
	 */
	public static void connect(final Context context,String token) {
	    if (SystemUtils.isCurProcess(context)) {
	        /**IMKit SDK调用第二步,建立与服务器的连接*/
	        RongIM.connect(token, new RongIMClient.ConnectCallback() {
	        	@Override
	        	public void onFail(ErrorCode errorCode) {
	        		super.onFail(errorCode);
	        		Toast.makeText(context, "连接失败："+errorCode.getMessage(), Toast.LENGTH_SHORT).show();
	        	}
	        	@Override
	        	public void onFail(int errorCode) {
	        		super.onFail(errorCode);
	        		Toast.makeText(context, "连接失败："+errorCode, Toast.LENGTH_SHORT).show();
	        	}
	        	@Override
	        	public void onCallback(String t) {
	        		super.onCallback(t);
	        		Toast.makeText(context, "连接失败回调："+t, Toast.LENGTH_SHORT).show();
	        	}
	            /**Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token*/
	            @Override
	            public void onTokenIncorrect() {
	                Toast.makeText(context, "Token 已经过期", Toast.LENGTH_SHORT).show();
	            }
	            /**
	             * 连接融云成功
	             * @param userid 当前 token
	             */
	            @Override
	            public void onSuccess(String userid) {
	                Intent intent=new Intent(context,MainActivity.class);
	                context.startActivity(intent);
//	                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//	                finish();
	            }
	            /**
	             * 连接融云失败
	             * @param errorCode 错误码，可到官网 查看错误码对应的注释
	             */
	            @Override
	            public void onError(RongIMClient.ErrorCode errorCode) {
	                Toast.makeText(context, "连接失败："+errorCode.getMessage(), Toast.LENGTH_SHORT).show();
	                Intent intent=new Intent(context,MainActivity.class);
	                context.startActivity(intent);
	            }
	        });
	    }
	}
}
