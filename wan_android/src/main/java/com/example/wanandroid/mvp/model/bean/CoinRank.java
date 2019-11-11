package com.example.wanandroid.mvp.model.bean;

import java.util.List;

public class CoinRank {

    /**
     * curPage : 2
     * datas : [{"coinCount":1421,"rank":0,"userId":28454,"username":"c**xzxzc"},{"coinCount":1383,"rank":0,"userId":12331,"username":"R**kieJay"},{"coinCount":1383,"rank":0,"userId":872,"username":"l**enshan"},{"coinCount":1383,"rank":0,"userId":25419,"username":"蔡**打篮球"},{"coinCount":1370,"rank":0,"userId":24177,"username":"l**大白菜"},{"coinCount":1346,"rank":0,"userId":25793,"username":"F**_2014"},{"coinCount":1346,"rank":0,"userId":21141,"username":"1**88023205"},{"coinCount":1310,"rank":0,"userId":12272,"username":"1**95431078"},{"coinCount":1310,"rank":0,"userId":11610,"username":"s**elhe"},{"coinCount":1310,"rank":0,"userId":28694,"username":"c**ng0218"},{"coinCount":1310,"rank":0,"userId":28873,"username":"2**3978422"},{"coinCount":1307,"rank":0,"userId":6430,"username":"w**yyy"},{"coinCount":1285,"rank":0,"userId":28781,"username":"f**android"},{"coinCount":1275,"rank":0,"userId":2786,"username":"8**408834@qq.com"},{"coinCount":1275,"rank":0,"userId":25128,"username":"f**wandroid"},{"coinCount":1275,"rank":0,"userId":7075,"username":"c**ndroid"},{"coinCount":1275,"rank":0,"userId":20592,"username":"c**hao9808"},{"coinCount":1275,"rank":0,"userId":29076,"username":"f**ham"},{"coinCount":1274,"rank":0,"userId":8074,"username":"m**w888"},{"coinCount":1242,"rank":0,"userId":28887,"username":"h**zhihao"},{"coinCount":1241,"rank":0,"userId":12351,"username":"w**igeny"},{"coinCount":1241,"rank":0,"userId":7891,"username":"h**zkp"},{"coinCount":1241,"rank":0,"userId":28685,"username":"b**aryshao"},{"coinCount":1241,"rank":0,"userId":2160,"username":"R**iner"},{"coinCount":1208,"rank":0,"userId":21576,"username":"S**iWanZi"},{"coinCount":1208,"rank":0,"userId":27,"username":"y**ochoo"},{"coinCount":1208,"rank":0,"userId":26707,"username":"p**xc.com"},{"coinCount":1176,"rank":0,"userId":9296,"username":"j**123456"},{"coinCount":1157,"rank":0,"userId":20375,"username":"z**hailong"},{"coinCount":1155,"rank":0,"userId":4869,"username":"o**n_9527"}]
     * offset : 30
     * over : false
     * pageCount : 183
     * size : 30
     * total : 5483
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<Coin> datas;

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

    public List<Coin> getDatas() {
        return datas;
    }

    public void setDatas(List<Coin> coins) {
        this.datas = coins;
    }
}

