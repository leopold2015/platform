package com.mgh.serviceManager;

import com.mgh.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by mgh on 2017/4/24.
 */
public interface UserManager {

    void userLogin(String userPhone,String userPwd);
    void checkUser_phone(String user_phone);
    void insertUser(User user);
    void userQuit();
    User showUserByUser_id(int user_id);

}
