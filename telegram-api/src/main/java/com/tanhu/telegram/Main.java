package com.tanhu.telegram;

import com.tanhu.telegram.handler.MyProjectHandler;
import okhttp3.*;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;


/**
 * @author jiazhiyuan
 * @date 2022/6/3 9:14 上午
 */
// Example taken from https://github.com/rubenlagus/TelegramBotsExample
public class Main {

    public static final Boolean debug = true;
    public static final String pathToLogs = "./";
    public static final String linkDB = "jdbc:mysql://[IP_OF_YOU_MYSQL_SERVER]:3306/[DATABASE]?useUnicode=true&characterEncoding=UTF-8";
    public static final String controllerDB = "com.mysql.jdbc.Driver";
    public static final String userDB = "[YOUR_DB_USERNAME]";
    public static final String password = "[YOUR_SECRET_DB_PASSWORD]";

    public static final String TOKENMYPROJECT = "[YOUR_TOP_SECRET_TOKEN]";
    public static final String USERNAMEMYPROJECT = "myProjectBot";


    public static void main(String[] args) throws IOException {

            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            try {
                telegramBotsApi.registerBot(new MyProjectHandler());
            } catch (TelegramApiException e) {
               e.printStackTrace();
            }//end catch()
    }
}

    
