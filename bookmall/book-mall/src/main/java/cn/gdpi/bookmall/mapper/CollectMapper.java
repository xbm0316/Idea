package cn.gdpi.bookmall.mapper;

import cn.gdpi.bookmall.dto.CollectBookDTO;
import cn.gdpi.bookmall.pojo.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-18 16:17
 *
***/
public interface CollectMapper {


    /**
     * 新增收藏
     * @param collect
     * @return
     */
    int insertCollect(Collect collect);

    /**
     * 根据phone查询收藏的书籍列表
     * @param phone
     * @return
     */
    List<CollectBookDTO> selectCollectBooks(String phone);

    /**
     * 用户是否收藏了书籍
     * @param isbn
     * @param phone
     * @return
     */
    int selectCollectBook(@Param("isbn") String isbn, @Param("phone") String phone);

    int delectCollect(@Param("isbn") String isbn,@Param("phone")  String phone);
}