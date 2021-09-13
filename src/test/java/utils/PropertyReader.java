package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getUrl() {
        return getProperty("url");
    }

    public static String getTextValue() {
        return getProperty("selenium");
    }

    public static String getAttrValue() {
        return getProperty("attributeClass");
    }

    public static Browser getBrowserValue() {
        return Browser.valueOf(getProperty("browser"));
    }

    public static String getToolTipValue() {
        return getProperty("tooltip"); // проблема с кодировкой кириллицы. С проперти файла некорретно выгружается кириллица
    }


    private static String getProperty(String propertyName) {
        // mvn clean test -Durl=https://www.google.ru -Dbrowser=FIREFOX   OR mvn clean test
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    private static String getPropertyFromFile(String propertyName) {

        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/framework.properties")) {

            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }
}

