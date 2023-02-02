package cn.cz.battlecity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private static final int TOUCH_START = 101;
    private static final int TOUCH_UP = 102;
    private static final int TOUCH_DOWN = 103;
    private static final int TOUCH_LEFT = 104;
    private static final int TOUCH_RIGHT = 105;

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mWebView.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mWebView.onPause();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.performClick();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                view.setBackgroundColor(getColor(R.color.teal_200));
                if (view.getId() == R.id.start) {
                    mWebView.loadUrl("javascript:onTouchDown(" + TOUCH_START + ")");
                } else if (view.getId() == R.id.up) {
                    mWebView.loadUrl("javascript:onTouchDown(" + TOUCH_UP + ")");
                } else if (view.getId() == R.id.down) {
                    mWebView.loadUrl("javascript:onTouchDown(" + TOUCH_DOWN + ")");
                } else if (view.getId() == R.id.left) {
                    mWebView.loadUrl("javascript:onTouchDown(" + TOUCH_LEFT + ")");
                } else if (view.getId() == R.id.right) {
                    mWebView.loadUrl("javascript:onTouchDown(" + TOUCH_RIGHT + ")");
                }
                break;
            case MotionEvent.ACTION_UP:
                view.setBackgroundColor(getColor(R.color.teal_700));
                if (view.getId() == R.id.start) {
                    mWebView.loadUrl("javascript:onTouchUp(" + TOUCH_START + ")");
                } else if (view.getId() == R.id.up) {
                    mWebView.loadUrl("javascript:onTouchUp(" + TOUCH_UP + ")");
                } else if (view.getId() == R.id.down) {
                    mWebView.loadUrl("javascript:onTouchUp(" + TOUCH_DOWN + ")");
                } else if (view.getId() == R.id.left) {
                    mWebView.loadUrl("javascript:onTouchUp(" + TOUCH_LEFT + ")");
                } else if (view.getId() == R.id.right) {
                    mWebView.loadUrl("javascript:onTouchUp(" + TOUCH_RIGHT + ")");
                }
                break;
        }

        return true;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        mWebView = findViewById(R.id.web_view);
        mWebView.getSettings().setSupportZoom(false);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/index.html");

        findViewById(R.id.start).setOnTouchListener(this);
        findViewById(R.id.up).setOnTouchListener(this);
        findViewById(R.id.down).setOnTouchListener(this);
        findViewById(R.id.left).setOnTouchListener(this);
        findViewById(R.id.right).setOnTouchListener(this);
    }
}