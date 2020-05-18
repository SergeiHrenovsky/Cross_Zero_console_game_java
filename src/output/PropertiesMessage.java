package output;

import java.util.Properties;
import java.io.*;

public class PropertiesMessage {
    private static FileInputStream fis;
    private static Properties property = new Properties();
    private static String pathProperties = "src/resources/config.properties";

    public static String getMessage(String keyProperty) {
        loadProperties();
        try {
            return  new String(property.getProperty(keyProperty).getBytes("ISO8859-1"));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return "Error";
        }
    }

    private static void loadProperties() {
        try {
            fis = new FileInputStream(pathProperties);
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}