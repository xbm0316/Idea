package cn.gdpi.bookmall.service;

import cn.gdpi.bookmall.util.Return;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:34
 ***/
public interface ICollectService {
    /**
     * 收藏书籍
     * @param isbn
     * @param token
     * @return
     */
    Return collectBook(String isbn, String token);

    /**
     * 用户收藏的书籍列表
     * @param token
     * @return
     */
    Return collectBookList(String token,int page,int limit);

    /**
     * 是否收藏了书籍
     * @param isbn
     * @param token
     * @return
     */
    Return isCollectBook(String isbn, String token);

    /**
     * 取消收藏
     * @param isbn
     * @param token
     * @return
     */
    Return cancelCollect(String isbn, String token);
}
