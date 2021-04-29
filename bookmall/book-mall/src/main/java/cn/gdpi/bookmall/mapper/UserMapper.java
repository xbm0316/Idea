package cn.gdpi.bookmall.mapper;

import cn.gdpi.bookmall.pojo.Address;
import cn.gdpi.bookmall.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *@author lihaotao
 *@description 说明
 *@date 2020-12-17 19:16
 *
***/
public interface UserMapper {

    /**
     * 根据注册用户的姓名来查询表中是否已经含有该用户
     * @param uname
     * @return
     */
    int userExit(String uname);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 用户登录验证,输入uname然后查找到这个用户的所有信息
     * @param uname
     * @return
     */
    @Select(value = "select * from tb_user where uname=#{uname} ")
    User findUserByUname(String uname);


    //用户密码修改
    void changePassword(String uname,String npwd);

    //用户地址增加
    void addAddress(Address address);


    /**
     * 根据phone查询用户
     * @param phone
     * @return
     */
    User selectUserByPhone(String phone);

    /**
     * 更新密码
     * @param phone
     * @param npwd
     * @return
     */
    int updatePwd(@Param("phone") String phone,@Param("npwd") String npwd);
}