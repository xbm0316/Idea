package cn.gdpi.bookmall.controller.admin;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.service.IUserService;
import cn.gdpi.bookmall.util.Return;
import cn.gdpi.bookmall.vo.LoginVO;
import cn.gdpi.bookmall.vo.UpdatePwdVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin
@RestController
@RequestMapping(value = "/admin/user")
public class AdminUserController {

    /**
     * 管理员控制层
     */

    @Resource
    private IUserService iUserService;

    /**
     * 管理员登录
     * @param loginVO
     * @return
     */
    @PostMapping(value = "/loginAdmin")
    public Return loginAdmin(@RequestBody LoginVO loginVO){
        return iUserService.loginAdmin(loginVO);
    }
    /**
     * 用户密码修改
     * @param pwdVO
     * @param token
     * @return
     */
    @PostMapping(value = "/changePassword")
    @Intercept(role = 1)
    public Return changePassword(@RequestBody UpdatePwdVO pwdVO, @RequestHeader(value = "Authorization",required = false) String token){
        return iUserService.changePassword(pwdVO,token);
    }
    
}
