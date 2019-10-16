package com.example.myapplication.mvp.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class Collection {

    /**
     * curPage : 1
     * datas : [{"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","courseId":13,"desc":"","envelopePic":"","id":90822,"link":"https://mp.weixin.qq.com/s/-_oUN0lg-IZIL3a02kuEOA","niceDate":"1天前","origin":"","originId":9122,"publishTime":1570961361000,"title":"1-3年Android开发工程师面试经验分享","userId":6592,"visible":0,"zan":0},{"author":"code小生","chapterId":414,"chapterName":"code小生","courseId":13,"desc":"","envelopePic":"","id":78544,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNzU1Nzk3OQ==&mid=2247484542&idx=1&sn=d91522987bc0f7c9c8af9e28b339dbff&chksm=97f6bacaa08133dc767d7222c923e9b0a6a497423c7982334134dcd39dc67a1d945db74c074a&scene=38#wechat_redirect","niceDate":"2019-08-15","origin":"","originId":5787,"publishTime":1565838277000,"title":"给初学者的 RxJava2.0 教程","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":77,"chapterName":"响应式编程","courseId":13,"desc":"","envelopePic":"","id":78543,"link":"http://www.jianshu.com/p/464fa025229e","niceDate":"2019-08-15","origin":"","originId":1144,"publishTime":1565838274000,"title":"给初学者的RxJava2.0教程(一)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":77,"chapterName":"响应式编程","courseId":13,"desc":"","envelopePic":"","id":78542,"link":"http://www.jianshu.com/p/8818b98c44e2","niceDate":"2019-08-15","origin":"","originId":1145,"publishTime":1565838273000,"title":"给初学者的RxJava2.0教程(二)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":78541,"link":"http://www.jianshu.com/p/a75ecf461e02","niceDate":"2019-08-15","origin":"","originId":2709,"publishTime":1565838229000,"title":"给初学者的RxJava2.0教程(八)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":78539,"link":"http://www.jianshu.com/p/0f2d6c2387c9","niceDate":"2019-08-15","origin":"","originId":2712,"publishTime":1565838228000,"title":"给初学者的RxJava2.0教程(五)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":78540,"link":"http://www.jianshu.com/p/36e0f7f43a51","niceDate":"2019-08-15","origin":"","originId":2708,"publishTime":1565838228000,"title":"给初学者的RxJava2.0教程(九)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":78537,"link":"http://www.jianshu.com/p/9b1304435564","niceDate":"2019-08-15","origin":"","originId":2710,"publishTime":1565838227000,"title":"给初学者的RxJava2.0教程(七)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":78538,"link":"http://www.jianshu.com/p/e4c6d7989356","niceDate":"2019-08-15","origin":"","originId":2711,"publishTime":1565838227000,"title":"给初学者的RxJava2.0教程(六)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":78536,"link":"http://www.jianshu.com/p/128e662906af","niceDate":"2019-08-15","origin":"","originId":2714,"publishTime":1565838226000,"title":"给初学者的RxJava2.0教程(三)","userId":6592,"visible":0,"zan":0},{"author":"Season_zlc","chapterId":0,"chapterName":"","courseId":13,"desc":"","envelopePic":"","id":78535,"link":"http://www.jianshu.com/p/bb58571cdb64","niceDate":"2019-08-15","origin":"","originId":2713,"publishTime":1565838225000,"title":"给初学者的RxJava2.0教程(四)","userId":6592,"visible":0,"zan":0},{"author":"玉刚说","chapterId":410,"chapterName":"玉刚说","courseId":13,"desc":"","envelopePic":"","id":78534,"link":"http://mp.weixin.qq.com/s?__biz=MzIwMTAzMTMxMg==&mid=2649492617&idx=1&sn=28cd945961936c53bbcb6fc494b1cbe8&chksm=8eec8776b99b0e607eb9720d2e9d1421985a147884175fe2ba521e7059f611f454daa455b1f5&scene=38#wechat_redirect","niceDate":"2019-08-15","origin":"","originId":5080,"publishTime":1565838219000,"title":"RxJava2.x 源码解析 - 线程切换","userId":6592,"visible":0,"zan":0},{"author":"玉刚说","chapterId":410,"chapterName":"玉刚说","courseId":13,"desc":"","envelopePic":"","id":78533,"link":"http://mp.weixin.qq.com/s?__biz=MzIwMTAzMTMxMg==&mid=2649492706&idx=1&sn=d7d213a1db9c8ae3a5b0525d45863518&chksm=8eec871db99b0e0bc4d4d1aa2b7ed5d7c32e5299aee0f0818a798c2deb2996f40f8971c7a6a2&scene=38#wechat_redirect","niceDate":"2019-08-15","origin":"","originId":5091,"publishTime":1565838212000,"title":"RxJava 只看这一篇文章就够了 (上)","userId":6592,"visible":0,"zan":0},{"author":"玉刚说","chapterId":410,"chapterName":"玉刚说","courseId":13,"desc":"","envelopePic":"","id":78532,"link":"http://mp.weixin.qq.com/s?__biz=MzIwMTAzMTMxMg==&mid=2649492715&idx=2&sn=18ec403398fc5044732779ca8cbddd1b&chksm=8eec8714b99b0e02692798393314d6ac437db33e067ab2880972c1124937a66b32d07b49f978&scene=38#wechat_redirect","niceDate":"2019-08-15","origin":"","originId":5032,"publishTime":1565838211000,"title":"RxJava 只看这一篇文章就够了 (下)","userId":6592,"visible":0,"zan":0},{"author":"玉刚说","chapterId":410,"chapterName":"玉刚说","courseId":13,"desc":"","envelopePic":"","id":78531,"link":"http://mp.weixin.qq.com/s?__biz=MzIwMTAzMTMxMg==&mid=2649492715&idx=1&sn=9d2160fae874472f1ecf40f91c52d837&chksm=8eec8714b99b0e02f08afc916f94fb2bd075c9ce31c214c5c45674739ca110bed423e8f44d5c&scene=38#wechat_redirect","niceDate":"2019-08-15","origin":"","originId":5123,"publishTime":1565838210000,"title":"RxJava 只看这一篇文章就够了 (中)","userId":6592,"visible":0,"zan":0},{"author":"teprinciple","chapterId":358,"chapterName":"项目基础功能","courseId":13,"desc":"Kotlin开发，支持AndroidX 、Md5签名验证、自定义UI、自动删除安装包、通知栏图片自定义；适配中英文，支持Android9.0\r\n","envelopePic":"https://wanandroid.com/blogimgs/92ca6ece-6ed7-4a2e-a071-7c161f50d788.png","id":73562,"link":"http://www.wanandroid.com/blog/show/2628","niceDate":"2019-07-24","origin":"","originId":8721,"publishTime":1563934731000,"title":"一行代码帮你搞定Android版本更新","userId":6592,"visible":0,"zan":0},{"author":" JasonWuuu","chapterId":73,"chapterName":"面试相关","courseId":13,"desc":"","envelopePic":"","id":72013,"link":"https://juejin.im/post/5d29d4def265da1b7638d047","niceDate":"2019-07-15","origin":"","originId":8692,"publishTime":1563150590000,"title":"Android复习资料&mdash;&mdash;常见面试算法题汇总（一）","userId":6592,"visible":0,"zan":0},{"author":"流船","chapterId":176,"chapterName":"个人博客","courseId":13,"desc":"","envelopePic":"","id":69068,"link":"https://www.jianshu.com/p/00fa7045735b","niceDate":"2019-06-22","origin":"","originId":8630,"publishTime":1561133257000,"title":"Android 你需要的所有进阶资源","userId":6592,"visible":0,"zan":0},{"author":"winwill2012","chapterId":200,"chapterName":"https","courseId":13,"desc":"","envelopePic":"","id":61817,"link":"https://www.jianshu.com/p/ca7df01a9041","niceDate":"2019-05-18","origin":"","originId":8441,"publishTime":1558156663000,"title":"看完还不懂HTTPS我直播吃翔","userId":6592,"visible":0,"zan":0},{"author":"pengMaster","chapterId":367,"chapterName":"资源聚合类","courseId":13,"desc":"自己总结的比较全面的知识点和面试","envelopePic":"https://www.wanandroid.com/resources/image/pc/default_project_img.jpg","id":57058,"link":"http://www.wanandroid.com/blog/show/2544","niceDate":"2019-04-17","origin":"","originId":8251,"publishTime":1555476258000,"title":"Java Android学习/面试指南","userId":6592,"visible":0,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 2
     * size : 20
     * total : 22
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

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

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean implements MultiItemEntity {
        /**
         * author : 鸿洋
         * chapterId : 408
         * chapterName : 鸿洋
         * courseId : 13
         * desc :
         * envelopePic :
         * id : 90822
         * link : https://mp.weixin.qq.com/s/-_oUN0lg-IZIL3a02kuEOA
         * niceDate : 1天前
         * origin :
         * originId : 9122
         * publishTime : 1570961361000
         * title : 1-3年Android开发工程师面试经验分享
         * userId : 6592
         * visible : 0
         * zan : 0
         */

        private String author;
        private int chapterId;
        private String chapterName;
        private int courseId;
        private String desc;
        private String envelopePic;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private int originId;
        private long publishTime;
        private String title;
        private int userId;
        private int visible;
        private int zan;

        private int itemType;




        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getOriginId() {
            return originId;
        }

        public void setOriginId(int originId) {
            this.originId = originId;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }


        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
