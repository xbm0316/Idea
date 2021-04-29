package cn.gdpi.bookmall.service;

import cn.gdpi.bookmall.pojo.Book;
import cn.gdpi.bookmall.util.Return;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 19:22
 ***/
public interface IBookService {
    /**
     * 搜索 分页
     * @param searchKey
     * @param page
     * @param limit
     * @return
     */
    Return booksBySearch(String searchKey, int page, int limit);

    /**
     * 添加书籍
     * @param book
     * @param files
     * @return
     */
    Return insertBook(Book book, MultipartFile[] files);

    /**
     * 书籍详情
     * @param isbn
     * @return
     */
    Return bookInfo(String isbn);

    /**
     * 书籍列表
     * @return
     */
    Return bookList(int page, int limit);

    /**
     * 更新书籍信息
     * @param book
     * @return
     */
    Return bookUpdate(Book book);

    /**
     * 推荐书籍列表
     * @return
     */
    Return recommendedBooks();
}
