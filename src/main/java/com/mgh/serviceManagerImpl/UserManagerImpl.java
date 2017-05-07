package com.mgh.serviceManagerImpl;

import antlr.debug.MessageAdapter;
import com.mgh.domain.User;
import com.mgh.mapper.UserMapper;
import com.mgh.serviceManager.UserManager;
import com.mgh.util.checkNumber.CheckPhone;
import com.mgh.util.exception.MessageException;
import com.mgh.util.session.SessionUtils;
import com.mgh.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mgh on 2017/4/24.
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void userLogin(String user_phone, String user_pwd) {
        if (StringUtil.isEmpty(user_phone) && StringUtil.isEmpty(user_pwd) && CheckPhone.isMobilePhone(user_phone)) {
            throw new MessageException("请正确填写您的用户名和密码！");
        } else {
            User user = userMapper.selectUserByUser_phone(user_phone);
            if (user == null) {
                throw new MessageException("该用户不存在，请您正确填写您的用户名！");
            }else if(!user_pwd.equals(user.getUserPwd())){
                throw new MessageException("您的密码不正确，请正确填写您的密码！");
            }else if(user.getUserType() !=2){
                throw new MessageException("对不起，您的用户权限不足，无法登陆此区域");
            }
            SessionUtils.bindSession("user",user);
        }
    }

    @Override
    public void checkUser_phone(String user_phone) {
        if(StringUtil.isEmpty(user_phone) && CheckPhone.isMobilePhone(user_phone)){
            throw new MessageException("请正确填写您的用户名和密码！");
        }else{
            User user = userMapper.selectUserByUser_phone(user_phone);
            if(user == null){
                throw new MessageException("该用户尚未注册，可进行注册！");
            }else {
                throw new MessageException("该用户已注册，请重新填写手机号码！");
            }
        }
    }

    @Override
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    @Override
    public void userQuit() {
        if(SessionUtils.getSession().getAttribute("user")!=null){
            SessionUtils.logoutSession("user");
        }else{
            throw new MessageException("您已经退出该系统");
        }
    }


}
