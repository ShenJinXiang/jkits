package com.shenjinxiang.jkits.kit;

import com.shenjinxiang.jkits.Start;
import com.shenjinxiang.jkits.core.Consts;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.security.MessageDigest;
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


    public static String md5(String str) {
        try {
            return md5(str.getBytes(Consts.ENCODE));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5(File file) {
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = new FileInputStream(file);
            bufferedInputStream= new BufferedInputStream(inputStream);
            byte[] bytes = new byte[Consts.BUFFER_SIZE];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            byteArrayOutputStream.flush();
            byte[] obytes = byteArrayOutputStream.toByteArray();
            return md5(obytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String md5(byte[] bytes) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(bytes);
        byte s[] = m.digest();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
        }
        return result;
    }

    public static void main(String[] args) {
//        String str = "中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府中华人民共和国，中央人民政府";
        String path = "D:\\shenjinxiang\\MavenResp\\com\\qysoft\\taxrpc\\zhsbrpc\\0.0.1-SNAPSHOT\\zhsbrpc-0.0.1-SNAPSHOT.jar";
        File file = new File(path);
        System.out.println(md5(file));
    }

}
