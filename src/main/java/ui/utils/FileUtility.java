package ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

    public static   String readDataFromPropertyFile(String fileLocation,String key) throws IOException {
        FileInputStream fis=new FileInputStream(fileLocation);
        Properties pro =new Properties();
        pro.load(fis);
        return pro.getProperty(key);

    }

    public static String getBrowser() throws IOException {
       return FileUtility.readDataFromPropertyFile("config.properties","browser");
    }

    public static boolean isHeadLess() throws IOException {
        return FileUtility.readDataFromPropertyFile("config.properties", "isHeadLess").equals("true");
    }
}
