package cn.gdpi.bookmall.service;

import cn.gdpi.bookmall.pojo.User;
import cn.gdpi.bookmall.util.Return;
import cn.gdpi.bookmall.vo.LoginVO;
import cn.gdpi.bookmall.vo.UpdatePwdVO;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 19:20
 ***/
public interface IUserService {

    /**
     * 根据注册用户的姓名来查询表中是否已经含有该用户
     * @param uname
     * @return
     */
    int userExit(String uname);

    /**
     * 根据姓名查找到该用户的所有信息
     * @param uname
     * @return
     */
    User findUserByUname(String uname);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Return addUser(User user);

    /**
     * 用户登录
     * @param loginVO
     * @return
     */
    Return loginUser(LoginVO loginVO);

    /**
     * 管理员登录
     * @param Name
     * @param Password
     * @return
     */
    Return loginAdmin(LoginVO loginVO);

    /**
     * 用户修改密码
     * @param pwdVO
     * @param token
     * @return
     */
    Return changePassword(UpdatePwdVO pwdVO,String token);




}
