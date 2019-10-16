package com.example.myapplication.api;


import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.Collection;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Friend;
import com.example.myapplication.mvp.model.bean.Navi;
import com.example.myapplication.mvp.model.bean.Rank;
import com.example.myapplication.mvp.model.bean.ToDo;
import com.example.myapplication.mvp.model.bean.TopArticle;
import com.example.myapplication.mvp.model.bean.Tree;
import com.example.myapplication.mvp.model.bean.User;
import com.example.myapplication.mvp.model.bean.WanBanner;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/6/22 0022.
 */

public interface wanAndroid {
    public static final String HOST_URL = "https://www.wanandroid.com";

    @GET("/banner/json")
    Observable<WanBanner> getBanner();

    @GET("/article/top/json")
    Observable<TopArticle> getTop();

    @GET("/article/list/{page}/json")
    Observable<DataResponse<Article>> getArticle(@Path("page") int page);


    @GET("/tree/json")
    Observable<DataResponse<List<Tree>>> getTree();


    //http://www.wanandroid.com/navi/json
    @GET("/navi/json")
    Observable<DataResponse<List<Navi>>> getNavigation();


    @GET("/article/list/{currentPage}/json")
    Observable<DataResponse<Article>> getTreeArticle(@Path("currentPage") int page, @Query("cid") int cid);


    /**
     * 登录
     *
     * @param username username
     * @param password password
     * @return Deferred<User>
     */
    @POST("/user/login")
    @FormUrlEncoded
    Observable<DataResponse<User>> login(@Field("username") String username, @Field("password") String password);
//

    /**
     * 获取自己收藏的文章列表
     *
     * @param page page
     * @return Deferred<Article>
     */
    @GET("/lg/collect/list/{page}/json")
    Observable<DataResponse<Collection>> getCollectArticles(@Path("page") int page);


    /**
     * 收藏文章
     *
     * @param id id
     * @return Deferred<DataResponse>
     */
    @POST("/lg/collect/{id}/json")
    Observable<DataResponse> addCollectArticle(@Path("id") int id);

    /**
     * 收藏站外文章
     *
     * @param title  title
     * @param author author
     * @param link   link
     * @return Deferred<DataResponse>
     */
    @POST("/lg/collect/add/json")
    @FormUrlEncoded
    Observable<DataResponse> addCollectOutsideArticle(@Field("title") String title, @Field("author") String author, @Field("link") String link);


    /**
     * 删除收藏文章
     *
     * @param id id
     * @return Deferred<DataResponse>
     */
    @POST("/lg/uncollect_originId/{id}/json")
    Observable<DataResponse<Article>> removeCollectArticle(@Path("id") int id);

    //89054

    /**
     * 删除收藏文章
     *
     * @param id       id
     * @param originId -1
     * @return Deferred<DataResponse>
     */
    @POST("/lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<DataResponse<Collection>> removeCollectArticle(@Path("id") int id, @Field("originId") int originId);
//
//
//    @POST("lg/todo/listdone/0/json/1")
//    Observable<DoneList> getDoneList();

//    @POST("lg/todo/list/{id}/json")
//    Observable<ToDo> getAllList(@Path("id") int id);


    /**
     * 获取Todo列表数据 根据完成时间排序
     */
    @GET("/lg/todo/v2/list/{page}/json")
    Observable<ToDo> getTodoData(@Path("page") int page);


    @POST("/lg/todo/delete/{id}/json")
    Observable<DataResponse> deleteTo(@Path("id") int id);

    /**
     * 仅更新完成状态Todo
     * <p>
     * id: 拼接在链接上，为唯一标识
     * status: 0或1，传1代表未完成到已完成，反之则反之。
     *
     * @return BaseModel
     */

    @POST("/lg/todo/done/{id}/json")
    Observable<DataResponse> updateTodoJustStatus(@Path("id") int id, @Query("status") int status);


    /**
     * 新增一条Todo
     * title: 新增标题
     * content: 新增详情
     * date: 2018-08-01
     * type: 0
     *
     * @return BaseBean
     */
    @FormUrlEncoded
    @POST("/lg/todo/add/json")
    Observable<DataResponse> toAddToDo(@FieldMap Map<String, Object> map);

    /**
     * 更新一条Todo内容
     * <p>
     * id: 拼接在链接上，为唯一标识
     * title: 更新标题
     * content: 新增详情
     * date: 2018-08-01
     * status: 0 // 0为未完成，1为完成
     * type: 0
     *
     * @return BaseModel
     */
    @FormUrlEncoded
    @POST("/lg/todo/update/{id}/json")
    Observable<DataResponse> updateTodo(@Path("id") int id, @FieldMap Map<String, Object> map);


    @POST("/lg/todo/update/83/json")
    Observable<DataResponse> updateToDoItem(int id, int status);

    //
//
    @GET("/friend/json")
    Observable<DataResponse<List<Friend>>> getFriends();


    @GET("/hotkey/json")
    Observable<DataResponse<List<Friend>>> getHotKey();


    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     *
     * @param page page
     * @param k    POST search key
     */
    @POST("/article/query/{page}/json")
    @FormUrlEncoded
    Observable<DataResponse<Article>> getSearchArticles(@Path("page") int page, @Field("k") String k);
//
//    //http://www.wanandroid.com/article/query?k=%E9%9D%A2%E8%AF%95
//
//    /**
//     * 搜索
//     * http://www.wanandroid.com/article/query/0/json
//     *
//     * @param k POST search key
//     */
//    @POST("/article/query/json")
//    @FormUrlEncoded
//    Observable<Article> getSearchArticles(@Field("k") String k);
//
//
//    @GET("/coin/rank/{page}/json")
//    Observable<DataResponse<Rank>> getRank(@Path("page") int i);
//
//    @GET("/lg/coin/userinfo/json")
//    Observable<DataResponse<UserCoin>> getUserCoin();

//    https://www.wanandroid.com/lg/coin/userinfo/json

    //    Observable<DataResponse<Rank>> getUserCoin();
    @GET("/lg/coin/userinfo/json")
    Observable<Rank> getuserCoin();
}
