package com.shenjinxiang.jkits.kit;

import org.jsoup.nodes.Document;
import org.junit.Test;

public class JsoupKitTest {

    @Test
    public void test1() {
        String url = "https://www.shenjinxiang.com";
        try {
            Document document = JsoupKit.doGetDocument(url, null);
            System.out.println(document.html());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
