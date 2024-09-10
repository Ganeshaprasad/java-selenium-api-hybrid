package ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
    public String readDataFromPropertyFile(String fileLocation,String key) throws IOException {
        FileInputStream fis=new FileInputStream(fileLocation);
        Properties pro =new Properties();
        pro.load(fis);
        return pro.getProperty(key);

    }
}
