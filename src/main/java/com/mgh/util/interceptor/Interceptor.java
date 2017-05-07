
package com.mgh.util.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by mgh on 2017/3/8.
 */
public class Interceptor extends HandlerInterceptorAdapter{

    private static final Logger logger = Logger.getLogger(Interceptor.class);

    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       *//* logger.info("拦截器方法已调用！");*//*

        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String uri = requestUri.substring(contextPath.length());

        if(requestUri.contains("/userLoginByUser_pwd")||requestUri.contains("/userMapping")){
            return true;
        }else{
            User user = (User) request.getSession().getAttribute("user");
            if(user==null){
                logger.info("拦截器发挥作用，跳转到登陆页面！！");
                //logger.info("user是："+user.getUser_name());
                //request.getRequestDispatcher("/pages/land.html").forward(request, response);
                response.setCharacterEncoding("UTF-8");
                response.getWriter().append("login");
                return true;
            }else {
                return true;
            }
        }
    }
*/

}
