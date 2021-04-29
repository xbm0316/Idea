package cn.gdpi.bookmall.service.impl;

import cn.gdpi.bookmall.mapper.CartMapper;
import cn.gdpi.bookmall.pojo.CartItem;
import cn.gdpi.bookmall.service.ICartService;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.JwtTokenUtil;
import cn.gdpi.bookmall.util.Return;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 19:28
 ***/
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service("iCartService")
public class CartServiceImpl implements ICartService {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Return addBook(String token, String isbn, Integer count) {
        CartItem cartItem=new CartItem();
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        cartItem.setUserId(phone);
        cartItem.setCount(count);
        cartItem.setProduct(isbn);
        CartItem ci=cartMapper.selectCartItem(phone,isbn);
        if(ObjectUtils.isEmpty(ci)){
            int n=cartMapper.insertCartItem(cartItem);
            if(n!=1){
                return Return.error(Code.ERROR_CODE,"添加购物车失败");
            }
        }else {
           int n=cartMapper.updateCount(phone,isbn,ci.getCount()+count);
            if(n!=1){
                return Return.error(Code.ERROR_CODE,"添加购物车失败");
            }
        }
        return Return.ok(Code.OK_CODE,"添加购物车成功");
    }

    @Override
    public Return delBook(String token, String isbn) {
        int n= cartMapper.delectBook(jwtTokenUtil.getPhoneFromToken(token),isbn);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"删除失败");
        }
        return Return.ok(Code.OK_CODE,"删除成功");
    }

    @Override
    public Return updateCount(String token, String isbn, Integer count) {
        int n= cartMapper.updateCount(jwtTokenUtil.getPhoneFromToken(token),isbn,count);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"更新数量失败");
        }
        return Return.ok(Code.OK_CODE,"更新数量成功");
    }

    @Override
    public Return cartItemList(String token) {
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        List<CartItem> list= cartMapper.selectCartItemList(phone);
        return Return.ok(Code.OK_CODE,list);
    }
}
