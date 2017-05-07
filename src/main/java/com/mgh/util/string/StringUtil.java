package com.mgh.util.string;

/**
 * Created by admin on 2016/4/18.
 */
public class StringUtil {
    private static String string="1234567890abcdefghijklmnopqlstuvwxyz";
    /**
     * 判断字符串是否为空
     * @param str
     * @return 是否为空
     * **/
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 如果字符串对象等于null转换非空""，否则不变
     * @param str
     * @return
     */
    public static String swapNull(String str){
        return str == null?"":str;
    }

    //随机生成一个16位的字符串
    public static String generateString(long length){
        String temp="";
        if(length!=0)
        {
            StringBuffer stringBuffer=new StringBuffer();
            int len=string.length();
            for(int i=0;i<length;i++){
                int rand=Math.round((float) Math.random()*len);
                if(rand==len){
                    rand=len-1;
                }
                stringBuffer.append(string.charAt(rand));
            }
            temp=stringBuffer.toString();
        }
        return temp;
    }
}

