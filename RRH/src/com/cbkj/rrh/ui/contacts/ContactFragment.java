package com.cbkj.rrh.ui.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.adapter.contacts.ContactsAdapter;
import com.cbkj.rrh.bean.Friend;
import com.cbkj.rrh.widget.SwitchGroup;
import com.cbkj.rrh.widget.SwitchItemView;

/**
 * 通讯录
 * @author jason
 * @data 2015-11-26
 */
public class ContactFragment extends Fragment implements SwitchGroup.ItemHander,  AdapterView.OnItemClickListener {

	private ContactsAdapter adapter;
    private ListView listView;
    private SwitchGroup switchGroup;
    private List<Friend> friendsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a_contact, null);
        listView = (ListView) view.findViewById(R.id.contact_friend_lv);
//        listView.addHeaderView(ViewUtils.getView(getActivity(), R.layout.a_contact_listview_header));
        listView.setFastScrollEnabled(false);
        listView.setHeaderDividersEnabled(false);
        listView.setFooterDividersEnabled(false);
        
        switchGroup = (SwitchGroup) view.findViewById(R.id.contact_friend_pinned);
        this.initListener();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	friendsList = new ArrayList<Friend>();
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "A木头"+i, R.drawable.contacts_default_boy_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "B木头"+i, R.drawable.contacts_default_girl_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "C木头"+i, R.drawable.contacts_default_boy_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "D木头"+i, R.drawable.contacts_default_girl_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "E木头"+i, R.drawable.contacts_default_boy_icon));
        }
        for(int i=1;i<5;i++){
        	friendsList.add(new Friend(i, "F木头"+i, R.drawable.contacts_default_girl_icon));
        }
        adapter = new ContactsAdapter(getActivity(), new ArrayList<Friend>());
        listView.setAdapter(adapter);
        adapter.setList(friendsList);
        adapter.notifyDataSetChanged();
        super.onViewCreated(view, savedInstanceState);
    }

    private void initListener(){
    	listView.setOnItemClickListener(this);
        switchGroup.setItemHander(this);
    }
    @Override
    public void onSwitchGroupItem(SwitchItemView switchItemView) {
    	//单机又边字母时，设置listview位置
    	CharSequence tag = switchItemView.getText();
        if (adapter != null && adapter.getSize()!=0) {
        	Map<String,Integer> letterIndexMap=adapter.getLetterIndexMap();
        	for (String key:letterIndexMap.keySet()) {
				if(key.equals(tag)){
					listView.setSelection(letterIndexMap.get(key));
				}
			}
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    	Friend friend=adapter.getItem(position);
    	if(friend.getUserId()==ContactsAdapter.TYPE_ID_GROUP){
    		//群组
    	}else if(friend.getUserId()==ContactsAdapter.TYPE_ID_CREATE_TEAM){
    		//创建企业团队
    		Intent intent=new Intent(getActivity(),ContactCreateTeamActivity.class);
    		getActivity().startActivity(intent);
    	}else if(friend.getUserId()==ContactsAdapter.TYPE_ID_NEW_FRIEND){
    		//新的好友
    	}
    }
}
