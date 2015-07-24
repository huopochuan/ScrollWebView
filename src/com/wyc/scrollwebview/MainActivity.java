package com.wyc.scrollwebview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.wyc.scrollwebview.ScrollWebView.OnScrollChangeListener;

public class MainActivity extends Activity implements OnScrollChangeListener {

	private ScrollWebView webview;
	private LinearLayout lly_title;
	private boolean ishade = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		webview = (ScrollWebView) this.findViewById(R.id.webview);
		lly_title = (LinearLayout) this.findViewById(R.id.lly_title);
		webview.loadUrl("http://www.tudou.com");
		webview.setListener(this);
	}

	@Override
	public void onScrollchange(int y,int direction) {
		if (y > 50) {

			// 隐藏title
			if (!ishade&&(direction==1)) {
				AnimationSet animationSet = new AnimationSet(true);
				/*
				 * 　float fromXDelta:这个参数表示动画开始的点离当前View X坐标上的差值；

　　                                         float toXDelta, 这个参数表示动画结束的点离当前View X坐标上的差值；

　　                                       float fromYDelta, 这个参数表示动画开始的点离当前View Y坐标上的差值；

　　                               float toYDelta)这个参数表示动画开始的点离当前View Y坐标上的差值；*/
				TranslateAnimation translateAnimation = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, -1f);

				translateAnimation.setDuration(1000);
				animationSet.addAnimation(translateAnimation);
				lly_title.startAnimation(animationSet);
				lly_title.setVisibility(View.GONE);
				ishade = true;
			}
			if (ishade&&(direction==0)) {
				// 显示title
				AnimationSet animationSet = new AnimationSet(true);
				
				TranslateAnimation translateAnimation = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, -1f,
						Animation.RELATIVE_TO_SELF, 0f);

				translateAnimation.setDuration(1000);
				animationSet.addAnimation(translateAnimation);
				lly_title.startAnimation(animationSet);
				// 显示title
				lly_title.setVisibility(View.VISIBLE);
				ishade = false;
			}

		} else {
			if (ishade&&(direction==0)) {
				// 显示title
				AnimationSet animationSet = new AnimationSet(true);
				
				TranslateAnimation translateAnimation = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, -1f,
						Animation.RELATIVE_TO_SELF, 0f);

				translateAnimation.setDuration(1000);
				animationSet.addAnimation(translateAnimation);
				lly_title.startAnimation(animationSet);
				// 显示title
				lly_title.setVisibility(View.VISIBLE);
				ishade = false;
			}
		}

	}

}
