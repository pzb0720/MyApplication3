package com.example.myapplication.ui.activity.webView;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.constant.BundleKeyConstant;
import com.example.mylibrary.base.ui.activity.BaseActivity;
import com.example.mylibrary.util.NetworkConnectionUtils;
import com.example.mylibrary.util.StatusBarUtils;
import com.just.agentweb.AgentWeb;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/27 0027.
 */

public class HomeWebViewActivity extends BaseActivity {

    String mUrl;
    String mTitle;

    AgentWeb mAgentWeb;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_article_detail_web_view)
    FrameLayout mFlContent;

    @Override
    protected void initView(Bundle savedInstanceState) {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mUrl = bundle.getString(BundleKeyConstant.ARG_KEY_URL);
            mTitle = bundle.getString(BundleKeyConstant.ARG_KEY_TITLE);
        }
        Log.i("哇哈哈 homewebActivity", "initView: url" + mUrl);
       mUrl= mUrl.replace("http://", "https://");
        Log.i("哇哈哈 homewebActivity", "initView: url" + mUrl);
        initToolBar(toolbar, mTitle);
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mFlContent, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setMainFrameErrorView(R.layout.view_network_error, -1)
                .interceptUnkownUrl()
                .createAgentWeb()
                .ready()
                .go(mUrl);


        WebView mWebView = mAgentWeb.getWebCreator().getWebView();
        WebSettings settings = mWebView.getSettings();
        //缩放至屏幕大小
        settings.setLoadWithOverviewMode(true);
        //保存表单数据
        settings.setSaveFormData(true);
        //是否应该支持使用其屏幕缩放控件和手势缩放
        settings.setSupportZoom(true);
        //        //是否支持手势缩放控制
        //        settings.setBuiltInZoomControls(true);
        //        是否隐藏原生的缩放控件
        //        settings.setDisplayZoomControls(false);

        // 启动应用缓存
        settings.setAppCacheEnabled(true);
        // 排版适应屏幕，只显示一列
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //  页面加载好以后，再放开图片
        settings.setBlockNetworkImage(false);
        settings.setDatabaseEnabled(true);
        // WebView启用JavaScript执行。默认的是false。
        settings.setJavaScriptEnabled(true);//支持javascript脚本
        settings.setJavaScriptCanOpenWindowsAutomatically(true);


        if (NetworkConnectionUtils.isNetworkConnected(mContext)) {
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        }
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mAgentWeb.handleKeyEvent(keyCode, event) || super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

}
