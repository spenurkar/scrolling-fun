package com.demo.scrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObservableScrollView extends ScrollView{

	private ScrollViewListener scrollViewListener;
	
	public ObservableScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public ObservableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }
    
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
    	super.onScrollChanged(l, t, oldl, oldt);
    	if(scrollViewListener!=null){
    		scrollViewListener.onScrollChanged(this, l, t, oldl, oldt);
    	}
    }

}
