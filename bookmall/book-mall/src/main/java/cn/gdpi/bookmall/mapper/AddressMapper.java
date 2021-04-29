package cn.gdpi.bookmall.mapper;

import cn.gdpi.bookmall.pojo.Address;

import java.util.List;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-18 20:23
 *
***/
public interface AddressMapper {

    int insert(Address record);

    List<Address> selectList(String phone);
}