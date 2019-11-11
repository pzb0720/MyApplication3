package com.example.wanandroid.db;

import com.example.wanandroid.mvp.model.bean.HistorySearch;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class HistoryDbManager {

    public static List<HistorySearch> getHistorySearchList() {
        List<HistorySearch> list = new ArrayList<>();
        List<HistorySearch> all = LitePal.findAll(HistorySearch.class);
        for (HistorySearch search : all) {
            list.add(search);
        }
        return list;
    }

    public static List<HistorySearch> getDescHistorySearchList() {
        List<HistorySearch> list = new ArrayList<>();
        List<HistorySearch> limit = LitePal.order("time desc").limit(100).find(HistorySearch.class);

        for (HistorySearch historySearch : limit) {
            list.add(historySearch);
        }
        return list;
    }


    public static void clearAllHistory() {
        LitePal.deleteAll(HistorySearch.class);
    }

    public static void addAllHistory(List<HistorySearch> list) {

        LitePal.saveAll(list);
    }

    public static void deleteHistory(String title) {
        LitePal.deleteAll(HistorySearch.class, "title = ?", title);
    }


    public static void saveHistory(HistorySearch historySearch) {
        int count = LitePal.where("title = ?", historySearch.getTitle()).count(HistorySearch.class);
        if (count == 0) {
            HistorySearch search = new HistorySearch();
            search.setTime(historySearch.getTime());
            search.setTitle(historySearch.getTitle());
            search.save();
        } else {
            HistorySearch search = new HistorySearch();
            search.setTime(historySearch.getTime());
            search.save();
        }
    }
}
