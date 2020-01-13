package com.shenjinxiang.jkits.kit;

import com.shenjinxiang.jkits.core.Consts;

import java.io.*;
import java.util.Base64;

public class Base64Kit {

    public static byte[] encodeByte(byte[] bytes) {
        return Base64.getEncoder().encode(bytes);
    }

    public static String encode(byte[] bytes) {
        try {
            return new String(encodeByte(bytes), Consts.ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encodeByte(String str) {
        if (StrKit.isBlank(str)) {
            return null;
        }
        try {
            return encodeByte(str.getBytes(Consts.ENCODE));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encode(String str) {
        if (StrKit.isBlank(str)) {
            return null;
        }
        try {
            return encode(str.getBytes(Consts.ENCODE));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeFile(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            return encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null == inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] decodeByte(byte[] bytes) {
        return Base64.getDecoder().decode(bytes);
    }

    public static String decode(byte[] bytes) {
        try {
            return new String(decodeByte(bytes), Consts.ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] decodeByte(String str) {
        if (StrKit.isBlank(str)) {
            return null;
        }
        try {
            return decodeByte(str.getBytes(Consts.ENCODE));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decode(String str) {
        if (StrKit.isBlank(str)) {
            return null;
        }
        try {
            return decode(str.getBytes(Consts.ENCODE));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

}
