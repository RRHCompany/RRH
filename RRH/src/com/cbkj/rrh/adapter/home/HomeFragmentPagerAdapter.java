package com.cbkj.rrh.adapter.home;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.cbkj.rrh.comment.utils.SystemUtils;
import com.cbkj.rrh.ui.contacts.ContactFragment;
import com.cbkj.rrh.ui.home.CloudTeamFragment;

public class HomeFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

	private Context mContext;
	private Fragment messageFragment;
	private Fragment contactFragment;
	private Fragment cloudTeamFragment;
	 /**
     * 会话列表的fragment
     */
    private Fragment mConversationFragment = null;
	public HomeFragmentPagerAdapter(FragmentManager fm,Context context) {
		super(fm);
		this.mContext=context;
	}

	@Override
	public Fragment getItem(int index) {
		 Fragment fragment = null;
         switch (index) {
             case 0:
//                 if (messageFragment == null) {
//                	 messageFragment = new MessageFragment();
//                 }
//                 fragment = messageFragment;
            	 if (mConversationFragment == null) {
                     ConversationListFragment listFragment = ConversationListFragment.getInstance();
                     Uri uri = Uri.parse("rong://" + SystemUtils.getPackageName(this.mContext)).buildUpon()
                             .appendPath("conversationlist")
                             .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
                             .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//群组
                             .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//讨论组
                             .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")//应用公众服务。
                             .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")//公共服务号
                             .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//系统
                             .build();
                     listFragment.setUri(uri);
                     mConversationFragment = listFragment;
                 }
            	 fragment = mConversationFragment;
                 break;
             case 1:
                 if (contactFragment == null) {
                     fragment = new ContactFragment();
                 } else {
                     fragment = contactFragment;
                 }
                 break;
             case 2:
                 if (cloudTeamFragment == null) {
                     fragment = new CloudTeamFragment();
                 } else {
                     fragment = cloudTeamFragment;
                 }
                 break;
         }
         return fragment;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
