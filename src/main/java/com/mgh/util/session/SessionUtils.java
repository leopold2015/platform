package com.mgh.util.session;

import com.mgh.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * Created by mgh on 2016/4/20.
 */
public class SessionUtils {

    /**
     * 得到session对象
     * @return
     * @throws SessionNotExitException
     */
    public static HttpSession getSession(){
        ServletRequestAttributes attr = (ServletRequestAttributes)  RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        if(session==null){
            throw new SessionNotExitException();
        }
        return session;
    }
    public static void bindSession(String str,Object obj){
        getSession().setAttribute(str, obj);
    }
    public static void setCurrentUser(User user) {
        getSession().setAttribute("user", user);
    }
    public static User getCurrentUser(){
        return (User)getSession().getAttribute("user");
    }
    public static void logoutSession(String str){
        getSession().setAttribute(str, null);
    }
    public static String getCurrentPath(){
        return getSession().getServletContext().getRealPath("/");
    }
    public static File getWebappPath(){
        File file = new File(getCurrentPath());
        return file.getParentFile();
    }
    public static class SessionNotExitException extends RuntimeException{

        /**
         *
         */
        private static final long serialVersionUID = 1L;

    }
}
