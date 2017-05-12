package com.mgh.util.currentTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mgh on 2017/3/25.
 */
public class CurrentDate {

    public static Date getCurrentDate() {
        Date today = new Date();
        try{
            Calendar now = Calendar.getInstance();
            Date date = new Date();
            System.out.println(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(date);
            today = sdf.parse(dateNowStr);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return today;
        /*System.out.println("格式化后的日期：" + dateNowStr);

        String str = "2012-1-13 17:26:33";  //要跟上面sdf定义的格式一样
        Date today = sdf.parse(str);
        System.out.println("字符串转成日期：" + today);*/
    }
}
