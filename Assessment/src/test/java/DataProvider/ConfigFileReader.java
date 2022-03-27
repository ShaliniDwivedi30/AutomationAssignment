package DataProvider;

import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    public static Properties properties;
    //private String propertyFilePath= "C:\\Users\\Shalini\\IdeaProjects\\Assessment\\ConfigFiles\\Configuration.properties";
    private String propertyFilePath = System.getProperty("user.dir")+"\\ConfigFiles\\Configuration.properties";
    public String keyvalue;
    WebDriver driver;
    public ConfigFileReader() {

        FileInputStream reader;
        try {
            reader = new FileInputStream(new File(propertyFilePath));
            properties = new Properties();
            properties.load(reader);

        }
            catch (IOException e) {
                e.printStackTrace();
            }
        }


    public String ConfigReaderfile(String key) throws IOException {

        keyvalue=properties.getProperty(key);
        return keyvalue;
    }



    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }


}
