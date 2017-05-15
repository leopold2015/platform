package com.mgh.controller;

import com.mgh.domain.User;
import com.mgh.serviceManager.UserManager;
import com.mgh.util.checkNumber.CheckPhone;
import com.mgh.util.session.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/userRegister/{user_phone}/{user_pwd}/{user_name}")
    @ResponseBody
    public Map<String,Object> userRegister(@PathVariable("user_phone") String user_phone,@PathVariable("user_pwd") String user_pwd,@PathVariable("user_name") String user_name){
        userManager.insertUser(user_phone,user_pwd,user_name);
        return generateSuccessMsg("注册成功！");
    }
    @RequestMapping(value="/checkUser_phone")
    @ResponseBody
    public Map<String,Object> checkUser_phone(@RequestParam("user_phone") String user_phone){
        return userManager.checkUser_phone(user_phone);
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

    @RequestMapping(value="/sendCode")
    @ResponseBody
    public Map<String,Object> sendCode(@RequestParam("user_phone") String user_phone){
        Map<String,Object> successMsg = generateSuccessMsg("获取验证码成功!");
        int code = (int)((Math.random()*9+1)*100000);
        userManager.sendMessage(code,user_phone);
        successMsg.put("code",code);
        return successMsg;
    }

}
