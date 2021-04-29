package cn.gdpi.bookmall.service.impl;

import cn.gdpi.bookmall.mapper.AddressMapper;
import cn.gdpi.bookmall.pojo.Address;
import cn.gdpi.bookmall.service.IAddressService;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.JwtTokenUtil;
import cn.gdpi.bookmall.util.Return;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 21:35
 ***/
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service("iAddressService")
public class AddressServiceImpl implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Return addAddress(Address address, String token) {
        address.setUserId(jwtTokenUtil.getPhoneFromToken(token));
        address.setAdded(new Date());
        int n=addressMapper.insert(address);
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"新增地址失败");
        }
        return Return.ok(Code.OK_CODE,"新增地址成功");
    }

    @Override
    public Return addressList(String token) {
        String phone = jwtTokenUtil.getPhoneFromToken(token);
        List<Address> list= addressMapper.selectList(phone);
        return Return.ok(Code.OK_CODE,list);
    }
}
