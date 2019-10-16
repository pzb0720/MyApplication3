package com.example.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.constant.RxBusCode;
import com.example.myapplication.mvp.contract.AddToDoContract;
import com.example.myapplication.mvp.presenter.personal.AddToDoPresenter;
import com.example.myapplication.ui.widget.CustomPopupWindow;
import com.example.myapplication.ui.widget.PriorityDialog;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;
import com.example.mylibrary.rxbus.RxBus;
import com.example.mylibrary.util.DateUtils;
import com.example.mylibrary.util.SnackbarUtils;
import com.example.mylibrary.util.StatusBarUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;


/**
 * Created by Administrator on 2018/12/6 0006.
 */

public class AddToDoActivity extends BaseMVPActivity<AddToDoContract.AddToDoPresenter> implements AddToDoContract.IAddToDoView, View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.et_title)
    EditText mEtTitle;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.tv_priority)
    TextView mTvPriority;

    int priority;


    private CustomPopupWindow popupWindow;

    private int type;
    private String title;
    private int id = -1;
    private int status;

    @Override
    public void initData() {
        super.initData();
        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unRegister(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        StatusBarUtils.setColor(AddToDoActivity.this, getColorPrimary());
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        Intent intent = getIntent();
        if (intent != null) {
            status = intent.getIntExtra("status", 0);
            type = intent.getIntExtra("type", 0);
            title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            String time = intent.getStringExtra("time");
            id = intent.getIntExtra("id", -1);
            priority = intent.getIntExtra("priority", 1);
            if (!TextUtils.isEmpty(title)) {
                mEtTitle.setText(title);
            }

            if (!TextUtils.isEmpty(content)) {
                mEtContent.setText(content);
            }

            if (!TextUtils.isEmpty(time)) {
                mTvTime.setText(time);
            } else {
                String date = DateUtils.formatDate(System.currentTimeMillis());
                mTvTime.setText(date);
            }
        } else {
            String now = DateUtils.formatDate(System.currentTimeMillis());
            mTvTime.setText(now);
        }

        mTvPriority.setText(getPriorityString(priority));

        String titleAdd = "添加待办清单";
        String titleUpdate = "更新待办清单";

        if (id == -1) {
            initToolBar(toolbar, titleAdd);
        } else {
            initToolBar(toolbar, titleUpdate);
        }

        mTvTime.setOnClickListener(this);
        mTvPriority.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_todo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_add_todo_ok:
                addTodo();

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void addTodo() {

        if (checkData()) {

            Map<String, Object> map = new HashMap<>();
            map.put("title", mEtTitle.getText());
            map.put("type", type);
            map.put("date", mTvTime.getText());
            map.put("content", mEtContent.getText());

            String strPriority = mTvPriority.getText().toString().trim();
            if (TextUtils.equals(strPriority, getString(R.string.priority_first))) {
                priority = 1;
            } else if (TextUtils.equals(strPriority, getString(R.string.priority_second))) {
                priority = 2;
            } else if (TextUtils.equals(strPriority, getString(R.string.priority_third))) {
                priority = 3;
            } else if (TextUtils.equals(strPriority, getString(R.string.priority_fourth))) {
                priority = 4;
            } else {
                priority = 1;
            }

            map.put("priority", priority);

            if (id != -1) {
                mPresenter.updateToDo(id, map);
            } else {
                mPresenter.addToDo(map);
            }

            Map<String, Object> mapResult = new HashMap<>();
            mapResult.put("type", type);
            mapResult.put("status", status);
            RxBus.get().send(RxBusCode.RX_BUS_CODE_UPDATE);
            Log.i("哇哈哈", "发送了？");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        AddToDoActivity.this.finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }

    private boolean checkData() {

        if (TextUtils.isEmpty(mEtTitle.getText().toString().trim())) {
            SnackbarUtils.setMessage(mEtContent, "请输入标题");
            return false;
        }
        if (TextUtils.isEmpty(mEtContent.getText().toString().trim())) {
            SnackbarUtils.setMessage(mEtContent, "请输入内容");
            return false;
        }

        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo_add;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_time:
                popupWindow = CustomPopupWindow.builder()
                        .contentView(CustomPopupWindow.inflateView(AddToDoActivity.this, R.layout.sub_item_pop_calendar))
                        .isOutsideTouch(true)
                        .isFocus(true)
                        .isWrap(true)
                        .customListener(new CustomPopupWindow.CustomPopupWindowListener() {
                            @Override
                            public void initPopView(View contentView) {
                                CalendarView calendarView = contentView.findViewById(R.id.pop_calendar);
                                Calendar calendar = Calendar.getInstance();
                                //获取月
//                                calendar.set(Calendar.DAY_OF_MONTH, 1);
//                                Date date = calendar.getTime();
//                                calendarView.setMinDate(date.getTime());
//                                //
//                                calendar.set(Calendar.DATE)
                                calendarView.setMinDate(System.currentTimeMillis());

                                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                                    @Override
                                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                                        String content = year + "-" + (month + 1) + "-" + dayOfMonth;
                                        mTvTime.setText(content);
                                        popupWindow.dismiss();
                                    }
                                });
                            }
                        })
                        .build();
                popupWindow.show();

                break;

            case R.id.tv_priority:

                final PriorityDialog.Builder builder = new PriorityDialog
                        .Builder(AddToDoActivity.this, PriorityDialog.inflateView(AddToDoActivity.this, R.layout.dialog_priority));
                builder.setSelect(mTvPriority.getText().toString().trim())
                        .setListener(new PriorityDialog.priorityItemSelectListener() {
                            @Override
                            public void select(String position) {
                                mTvPriority.setText(position.trim());
                            }
                        }).build().show();

                break;
            case R.id.tv_todo_submit:
                addTodo();
                break;
        }
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return AddToDoPresenter.newInstance();
    }


    public String getPriorityString(int priority) {
        String str = null;
        switch (priority) {
            case 0:
                str = getString(R.string.priority_first);
                break;
            case 1:
                str = getString(R.string.priority_second);
                break;
            case 2:
                str = getString(R.string.priority_third);
                break;
            case 3:
                str = getString(R.string.priority_fourth);
                break;

        }
        return str;
    }
}
