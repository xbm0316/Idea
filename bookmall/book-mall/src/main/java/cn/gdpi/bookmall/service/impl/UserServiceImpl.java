package cn.gdpi.bookmall.service.impl;

import cn.gdpi.bookmall.mapper.UserMapper;
import cn.gdpi.bookmall.pojo.User;
import cn.gdpi.bookmall.service.IUserService;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.JwtTokenUtil;
import cn.gdpi.bookmall.util.Return;
import cn.gdpi.bookmall.vo.LoginVO;
import cn.gdpi.bookmall.vo.UpdatePwdVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 19:20
 ***/
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service("iUserService")
public class UserServiceImpl implements IUserService {


    @Resource
    private UserMapper userMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;



    @Override
    public int userExit(String uname) {
        return userMapper.userExit(uname);
    }

    @Override
    public User findUserByUname(String uname) {
        return userMapper.findUserByUname(uname);
    }

    //用户注册，调用userMapper中addUser方法
    @Override
    public Return addUser(User user) {
        int count = userExit(user.getUname());
        if(count > 0){
            return Return.error(Code.ERROR_CODE,"该用户已经存在！");
        }
        user.setRole(0);
        int n = userMapper.addUser(user);
        if(n==1){
            return Return.ok(Code.OK_CODE,"","注册成功");
        }
        return Return.error(Code.ERROR_CODE,"注册失败");

    }


    /**
     * 用户登录
     * @param loginVO
     * @return
     */
    @Override
    public Return loginUser(LoginVO loginVO){
        if(!StringUtils.hasText(loginVO.getUname())||!StringUtils.hasText(loginVO.getUpwd())){
            return Return.error(Code.ERROR_CODE,"用户名或密码为空");
        }
        int count = userExit(loginVO.getUname());
        if(count!=1){
            return Return.error(Code.ERROR_CODE,"用户名或密码错误");
        }
        User user = findUserByUname(loginVO.getUname());
        if(!loginVO.getUpwd().equals(user.getUpwd())){
            return Return.error(Code.ERROR_CODE,"用户名或密码错误");
        }
        String token = jwtTokenUtil.generateToken(user);
        Map<String, Object> map = new HashMap<>(2);
        map.put("token",token);
        user.setUpwd("");
        map.put("user",user);
        return Return.ok(Code.OK_CODE,map,"登录成功！");
    }

    //管理员登录，与普通用户登录的区别在于区别user表中的role字段是1还是0
    @Override
    public Return loginAdmin(LoginVO loginVO){
        int count = userExit(loginVO.getUname());
        if(count != 1){
            return Return.error(Code.ERROR_CODE,"用户名或密码错误！");
        }
        User user = findUserByUname(loginVO.getUname());
        if(!loginVO.getUpwd().equals(user.getUpwd())){
            return Return.error(Code.ERROR_CODE,"用户名或密码错误！");

        }
        if(user.getRole() == 0){
            return Return.error(Code.ERROR_CODE,"该用户不是管理员！");
        }
        Map<String, Object> map = new HashMap<>(2);
        String token = jwtTokenUtil.generateToken(user);
        map.put("token",token);
        user.setUpwd("");
        map.put("user",user);
        return Return.ok(Code.OK_CODE,map,"登录成功！");
    }

    //修改用户密码
    @Override
    public Return changePassword(UpdatePwdVO pwdVO,String token) {
        String phone=jwtTokenUtil.getPhoneFromToken(token);
        User user = userMapper.selectUserByPhone(phone);
        if(!pwdVO.getUpwd().equals(user.getUpwd())){
            return Return.error(Code.OK_CODE,"原始密码错误！");
        }
        int n= userMapper.updatePwd(phone,pwdVO.getNpwd());
        if(n!=1){
            return Return.error(Code.ERROR_CODE,"密码修改失败!");
        }
        return Return.ok(Code.OK_CODE,null,"密码修改成功！");
    }

}
