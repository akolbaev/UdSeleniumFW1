package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import udTest.TestNG_Demo2;

public class PropertiesFile {
  static Properties prop = new Properties();
  static String projectPath = System.getProperty("user.dir");

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    getProperties();
    setProperties();
  }

  public static void getProperties() {

    try {

      InputStream input =
          new FileInputStream(projectPath + "/src/test/java/config/config.properties");
      prop.load(input);
      String browser = prop.getProperty("browser");
      System.out.println(browser);
      TestNG_Demo2.browserName = prop.getProperty("browser");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCause());
      e.printStackTrace();
    }
  }

  public static void setProperties() {
    try {
      OutputStream output =
          new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
      prop.setProperty("browser", "chrome");
      prop.store(output, null);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCause());
      e.printStackTrace();
    }
  }
}
