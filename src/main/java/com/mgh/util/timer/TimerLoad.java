package com.mgh.util.timer;

import java.lang.reflect.Method;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mgh on 2017/5/10.
 */
public class TimerLoad {
    public static void timer3(Class t) {
        Timer timer = new Timer();
        Method[] methods = t.getMethods();
        for(Method method:methods){
            String methodName = method.getName();
            if(methodName.equals("selectCommunicateByTopicId")){
                timer.scheduleAtFixedRate(new TimerTask() {
                    public void run() {

                    }
                }, 1000, 2000);
            }
        }

    }
}
