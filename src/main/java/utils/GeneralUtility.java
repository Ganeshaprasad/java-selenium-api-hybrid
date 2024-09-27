package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;

public class GeneralUtility {



    public String getDateAndTime()
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }

    public static int generateRandomNumber()
    {
        Random rand =new Random();
        return  rand.nextInt(1000);
    }
}
