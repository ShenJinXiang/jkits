package com.shenjinxiang.jkits.kit;

import com.shenjinxiang.jkits.core.Consts;

import java.io.*;
import java.util.Base64;

public class Base64Kit {

    public static byte[] encodeByte(byte[] bytes) {
        return Base64.getEncoder().encode(bytes);
    }

    public static String encode(byte[] bytes) throws UnsupportedEncodingException {
        return new String(encodeByte(bytes), Consts.ENCODE);
    }

    public static byte[] encodeByte(String str) throws UnsupportedEncodingException {
        if (StrKit.isBlank(str)) {
            return null;
        }
        return encodeByte(str.getBytes(Consts.ENCODE));
    }

    public static String encode(String str) throws UnsupportedEncodingException {
        if (StrKit.isBlank(str)) {
            return null;
        }
        return encode(str.getBytes(Consts.ENCODE));
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

    public static String decode(byte[] bytes) throws UnsupportedEncodingException {
        return new String(decodeByte(bytes), Consts.ENCODE);
    }

    public static byte[] decodeByte(String str) throws UnsupportedEncodingException {
        if (StrKit.isBlank(str)) {
            return null;
        }
        return decodeByte(str.getBytes(Consts.ENCODE));
    }

    public static String decode(String str) throws UnsupportedEncodingException {
        if (StrKit.isBlank(str)) {
            return null;
        }
        return decode(str.getBytes(Consts.ENCODE));
    }

    private static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

}
