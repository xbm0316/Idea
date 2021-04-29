package cn.gdpi.bookmall.service.impl;

import cn.gdpi.bookmall.dto.CollectBookDTO;
import cn.gdpi.bookmall.mapper.CollectMapper;
import cn.gdpi.bookmall.pojo.Collect;
import cn.gdpi.bookmall.service.ICollectService;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.JwtTokenUtil;
import cn.gdpi.bookmall.util.Return;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:35
 ***/
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service("iCollectService")
public class CollectServiceImpl implements ICollectService {

    @Resource
    private CollectMapper collectMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Return collectBook(String isbn, String token) {
        Collect collect = new Collect();
        collect.setProduct(isbn);
        collect.setUserId(jwtTokenUtil.getPhoneFromToken(token));

       int num= collectMapper.insertCollect(collect);
       if(num!=1){
           return Return.error(Code.ERROR_CODE,"收藏失败");
       }
        return Return.ok(Code.OK_CODE,"收藏成功");
    }

    @Override
    public Return collectBookList(String token,int page,int limit) {
        PageHelper.startPage(page,limit);
        List<CollectBookDTO>  books=collectMapper.selectCollectBooks(jwtTokenUtil.getPhoneFromToken(token));
        PageInfo<CollectBookDTO> pageInfo=new PageInfo<>(books);
        return Return.ok(Code.OK_CODE,pageInfo);
    }

    @Override
    public Return isCollectBook(String isbn, String token) {
        String phone =jwtTokenUtil.getPhoneFromToken(token);
        int n=collectMapper.selectCollectBook(isbn,phone);
        return Return.ok(Code.OK_CODE,n);
    }

    @Override
    public Return cancelCollect(String isbn, String token) {
        String phone =jwtTokenUtil.getPhoneFromToken(token);
        int n=collectMapper.delectCollect(isbn,phone);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"取消收藏失败");
        }
        return Return.ok(Code.OK_CODE,"取消收藏成功");
    }
}
