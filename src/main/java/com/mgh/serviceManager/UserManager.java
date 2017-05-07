package com.mgh.serviceManager;

import com.mgh.domain.User;

import java.util.Map;

/**
 * Created by mgh on 2017/4/24.
 */
public interface UserManager {

    void userLogin(String user_phone,String user_pwd);
    void checkUser_phone(String user_phone);
    void insertUser(User user);
    void userQuit();
}
