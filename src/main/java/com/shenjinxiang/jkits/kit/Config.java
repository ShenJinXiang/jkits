package com.shenjinxiang.jkits.kit;

import com.shenjinxiang.jkits.core.Consts;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Config {

    public static final String NAME;
    public static final int THREADSIZE;

    public static final String REDIS_HOST;
    public static final int REDIS_PORT;
    public static final String REDIS_AUTH;
    public static final int REDIS_MINIDLE;
    public static final int REDIS_MAXIDLE;
    public static final int REDIS_MAXTOTAL;

    private static Properties properties;

    static {
        loadProperties();

        NAME = get("name");
        THREADSIZE = getInt("threadSize");

        REDIS_HOST = get("redis.host");
        REDIS_PORT = getInt("redis.port");
        REDIS_AUTH = get("redis.auth");
        REDIS_MINIDLE = getInt("redis.minIdle");
        REDIS_MAXIDLE = getInt("redis.maxIdle");
        REDIS_MAXTOTAL = getInt("redis.maxTotal");
    }

    private static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    private static String get(String key) {
        return properties.getProperty(key);
    }

    private static void loadProperties() {
        InputStream inputStream = null;
        try {
            inputStream = Config.class.getClassLoader().getResourceAsStream("config.properties");
            InputStreamReader reader = new InputStreamReader(inputStream, Consts.ENCODE);
            properties = new Properties();
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
