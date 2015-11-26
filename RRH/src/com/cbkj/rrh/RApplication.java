package com.cbkj.rrh;

import io.rong.imkit.RongIM;
import android.app.Application;

import com.cbkj.rrh.comment.utils.SystemUtils;

public class RApplication extends Application{
	@Override
    public void onCreate() {
        super.onCreate();
        /**注意：IMKit SDK调用第一步 初始化,只有两个进程需要初始化，主进程和 push 进程*/
        if(SystemUtils.isCurProcess(getApplicationContext()) ||
           "io.rong.push".equals(SystemUtils.getCurProcessName(getApplicationContext()))) {
            RongIM.init(this);
            /**
             * 融云SDK事件监听处理
             * 注册相关代码，只需要在主进程里做。
             */
            if ("com.cbkj.rrh".equals(SystemUtils.getCurProcessName(getApplicationContext()))) {
//                RongCloudEvent.init(this);
//                DemoContext.init(this);
//                Thread.setDefaultUncaughtExceptionHandler(new RongExceptionHandler(this));
//                try {
//                    RongIM.registerMessageType(DemoCommandNotificationMessage.class);
//                    RongIM.registerMessageType(DeAgreedFriendRequestMessage.class);
//                    RongIM.registerMessageTemplate(new ContactNotificationMessageProvider());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
