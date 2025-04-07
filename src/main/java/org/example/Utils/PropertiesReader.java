package org.example.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

   public static String ReadKey(String key)
   {
       try
       {
           FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
           Properties p = new Properties();
           p.load(fileInputStream);
           return p.getProperty(key);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
