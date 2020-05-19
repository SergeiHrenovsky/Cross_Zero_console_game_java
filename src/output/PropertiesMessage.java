package output;

import java.util.Properties;
import java.io.*;

public class PropertiesMessage {
    private static InputStream fis;
    private static Properties property = new Properties();
    private static String pathProperties = "resources/config.properties";

    public static String getMessage(String keyProperty) {
        loadProperties();
        try {
            return  new String(property.getProperty(keyProperty).getBytes("ISO8859-1"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error";
        }
    }

    private static void loadProperties() {
        try {
            fis = PropertiesMessage.class.getClassLoader().getResourceAsStream(pathProperties);
            property.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}