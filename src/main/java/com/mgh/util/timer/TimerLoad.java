package com.mgh.util.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mgh on 2017/5/10.
 */
public class TimerLoad {
    public static void timer3(Class<T> T) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 1000, 2000);
    }
}
