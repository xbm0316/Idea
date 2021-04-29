package cn.gdpi.bookmall.service;

import cn.gdpi.bookmall.util.Return;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 19:28
 ***/
public interface ICartService {
    /**
     * 购物车添加书籍
     * @param token
     * @param isbn
     * @param count
     * @return
     */
    Return addBook(String token, String isbn, Integer count);

    /**
     * 购物车输出书籍
     * @param token
     * @param isbn
     * @return
     */
    Return delBook(String token, String isbn);

    /**
     * 购物车书籍加数量
     * @param token
     * @param isbn
     * @param count
     * @return
     */
    Return updateCount(String token, String isbn, Integer count);

    /**
     * 购物车项列表
     * @param token
     * @return
     */
    Return cartItemList(String token);
}
