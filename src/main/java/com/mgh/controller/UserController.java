package com.mgh.controller;

import com.mgh.domain.User;
import com.mgh.serviceManager.UserManager;
import com.mgh.util.checkNumber.CheckPhone;
import com.mgh.util.session.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by mgh on 2017/4/24.
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
    @Autowired
    private UserManager userManager;

    @RequestMapping(value="/userLogin")
    @ResponseBody
    public Map<String,Object> userLogin(@RequestParam("userPhone") String userPhone,@RequestParam("userPwd") String userPwd){
        userManager.userLogin(userPhone,userPwd);
        return generateSuccessMsg("登录成功！");
    }

    @RequestMapping(value="/userRegister")
    @ResponseBody
    public Map<String,Object> userRegister(@RequestParam("user") User user){
        userManager.checkUser_phone(user.getUser_phone());
        userManager.insertUser(user);
        return generateSuccessMsg("注册成功！");
    }
    @RequestMapping(value="/checkUser_phone")
    @ResponseBody
    public Map<String,Object> checkUser_phone(@RequestParam("user_phone") String user_phone){
        userManager.checkUser_phone(user_phone);
        return generateSuccessMsg("该用户可注册！");
    }

    @RequestMapping(value="/userQuit")
    @ResponseBody
    public Map<String,Object> userQuit(){
        userManager.userQuit();
        return generateSuccessMsg("用户退出成功！");
    }

    @RequestMapping(value="/showUserByUser_id")
    @ResponseBody
    public Map<String,Object> showUserByUser_id(){
        User user = userManager.showUserByUser_id(SessionUtils.getCurrentUser().getUser_id());
        Map<String,Object> successMsg = generateSuccessMsg("查询成功！");
        successMsg.put("user",user);
        return successMsg;
    }


}
