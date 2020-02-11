package com.shenjinxiang.jkits;

import com.shenjinxiang.jkits.core.Consts;
import com.shenjinxiang.jkits.kit.StrKit;
import org.apache.commons.cli.*;

public class Start {

    public static void main(String[] args) throws Exception {
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(StrKit.getCrrentFilePath());
//        System.out.println(StrKit.getCurrentPath());
//        System.out.println(Class.class.getResource("/").getPath());
//        System.out.println(Start.class.getResource("/").getPath());
        if (StrKit.isJar()) {
            configCommondLine(args);
        } else {
            Consts.setDevMode(true);
        }
    }

    private static void configCommondLine(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("dev", "是否开发者模式运行");

        // 解析命令行参数
        CommandLineParser parser = new DefaultParser();
        CommandLine cl = parser.parse(options, args);
        boolean devMode = cl.hasOption("dev");
        Consts.setDevMode(devMode);
    }

}
