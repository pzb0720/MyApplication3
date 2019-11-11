package com.example.wanandroid.mvp.model.bean;

import org.litepal.crud.LitePalSupport;

public class HistorySearch extends LitePalSupport {
    String title;
    long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
