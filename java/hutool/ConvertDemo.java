package com.tuy.hutool.hutool.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import com.tuy.hutool.hutool.pojo.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * hutool转换
 * @author tuy
 * @version 1.0
 * @date 2019/12/26 22:17
 */
public class ConvertDemo {

    /**
    * 转换为字符串
     * toStr(Object value, String defaultValue) 如果转换失败返回默认值
     * toStr(Object value) 如果转换失败返回null
    */
    public static void convertString() {

        int a = 1;
        String as = Convert.toStr(a);
        System.out.println(as); //1

        List list=new ArrayList();
        String ls = Convert.toStr(list);
        System.out.println(ls); //[]

        String ns = Convert.toStr(null,"exception");
        System.out.println(ns); //exception

        String bs = Convert.toStr(true);
        System.out.println(bs); //true

        long[] array = {1,2,3,4,5,6};
        System.out.println(Convert.toStr(array)); //[1, 2, 3, 4, 5, 6]

    }

    /**
     * 转换为Long
     * toLong(Object value, Long defaultValue) 如果转换失败返回默认值
     * toLong(Object value) 如果转换失败返回null
     */
    public static void convertLong() {

        String a = "87654321";
        Long al = Convert.toLong(a);
        System.out.println(al); //87654321

        String b = "abcdefg";
        Long bl = Convert.toLong(b);
        System.out.println(bl); //null

        Double d = 33.33d;
        Long dl = Convert.toLong(d);
        System.out.println(dl); //33

    }

    /**
     * * 转换为Double
     * toDouble(Object value, Double defaultValue) 如果转换失败返回默认值
     * toDouble(Object value) 如果转换失败返回null
     */
    public static void convertDouble() {

        String a = "123";
        Double al = Convert.toDouble(a);
        System.out.println(al); //123.0

        int i = 123;
        Double il = Convert.toDouble(i);
        System.out.println(il); //123.0

    }

    /**
     * * 转换为BigDecimal
     * toBigDecimal(Object value, BigDecimal defaultValue) 如果转换失败返回默认值
     * toBigDecimal(Object value) 如果转换失败返回null
     */
    public static void convertBigDecimal() {

        String a = "123";
        BigDecimal al = Convert.toBigDecimal(a);
        System.out.println(al); //123

        Double d = 22.222;
        BigDecimal dl = Convert.toBigDecimal(d);
        System.out.println(dl); //22.222

    }

    /**
     * * 转换为List
     * toList(Object value) 如果转换失败返回默认值
     */
    public static void convertList() {

        long[] array = {1,2,3,4,5,6};
        List al = Convert.toList(array);
        System.out.println(al); //[1, 2, 3, 4, 5, 6]

        User[] users = {new User("zhangshan",12),new User("lisi",13)};
        List<User> userList = Convert.toList(User.class,users);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getName());
        }
    }

    /**
     * 其他
     */
    public static void convertOther() {

        //金额大小写
        double a = 67556.32;
        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);

        //编码转换
        String b = "我不是乱码";
        //转换后result为乱码
        String result = Convert.convertCharset(b, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");

    }

}
