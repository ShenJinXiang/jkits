package com.shenjinxiang.jkits.kit;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class JsoupKit {

    private static final int MAX_ERROR_CNT = 3;
    private static Logger log = LoggerFactory.getLogger(JsoupKit.class);

    private static final String[] UA = {
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36 OPR/37.0.2178.32",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586",
            "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko",
            "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)",
            "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0)",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 BIDUBrowser/8.3 Safari/537.36",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36 Core/1.47.277.400 QQBrowser/9.4.7658.400",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 UBrowser/5.6.12150.8 Safari/537.36",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 TheWorld 7",
            "Mozilla/5.0 (Windows NT 6.1; W…) Gecko/20100101 Firefox/60.0",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36"
    };

    public static Document doGetDocument(String url, Map<String, String> cookies) throws Exception {
        return doGetDocument(url, cookies, null, null);
    }
    public static Document doGetDocument(String url, Map<String, String> cookies, Map<String, String> data) throws Exception {
        return doGetDocument(url, cookies, data, null);
    }
    public static Document doGetDocument(String url, Map<String, String> cookies, Map<String, String> data, Map<String, String> headers) throws Exception {
        Connection connection = Jsoup.connect(url);
        if (null != cookies && !cookies.isEmpty()) {
            connection.cookies(cookies);
        }
        if (null != data && !data.isEmpty()) {
            connection.data(data);
        }
        if (null != headers && !headers.isEmpty()) {
            connection.headers(headers);
        }
        connection.userAgent(randomUA());
        int count = 0;
        while (true) {
            try {
                Document document = connection.get();
                return document;
            } catch (IOException e) {
                count++;
                log.error("Jsoup-get抓取错误：" +
                        "\n\t 次数: " + count +
                        "\n\t Url: " + url +
                        "\n\t Data: " + data +
                        "\n\t Error: " + e.getMessage()
                );
                if (count >= MAX_ERROR_CNT) {
                    throw e;
                }
            }
        }
    }

    public static Document doPostDocument(String url, Map<String, String> cookies) throws Exception {
        return doPostDocument(url, cookies, null);
    }
    public static Document doPostDocument(String url, Map<String, String> cookies, Map<String, String> data) throws Exception {
        return doPostDocument(url, cookies, data, null);
    }
    public static Document doPostDocument(String url, Map<String, String> cookies, Map<String, String> data, Map<String, String> headers) throws Exception {
        Connection connection = Jsoup.connect(url);
        if (null != cookies && !cookies.isEmpty()) {
            connection.cookies(cookies);
        }
        if (null != data && !data.isEmpty()) {
            connection.data(data);
        }
        if (null != headers && !headers.isEmpty()) {
            connection.headers(headers);
        }
        connection.userAgent(randomUA());
        int count = 0;
        while (true) {
            try {
                Document document = connection.post();
                return document;
            } catch (IOException e) {
                count++;
                log.error("Jsoup-post抓取错误：" +
                        "\n\t 次数: " + count +
                        "\n\t Url: " + url +
                        "\n\t Data: " + data +
                        "\n\t Error: " + e.getMessage()
                );
                if (count >= MAX_ERROR_CNT) {
                    throw e;
                }
            }
        }
    }

    public static String ajax(String url, Map<String, String> cookies) throws Exception {
        return ajax(url, cookies, null, null);
    }
    public static String ajax(String url, Map<String, String> cookies, Map<String, String> data) throws Exception {
        return ajax(url, cookies, data, null);
    }
    public static String ajax(String url, Map<String, String> cookies, Map<String, String> data, Map<String, String> headers) throws Exception {
        Connection connection = Jsoup.connect(url);
        if (null != cookies && !cookies.isEmpty()) {
            connection.cookies(cookies);
        }
        if (null != data && !data.isEmpty()) {
            connection.data(data);
        }
        if (null != headers && !headers.isEmpty()) {
            connection.headers(headers);
        }

        connection.userAgent(randomUA())
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .method(Connection.Method.POST);
        int count = 0;
        while (true) {
            try {
                String result = connection
                    .execute()
                    .body();
                return result;
            } catch (IOException e) {
                count++;
                log.error("Jsoup-ajax数据抓取错误：" +
                        "\n\t 次数: " + count +
                        "\n\t Url: " + url +
                        "\n\t Data: " + data +
                        "\n\t Error: " + e.getMessage()
                );
                if (count >= MAX_ERROR_CNT) {
                    throw e;
                }
            }
        }
    }


    private static String randomUA() {
        return UA[random(UA.length)];
    }

    private static int random(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }

}
