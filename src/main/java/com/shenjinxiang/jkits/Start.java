package com.shenjinxiang.jkits;

import com.shenjinxiang.jkits.kit.StrKit;

public class Start {

    public static void main(String[] args) throws IllegalAccessException {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println(df.format(new Date()));
//            }
//        }, 0, 1000);
        System.out.println(System.getProperty("user.dir"));
        System.out.println(StrKit.getCrrentFilePath());
        System.out.println(StrKit.getCurrentPath());
        System.out.println(Class.class.getResource("/").getPath());
        System.out.println(Start.class.getResource("/").getPath());
    }

}
