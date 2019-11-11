package com.example.wanandroid.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanandroid.R;
import com.example.wanandroid.adapter.PriorityAdapter;

import java.util.ArrayList;
import java.util.List;

public class PriorityDialog extends Dialog {


    public PriorityDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initDialog();
    }

    private void initDialog() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM;
        window.setAttributes(attributes);

    }

    public static class Builder {
        private Context context;
        private String select;
        private View contentView;
        //listener
        private priorityItemSelectListener mSelectListener;

        private Builder() {
        }

        public Builder(Context context, View contentView) {
            this.context = context;
            this.contentView = contentView;
        }

        public Builder setSelect(String select) {
            this.select = select;
            return this;
        }

        public Builder setListener(priorityItemSelectListener listener) {
            this.mSelectListener = listener;
            return this;
        }

        public PriorityDialog build() {

            if (contentView == null) {
                throw new IllegalStateException("ContentView is required");
            }

            final PriorityDialog dialog = new PriorityDialog(context, R.style.dialog_priority);
            RecyclerView recyclerView = contentView.findViewById(R.id.recycler);
            List<String> priorityList = new ArrayList<>();
            priorityList.add(context.getString(R.string.priority_first));
            priorityList.add(context.getString(R.string.priority_second));
            priorityList.add(context.getString(R.string.priority_third));
            priorityList.add(context.getString(R.string.priority_fourth));

            final PriorityAdapter priorityAdapter = new PriorityAdapter(R.layout.item_priorty, priorityList);
            priorityAdapter.setItemSelect(select);
            recyclerView.setAdapter(priorityAdapter);
            priorityAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    mSelectListener.select((String) adapter.getItem(position));
                    priorityAdapter.setItemSelect(position);
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                                sleep(500);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                    dialog.dismiss();
                }
            });
            recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
            dialog.setContentView(contentView);
            return dialog;
        }

    }


    private priorityItemSelectListener mSelectListener;

    public void setSelect(priorityItemSelectListener selectListener) {
        this.mSelectListener = selectListener;
    }

    public interface priorityItemSelectListener {
        void select(String position);
    }

    /**
     * 用于填充contentView,必须传ContextThemeWrapper(比如activity)不然popupwindow要报错
     *
     * @param context
     * @param layoutId
     * @return
     */
    public static View inflateView(Context context, int layoutId) {
        return LayoutInflater.from(context).inflate(layoutId, null);
    }
}
