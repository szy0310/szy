package com.hp.szy.Controller;

import com.hp.szy.Utils.JWTUtil;
import com.hp.szy.Utils.model.Msg;
import com.hp.szy.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@RestController
public class UserController {
    @Resource
 private UserService userService;
//登录
@RequestMapping("/login")
@ResponseBody
public Msg login( String loginName,String password) throws UnsupportedEncodingException {
    String realPassword = userService.getPassword(loginName);

    if (realPassword == null) {
        return Msg.fail().add("info","错误");
    } else if (!realPassword.equals(password)) {
        return Msg.fail().add("info","密码错误");
    } else {
        return Msg.success().add("token", JWTUtil.createToken(loginName));
    }
}


}
