package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    Properties properties;

    public ConfigUtils(String FilePath) {

        try {
            FileInputStream Locator = new FileInputStream(FilePath);
            properties = new Properties();
            properties.load(Locator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData(String key){
        String data = properties.getProperty(key);
        return data;
    }

}
