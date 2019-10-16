package com.example.myapplication.mvp.model.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/12/2 0002.
 */

public class DoneList {

    /**
     * data : {"curPage":1,"datas":[{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4612,"priority":0,"status":1,"title":"测试15","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4613,"priority":0,"status":1,"title":"测试16","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4614,"priority":0,"status":1,"title":"测试17","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4615,"priority":0,"status":1,"title":"测试18","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4616,"priority":0,"status":1,"title":"测试19","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4617,"priority":0,"status":1,"title":"测试20","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4618,"priority":0,"status":1,"title":"测试21","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4619,"priority":0,"status":1,"title":"测试22","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4620,"priority":0,"status":1,"title":"测试23","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4621,"priority":0,"status":1,"title":"测试24","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4622,"priority":0,"status":1,"title":"测试25","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4623,"priority":0,"status":1,"title":"测试26","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4624,"priority":0,"status":1,"title":"测试27","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543852800000,"dateStr":"2018-12-04","id":4625,"priority":0,"status":1,"title":"测试28","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543852800000,"dateStr":"2018-12-04","id":4626,"priority":0,"status":1,"title":"测试29","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543420800000,"dateStr":"2018-11-29","id":4525,"priority":0,"status":1,"title":"测试4","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543507200000,"dateStr":"2018-11-30","id":4547,"priority":0,"status":1,"title":"测试6","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543593600000,"dateStr":"2018-12-01","id":4551,"priority":0,"status":1,"title":"测试10","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4553,"priority":0,"status":1,"title":"测试11","type":0,"userId":6592},{"completeDate":1543593600000,"completeDateStr":"2018-12-01","content":"","date":1543593600000,"dateStr":"2018-12-01","id":4564,"priority":0,"status":1,"title":"测试13","type":0,"userId":6592}],"offset":0,"over":false,"pageCount":2,"size":20,"total":27}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

//    public static class DataBean {
    public static class DataBean  extends AbstractExpandableItem<DataBean.DatasBean> implements MultiItemEntity{
        /**
         * curPage : 1
         * datas : [{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4612,"priority":0,"status":1,"title":"测试15","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4613,"priority":0,"status":1,"title":"测试16","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4614,"priority":0,"status":1,"title":"测试17","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4615,"priority":0,"status":1,"title":"测试18","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4616,"priority":0,"status":1,"title":"测试19","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4617,"priority":0,"status":1,"title":"测试20","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4618,"priority":0,"status":1,"title":"测试21","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4619,"priority":0,"status":1,"title":"测试22","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4620,"priority":0,"status":1,"title":"测试23","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4621,"priority":0,"status":1,"title":"测试24","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4622,"priority":0,"status":1,"title":"测试25","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4623,"priority":0,"status":1,"title":"测试26","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543766400000,"dateStr":"2018-12-03","id":4624,"priority":0,"status":1,"title":"测试27","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543852800000,"dateStr":"2018-12-04","id":4625,"priority":0,"status":1,"title":"测试28","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543852800000,"dateStr":"2018-12-04","id":4626,"priority":0,"status":1,"title":"测试29","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543420800000,"dateStr":"2018-11-29","id":4525,"priority":0,"status":1,"title":"测试4","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543507200000,"dateStr":"2018-11-30","id":4547,"priority":0,"status":1,"title":"测试6","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543593600000,"dateStr":"2018-12-01","id":4551,"priority":0,"status":1,"title":"测试10","type":0,"userId":6592},{"completeDate":1543680000000,"completeDateStr":"2018-12-02","content":"","date":1543680000000,"dateStr":"2018-12-02","id":4553,"priority":0,"status":1,"title":"测试11","type":0,"userId":6592},{"completeDate":1543593600000,"completeDateStr":"2018-12-01","content":"","date":1543593600000,"dateStr":"2018-12-01","id":4564,"priority":0,"status":1,"title":"测试13","type":0,"userId":6592}]
         * offset : 0
         * over : false
         * pageCount : 2
         * size : 20
         * total : 27
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        @Override
        public int getLevel() {
            return 0;
        }

        @Override
        public int getItemType() {
            return 0;
        }

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

        public static class DatasBean  implements MultiItemEntity {
            /**
             * completeDate : 1543680000000
             * completeDateStr : 2018-12-02
             * content :
             * date : 1543680000000
             * dateStr : 2018-12-02
             * id : 4612
             * priority : 0
             * status : 1
             * title : 测试15
             * type : 0
             * userId : 6592
             */

            private long completeDate;
            private String completeDateStr;
            private String content;
            private long date;
            private String dateStr;
            private int id;
            private int priority;
            private int status;
            private String title;
            private int type;
            private int userId;

            private int itemType ;

            public int getItemType() {
                return itemType;
            }

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public long getCompleteDate() {
                return completeDate;
            }

            public void setCompleteDate(long completeDate) {
                this.completeDate = completeDate;
            }

            public String getCompleteDateStr() {
                return completeDateStr;
            }

            public void setCompleteDateStr(String completeDateStr) {
                this.completeDateStr = completeDateStr;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public String getDateStr() {
                return dateStr;
            }

            public void setDateStr(String dateStr) {
                this.dateStr = dateStr;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
