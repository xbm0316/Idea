package cn.gdpi.bookmall.mapper;

import cn.gdpi.bookmall.pojo.BookImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-18 10:40
 *
***/
public interface BookImageMapper {

    /**
     * 添加书籍图片
     * @param bookImage
     * @return
     */
    int insertBookImage(BookImage bookImage);

    /**
     * 查询书籍的所有图片
     * @param isbn
     * @param type
     * @return
     */
    List<BookImage> selectBookImage(@Param("isbn") String isbn);
}