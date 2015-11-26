
package com.cbkj.rrh.base.adapter;

import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/**
 * adapter 基类
 * @author jason
 * @data 2015-11-24
 * */
public abstract class AbstractBaseAdapter<T> extends BaseAdapter {
	
	protected Context mContext;
	protected LayoutInflater mInflater;
	protected List<T> list;
	
	public AbstractBaseAdapter(Context context, List<T> list) {
		this.mContext = context;
		this.list = list;
		 if (context != null){
			 mInflater = LayoutInflater.from(context);
		 }
	}
	@Override
	public int getCount() {
		return list.size();
	}
	@Override
	public T getItem(int position) {
		return list.get(position);
	}
	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}
	public void setList(List<T> list){
		this.list=list;
	}
	public List<T> getList(){
		return this.list;
	}
	/**添加一个*/
	public void add(T object){
		this.list.add(object);
	}
	/**添加数组*/
	public void addAll(Collection<? extends T> collection){
		this.list.addAll(collection);
	}
	/**清空所有*/
	public void clearAll(){
		this.list.clear();
	}
	
	public int getSize(){
		return this.list.size();
	}
}
