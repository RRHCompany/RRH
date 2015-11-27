package com.cbkj.rrh.adapter.contacts;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.adapter.AbstractBaseAdapter;
import com.cbkj.rrh.bean.Business;

public class ContactsCombineBusinessAdapter extends AbstractBaseAdapter<Business> {
	
    public ContactsCombineBusinessAdapter(Context context, List<Business> list) {
        super(context,list);
    }
  
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	Business business=list.get(position);
    	ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
    		convertView=mInflater.inflate(R.layout.a_contact_combine_business_listview_item, null);
    		viewHolder.iconView=(ImageView)convertView.findViewById(R.id.contact_combine_business_item_iocn);
    		viewHolder.nameView=(TextView)convertView.findViewById(R.id.ccontact_combine_business_item_name);
    		convertView.setTag(viewHolder);
    	}else{
    		viewHolder=(ViewHolder)convertView.getTag();
    	}
		viewHolder.nameView.setText(business.getName());
		
    	return convertView;
    }
    
    public static class ViewHolder {
        public TextView nameView;
        public ImageView iconView;
    }
}
