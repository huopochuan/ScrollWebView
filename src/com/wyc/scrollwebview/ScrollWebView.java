package com.wyc.scrollwebview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class ScrollWebView extends WebView{

	private OnScrollChangeListener listener;
	public void setListener(OnScrollChangeListener listener) {
		this.listener = listener;
	}
	public ScrollWebView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
	}
	public ScrollWebView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	
	}
	public ScrollWebView(Context context) {
		this(context, null);
		
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		
		super.onScrollChanged(l, t, oldl, oldt);
		int direction=t>oldt?1:0; 
		//1表示正向下显示信息
		if(listener!=null){
			listener.onScrollchange(t,direction);
		}
	}
	
	public interface OnScrollChangeListener{
		public void onScrollchange(int y,int direction);
			
		
	}
	
}
