package com.shenjinxiang.jkits;

import com.shenjinxiang.jkits.core.Consts;
import org.apache.commons.cli.*;

public class Start {

    public static void main(String[] args) throws Exception {
        commondLine(args);
//        if (StrKit.isJar()) {
//            configCommondLine(args);
//        } else {
//            Consts.setDevMode(true);
//        }
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

    private static void commondLine(String[] args) throws ParseException {
        System.out.println("输入参数：");
        for (String arg: args) {
            System.out.println(arg);
        }
        System.out.println("参数打印结束");

        Options options = new Options();

        Option wzOption = Option.builder().argName("wz").desc("网站操作").build();
        options.addOption(wzOption);

        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, args);
    }
}
