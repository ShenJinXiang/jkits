package com.shenjinxiang.jkits;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.security.ProtectionDomain;

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
        System.out.println(getCurrentFilePath());
        System.out.println(Class.class.getResource("/").getPath());
        System.out.println(Start.class.getResource("/").getPath());
    }

    public static String getCurrentFilePath() throws IllegalAccessException {
        ProtectionDomain protectionDomain = Start.class.getProtectionDomain();
        CodeSource codeSource = protectionDomain.getCodeSource();
        URI location = null;
        try {
            location = null == codeSource ? null : codeSource.getLocation().toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String path = null == location ? null : location.getSchemeSpecificPart();
        if (null == path) {
            throw new IllegalAccessException("unable to determine code source archive");
        }
        File root = new File(path);
        if (!root.exists()) {
            throw new IllegalAccessException("Unable to determine code source archive from " + root);
        }
//        return root.getPath();
//        return root.getAbsolutePath();
        return root.getParent();
    }
}
