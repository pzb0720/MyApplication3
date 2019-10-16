package com.example.myapplication.mvp.model.bean;

import java.util.List;

public class TopArticle {

    /**
     * data : [{"apkLink":"","audit":1,"author":"网易","chapterId":361,"chapterName":"课程推荐","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":8904,"link":"https://url.163.com/4bj","niceDate":"2小时前","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1569990728000,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"分享一波Android进阶必备干货","type":1,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>从2019年10月1日更新记录，在这里也备份一份，有问题可以直接回复我。<\/p>","envelopePic":"","fresh":true,"id":9470,"link":"https://wanandroid.com/wenda/show/9470","niceDate":"2小时前","niceShareDate":"2小时前","origin":"","prefix":"","projectLink":"","publishTime":1569990724000,"selfVisible":0,"shareDate":1569990436000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"玩Android更新记录 [&gt;2019-10-02]","type":1,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":360,"chapterName":"小编发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9152,"link":"https://www.wanandroid.com/blog/show/2676","niceDate":"2019-09-15","niceShareDate":"2019-09-14","origin":"","prefix":"","projectLink":"","publishTime":1568561333000,"selfVisible":0,"shareDate":1568448789000,"shareUser":"鸿洋","superChapterId":298,"superChapterName":"原创文章","tags":[],"title":"我们支持大家自己投递文章啦！","type":1,"userId":2,"visible":1,"zan":0}]
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private List<ArticleDataBean> data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ArticleDataBean> getData() {
        return data;
    }

    public void setData(List<ArticleDataBean> data) {
        this.data = data;
    }


}
