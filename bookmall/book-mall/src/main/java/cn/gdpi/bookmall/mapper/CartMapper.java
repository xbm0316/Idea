package cn.gdpi.bookmall.mapper;

import cn.gdpi.bookmall.pojo.CartItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 19:34
 ***/
public interface CartMapper {
    /**
     * 添加书籍到购物车
     * @param cartItem
     * @return
     */
    int insertCartItem(CartItem cartItem);

    /**
     * 购物车删除书籍
     * @param phone
     * @param isbn
     * @return
     */
    int delectBook(@Param("phone") String phone,@Param("isbn") String isbn);

    /**
     * 更新购物车书籍数量
     * @param phone
     * @param isbn
     * @param count
     * @return
     */
    int updateCount(@Param("phone")String phone, @Param("isbn")String isbn, @Param("count")Integer count);

    List<CartItem> selectCartItemList(String phone);

    CartItem selectCartItem(@Param("phone") String phone,@Param("isbn") String isbn);
}
