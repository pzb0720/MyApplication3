package com.example.wanandroid.mvp.model.bean;

import java.util.List;

public class Article {

    /**
     * curPage : 2
     * datas : [{"apkLink":"","audit":1,"author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9418,"link":"https://mp.weixin.qq.com/s/JaIJwuXnV0YCb1PwdXCMXg","niceDate":"2019-09-25","niceShareDate":"2019-09-28","origin":"","prefix":"","projectLink":"","publishTime":1569340800000,"selfVisible":0,"shareDate":1569677769000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"Java：控制反转（IoC）与依赖注入（DI）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"承香墨影","chapterId":411,"chapterName":"承香墨影","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9421,"link":"https://mp.weixin.qq.com/s/z1yEzR9rqUrTMLulxvWjqw","niceDate":"2019-09-25","niceShareDate":"2019-09-28","origin":"","prefix":"","projectLink":"","publishTime":1569340800000,"selfVisible":0,"shareDate":1569677975000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/411/1"}],"title":"Kotlin干掉了findViewById，但用不好也会有性能问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" susion","chapterId":495,"chapterName":"booster","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9327,"link":"https://juejin.im/post/5d84c0236fb9a06ae57d2b65","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569338205000,"selfVisible":0,"shareDate":1569338205000,"shareUser":"","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"booster分析-App资源压缩","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" Drummor","chapterId":173,"chapterName":"Choreographer","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9326,"link":"https://juejin.im/post/5cb1bafe6fb9a068a84fda40","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569338189000,"selfVisible":0,"shareDate":1569338189000,"shareUser":"","superChapterId":171,"superChapterName":"framework","tags":[],"title":"Android 怎么就不卡了呢之Choreographer","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Drummor","chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9325,"link":"https://juejin.im/post/5d2aa5985188257c3d2cecef","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569338084000,"selfVisible":0,"shareDate":1569338084000,"shareUser":"","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"横向对比Jetpack、RxJava、Glide框架中对组件生命周期Lifecycle感知原理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":76,"chapterName":"项目架构","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9300,"link":"https://mp.weixin.qq.com/s/_6p6vfce7m5E8AwGDg2cZg","niceDate":"2019-09-24","niceShareDate":"2019-09-23","origin":"","prefix":"","projectLink":"","publishTime":1569255115000,"selfVisible":0,"shareDate":1569249942000,"shareUser":"ZYLAB","superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"Android 开发中的架构模式 -- MVC / MVP / MVVM","type":0,"userId":10577,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"猴子007","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9306,"link":"https://www.jianshu.com/p/64240319ed60","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569255081000,"selfVisible":0,"shareDate":1569255081000,"shareUser":"","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"一文解决内存屏障","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"求闲居士","chapterId":346,"chapterName":"JVM","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9305,"link":"https://www.jianshu.com/p/713d24fa9982","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569255058000,"selfVisible":0,"shareDate":1569255058000,"shareUser":"","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"Java 虚拟机、Art、Dalvik 他们的区别","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" lijiankun24","chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9304,"link":"https://www.jianshu.com/p/58f876f2e8b8","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569254992000,"selfVisible":0,"shareDate":1569254992000,"shareUser":"","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"虚拟机字节码执行引擎（读书笔记）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"GitLqr","chapterId":149,"chapterName":"so文件相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9303,"link":"https://juejin.im/post/5d8482a05188254c8b7bc7f2","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569254965000,"selfVisible":0,"shareDate":1569254965000,"shareUser":"","superChapterId":149,"superChapterName":"JNI","tags":[],"title":"Android音视频&mdash;&mdash;Libyuv使用实战","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":" 承香墨影","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9302,"link":"https://juejin.im/post/5d8882546fb9a06b233cfe65","niceDate":"2019-09-24","niceShareDate":"2019-09-24","origin":"","prefix":"","projectLink":"","publishTime":1569254896000,"selfVisible":0,"shareDate":1569254896000,"shareUser":"","superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"Android 本地化适配：RTL（right-to-left） 适配清单","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9388,"link":"https://mp.weixin.qq.com/s/9akzn3SByjjOyo-LBStmTg","niceDate":"2019-09-24","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569254400000,"selfVisible":0,"shareDate":1569585820000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android：你要了解的自定义View基础概念都在这里了！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9417,"link":"https://mp.weixin.qq.com/s/mV6FaK7KgkxoR14j8ygWYA","niceDate":"2019-09-24","niceShareDate":"2019-09-28","origin":"","prefix":"","projectLink":"","publishTime":1569254400000,"selfVisible":0,"shareDate":1569677734000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"Flutter 实现原理及在马蜂窝的跨平台开发实践","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9265,"link":"https://www.jianshu.com/p/db56a3c52856","niceDate":"2019-09-23","niceShareDate":"2019-09-20","origin":"","prefix":"","projectLink":"","publishTime":1569171774000,"selfVisible":0,"shareDate":1568941515000,"shareUser":"yangchong211","superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"Android优化总结","type":0,"userId":697,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9283,"link":"https://juejin.im/post/5d1842a66fb9a07ec63b2a1a","niceDate":"2019-09-23","niceShareDate":"2019-09-22","origin":"","prefix":"","projectLink":"","publishTime":1569171715000,"selfVisible":0,"shareDate":1569153812000,"shareUser":"星星y","superChapterId":126,"superChapterName":"自定义控件","tags":[],"title":"自定义Layout，让子View支持圆角属性","type":0,"userId":15603,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":76,"chapterName":"项目架构","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9284,"link":"https://blog.csdn.net/hailong0529/article/details/100312558","niceDate":"2019-09-23","niceShareDate":"2019-09-22","origin":"","prefix":"","projectLink":"","publishTime":1569171702000,"selfVisible":0,"shareDate":1569155164000,"shareUser":"左海龙","superChapterId":74,"superChapterName":"热门专题","tags":[],"title":"Android 老生常谈之MVC与MVP","type":0,"userId":20375,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>这是一个很常见的需求，那么到底有多少种方案，每种各有什么特点？<\/p>","envelopePic":"","fresh":false,"id":9233,"link":"https://www.wanandroid.com/wenda/show/9233","niceDate":"2019-09-23","niceShareDate":"2019-09-17","origin":"","prefix":"","projectLink":"","publishTime":1569171675000,"selfVisible":0,"shareDate":1568731287000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 屏蔽连续点击的方案有哪些？","type":0,"userId":2,"visible":1,"zan":20},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9387,"link":"https://mp.weixin.qq.com/s/q0Vdx0qqYi54PffFq9pPnA","niceDate":"2019-09-23","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569168000000,"selfVisible":0,"shareDate":1569585796000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"GridLayoutManager这么用，你可能还真没尝试过","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9395,"link":"https://mp.weixin.qq.com/s/B4Jt9NQ8m6LmMPNG5Eu5YA","niceDate":"2019-09-23","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569168000000,"selfVisible":0,"shareDate":1569586302000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"在Flutter中玩自定义View真是其乐无穷","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9427,"link":"https://mp.weixin.qq.com/s/XeUCqZK_Bl4-fLgyV1cq1A","niceDate":"2019-09-23","niceShareDate":"2019-09-28","origin":"","prefix":"","projectLink":"","publishTime":1569168000000,"selfVisible":0,"shareDate":1569679139000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"RecyclerView配合DiffUtil，好用到飞","type":0,"userId":-1,"visible":1,"zan":0}]
     * offset : 20
     * over : false
     * pageCount : 361
     * size : 20
     * total : 7215
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<ArticleDataBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ArticleDataBean> getDatas() {
        return datas;
    }

    public void setDatas(List<ArticleDataBean> datas) {
        this.datas = datas;
    }


}
