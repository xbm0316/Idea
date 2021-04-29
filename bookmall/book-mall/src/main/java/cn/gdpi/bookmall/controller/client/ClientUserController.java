package cn.gdpi.bookmall.controller.client;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.pojo.User;
import cn.gdpi.bookmall.service.IUserService;
import cn.gdpi.bookmall.util.Return;
import cn.gdpi.bookmall.vo.LoginVO;
import cn.gdpi.bookmall.vo.UpdatePwdVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-17 19:19
 ***/

@RestController
@RequestMapping("/client/user")
public class ClientUserController {

    @Resource
    private IUserService iUserService;
    private final Logger logger = LoggerFactory.getLogger(ClientUserController.class);
    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping(value = "register")
    public Return register(@RequestBody User user){
        return iUserService.addUser(user);
    }

    /**
     * 用户登录
     * @param loginVO
     * @return
     */
    @PostMapping(value = "loginUser")
    public Return loginUser(@RequestBody LoginVO loginVO){
        logger.info("用户名： "+loginVO.getUname()+"进行登录中");
        return iUserService.loginUser(loginVO);
    }

    /**
     * 用户密码修改
     * @param pwdVO
     * @param token
     * @return
     */
    @PostMapping(value = "changePassword")
    @Intercept
    public Return changePassword(@RequestBody UpdatePwdVO pwdVO,@RequestHeader(value = "Authorization",required = false) String token){

        return iUserService.changePassword(pwdVO,token);
    }

}
