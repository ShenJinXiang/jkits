package com.shenjinxiang.jkits.kit;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongodbManager {

    private static MongoClient client = null;

    static {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();//选项构建者  
        builder.connectTimeout(Config.MONGODB_CONNECTTIMEOUT)
                .socketTimeout(Config.MONGODB_SOCKETTIMEOUT)
                .connectionsPerHost(Config.MONGODB_CONNECTIONSPERHOST);
        MongoClientOptions options = builder.build();

        ServerAddress serverAddress = new ServerAddress(Config.MONGODB_HOST, Config.MONGODB_PORT);
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(Config.MONGODB_USER, Config.MONGODB_DB, Config.MONGODB_AUTH.toCharArray());

        client = new MongoClient(serverAddress, mongoCredential, options);
    }

    public static MongoDatabase getDatabase() {
        return client.getDatabase(Config.MONGODB_DB);
    }

}
