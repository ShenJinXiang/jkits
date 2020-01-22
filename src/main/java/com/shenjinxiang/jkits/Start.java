package com.shenjinxiang.jkits;

import com.shenjinxiang.jkits.kit.StrKit;

public class Start {

    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(StrKit.getCrrentFilePath());
//        System.out.println(StrKit.getCurrentPath());
//        System.out.println(Class.class.getResource("/").getPath());
//        System.out.println(Start.class.getResource("/").getPath());
        configCommondLine(args);
        if (StrKit.isJar()) {
            System.out.println("jar包运行");
        } else {
            System.out.println("ide启动");
        }
    }

    private static void configCommondLine(String[] args) {
    }

}
