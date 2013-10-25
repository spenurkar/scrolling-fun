package com.demo.scrolling;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity{

	String TAG = "Snehal";
	int scrollBy = 5;
	int scroll_1 = 0;
	int scroll_2 = 0;
	ObservableScrollView scrollView_1;
	ObservableScrollView scrollView_2;
	ObservableScrollView activeScrollView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		scrollView_1 = (ObservableScrollView) findViewById(R.id.scrollview_1);
		scrollView_2 = (ObservableScrollView) findViewById(R.id.scrollview_2);
		
		scrollView_1.setScrollViewListener(new ScrollViewListener() {
			
			@Override
			public void onScrollChanged(ObservableScrollView scrollView, int x, final int y,
					int oldx, final int oldy) {
				// It Works!
				// if(scrollView_1.getScrollY() > 20){
				// Toast.makeText(this, "Hi!", Toast.LENGTH_LONG).show();
				// }
				if (activeScrollView!=null && activeScrollView == scrollView_1) {
					scroll_1 = scrollView_1.getScrollY();
					scroll_2 = scrollView_2.getScrollY();

					if (scroll_1 != 0) {
						scrollView_2.post(new Runnable() {

							@Override
							public void run() {
								scrollBy++;
								if (y < oldy) {
									//Log.d(TAG, "Up");
									scrollBy = -1;
								} else if (y > oldy) {
									//Log.d(TAG, "Down");
									scrollBy = 1;
								}
								scrollView_2.scrollBy(0, scrollBy);
							}
						});
					} else {
						scrollBy = 0;
					}
				}
			}
		});
		
		scrollView_2.setScrollViewListener(new ScrollViewListener() {
			
			@Override
			public void onScrollChanged(ObservableScrollView scrollView, int x, final int y,
					int oldx, final int oldy) {
				// It Works!
				// if(scrollView_1.getScrollY() > 20){
				// Toast.makeText(this, "Hi!", Toast.LENGTH_LONG).show();
				// }
				if (activeScrollView!=null && activeScrollView == scrollView_2) {
					scroll_1 = scrollView_2.getScrollY();
					scroll_2 = scrollView_1.getScrollY();

					if (scroll_2 != 0) {
						scrollView_1.post(new Runnable() {

							@Override
							public void run() {
								scrollBy++;
								if (y < oldy) {
									//Log.d(TAG, "Up");
									scrollBy = -1;
								} else if (y > oldy) {
									//Log.d(TAG, "Down");
									scrollBy = 1;
								}
								scrollView_1.scrollBy(0, scrollBy);
							}
						});
					} else {
						scrollBy = 0;
					}
				}
				
			}
		});

		scrollView_1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					activeScrollView = scrollView_1;
					return true;
				}
				return false;
			}
		});

		scrollView_2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					activeScrollView = scrollView_2;
					return true;
				}
				return false;
			}
		});
	
	}
	

//	public void onScrollChanged(ObservableScrollView scrollView, final int x,
//			final int y, int oldx, final int oldy) {
//
//		// It Works!
//		// if(scrollView_1.getScrollY() > 20){
//		// Toast.makeText(this, "Hi!", Toast.LENGTH_LONG).show();
//		// }
//
//		if (null != activeScrollView) {
//			if (activeScrollView == scrollView_1) {
//				scroll_1 = scrollView_1.getScrollY();
//				scroll_2 = scrollView_2.getScrollY();
//
//				if (scroll_1 != 0) {
//					scrollView_2.post(new Runnable() {
//
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//
//							scrollBy++;
//							if (y < oldy) {
//								Log.d(TAG, "Up");
//								scrollBy = -1;
//							} else if (y > oldy) {
//								Log.d(TAG, "Down");
//								scrollBy = 1;
//							}
//							scrollView_2.scrollBy(0, scrollBy);
//						}
//					});
//				} else {
//					scrollBy = 0;
//				}
//			}
//			else if (activeScrollView == scrollView_2) {
//				scroll_1 = scrollView_2.getScrollY();
//				scroll_2 = scrollView_1.getScrollY();
//
//				if (scroll_2 != 0) {
//					scrollView_1.post(new Runnable() {
//
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//
//							scrollBy++;
//							if (y < oldy) {
//								Log.d(TAG, "Up");
//								scrollBy = -1;
//							} else if (y > oldy) {
//								Log.d(TAG, "Down");
//								scrollBy = 1;
//							}
//							scrollView_1.scrollBy(0, scrollBy);
//						}
//					});
//				} else {
//					scrollBy = 0;
//				}
//			}
//		}
//
//		
//
//		Log.d(TAG, " scroll_1 = " + scroll_1 + " scroll_2 = " + scroll_2);
//		Log.d(TAG, "scrollView_1.getBottom() = " + scrollView_1.getBottom());
//	}

}
