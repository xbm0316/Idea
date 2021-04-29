package cn.gdpi.bookmall.service;

import cn.gdpi.bookmall.pojo.Address;
import cn.gdpi.bookmall.util.Return;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 21:35
 ***/
public interface IAddressService {
    /**
     * 新增地址
     * @param address
     * @param token
     * @return
     */
    Return addAddress(Address address,String token);

    /**
     * 用户所有地址
     * @param token
     * @return
     */
    Return addressList(String token);
}
