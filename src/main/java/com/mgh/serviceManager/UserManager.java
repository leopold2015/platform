package com.mgh.serviceManager;

import com.mgh.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by mgh on 2017/4/24.
 */
public interface UserManager {

    void userLogin(String userPhone,String userPwd);
    Map<String,Object> checkUser_phone(String user_phone);
    void insertUser(String user_phone,String user_pwd,String user_name);
    void userQuit();
    User showUserByUser_id(int user_id);
    void sendMessage(int code,String user_phone);

}
