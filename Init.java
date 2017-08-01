

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Admin on 28.07.17.
 */
public class Init {
    public static Properties properties = new Properties();
    private static final String FILE = "D:\\java\\JavaRushTasks\\4.JavaCollections\\src\\qqq.properties";

    public void init(){
        try{
            //System.out.println(FILE);
            properties.load(new FileInputStream(FILE));
            PropertyConfigurator.configure(properties);
        }
        catch (Exception f){
            f.printStackTrace();
        }
    }
}
