package com.shenjinxiang.jkits.kit;

import org.junit.Test;

public class GzipKitTest {

    @Test
    public void test1() {
        String msg = "我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！";
        System.out.println("zip压缩前的长度：" + msg.getBytes().length);
        byte[] bs1 = GzipKit.compress(msg.getBytes());
        String result = Base64Kit.encode(bs1);
        System.out.println("压缩后的内容：\n" + result);
        System.out.println("压缩后的长度：\n" + bs1.length);
        String msg1 = new String(GzipKit.decompress(bs1));
        System.out.println("解压缩后的内容：\n" + msg1);
        System.out.println("解压缩后的长度：\n" + msg1.getBytes().length);
    }
}
