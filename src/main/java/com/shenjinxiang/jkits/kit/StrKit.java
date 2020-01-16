package com.shenjinxiang.jkits.kit;

import com.shenjinxiang.jkits.Start;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class StrKit {

    public static boolean isBlank(String str) {
        return null == str || "".equals(str);
    }

    public static String getCrrentFilePath() throws IllegalAccessException {
        return getCurrentFile().getAbsolutePath();
    }

    public static String getCurrentPath() throws IllegalAccessException {
        return getCurrentFile().getParent();
    }

    private static File getCurrentFile() throws IllegalAccessException {
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
        return root;
    }

}
