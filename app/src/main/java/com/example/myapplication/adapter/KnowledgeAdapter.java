package com.example.myapplication.adapter;

import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.mvp.model.bean.Tree;
import com.example.myapplication.util.BackgroundColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22 0022.
 */

public class KnowledgeAdapter extends BaseCompatAdapter<Tree, BaseViewHolder> {
    public KnowledgeAdapter(int layoutResId, @Nullable List<Tree> data) {
        super(layoutResId, data);
    }

    public KnowledgeAdapter(@Nullable List<Tree> data) {
        super(data);
    }

    public KnowledgeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Tree item) {

        if (item.getName() == null) {
            return;
        }
        helper.setText(R.id.tv_knowledge_hierarchy_title, item.getName());
        if (item.getChildren() == null) {
            return;
        }
        StringBuffer sb = new StringBuffer();
        List<String> names = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();

        for (Tree.ChildrenBean bean : item.getChildren()) {
            sb.append(bean.getName()).append("  ");
            names.add(bean.getName());
            colors.add(BackgroundColor.randomTagColor());
        }


        SpannableStringBuilder spannableString = new SpannableStringBuilder(sb);
        ForegroundColorSpan span;
        int start = 0;
//        helper.setText(R.id.tv_knowledge_hierarchy_content,)

        TextView textView = helper.getView(R.id.tv_knowledge_hierarchy_content);
        for (int i = 0; i < names.size(); i++) {
            span = new ForegroundColorSpan(colors.get(i));
            spannableString.setSpan(span, start, start + names.get(i).length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            start = names.get(i).length() + start + 2;
        }

        helper.setText(R.id.tv_knowledge_hierarchy_content, spannableString);
    }
}
