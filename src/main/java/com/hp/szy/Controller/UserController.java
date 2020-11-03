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
 public UserService userService;


@RequestMapping("/login")
public Msg login( String username,String password) throws UnsupportedEncodingException {
    String realPassword = userService.getPassword(username);
    if (realPassword == null) {
        return Msg.fail().add("info","错误");
    } else if (!realPassword.equals(password)) {
        return Msg.fail().add("info","密码错误");
    } else {
        return Msg.success().add("token", JWTUtil.createToken(username));
    }
}











}
