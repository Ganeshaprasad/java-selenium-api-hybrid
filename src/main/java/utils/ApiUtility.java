package utils;

import com.google.gson.Gson;

import java.util.Random;

public class ApiUtility {
    private static Gson gson;

    public static String convertJavaToJson(Object pojo)
    {
         gson =new Gson();
        return gson.toJson(pojo);
    }


}
