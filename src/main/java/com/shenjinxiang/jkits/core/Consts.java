package com.shenjinxiang.jkits.core;

public class Consts {

    public static final String ENCODE = "UTF-8";
    public static final int BUFFER_SIZE = 1024 * 10;

    private static boolean devMode = true;

    public static boolean isDevMode() {
        return devMode;
    }

    public static void setDevMode(boolean dev_mode) {
        devMode = dev_mode;
    }

}
