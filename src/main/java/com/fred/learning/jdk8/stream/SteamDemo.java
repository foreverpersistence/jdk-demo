package com.fred.learning.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午2:18
 * @Description: 一下数据，急性操作帅选 用户：
 *    要求： 一行代码，时长1min
 *    1、全部满足偶数 id
 *    2、age 》 24
 *    3、用户名转为大写
 *    4、用户名字母倒排序
 *    5、只能输出一个名子
 */
public class SteamDemo {

    public static void main(String[] args) {
        User u1 = new User(11,"a", 23);
        User u2 = new User(12,"b", 24);
        User u3 = new User(13,"c", 22);
        User u4 = new User(14,"d", 28);
        User u5 = new User(15,"e", 26);

        //集合管理数据
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
        //计算交给 stream
        users.stream().filter(u -> u.getId() % 2 == 0)
                        .filter(u -> {return  u.getAge() > 24;})
                        .map(u -> u.getUserName().toUpperCase())
                        .sorted((o1, o2) -> {return  o2.compareTo(o1);})
                        .limit(1)
                        .forEach(System.out::println);
    }
}
