package cn.gdpi.bookmall.mapper;

import cn.gdpi.bookmall.dto.AdminProductListBook;
import cn.gdpi.bookmall.dto.ClientIndexBookDTO;
import cn.gdpi.bookmall.dto.RecommendedBookDTO;
import cn.gdpi.bookmall.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-17 19:18
 *
***/
public interface BookMapper {

    /**
     * 根据key查询书列表
     * @param key
     * @return
     */
    List<ClientIndexBookDTO> selectBooksLikeKey(@Param("key") String key);





    /**
     * 添加书籍
     * @param book
     * @return
     */
    int insertBook(Book book);

    /**
     * 根据 isbn 查询书籍详情
     * @param isbn
     * @return
     */
    Book selectOne(String isbn);

    /**
     * 更新书籍
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 图书列表
     * @return
     */
    List<AdminProductListBook> selectAdminProductListBooks();

    List<RecommendedBookDTO> selectrecommendedBooks();
}