package learning.utils;

import java.util.Objects;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertiesManager 
{
	private static Properties properties;
	public static String getProperty(String name) throws FileNotFoundException, IOException 
	{
		// Replace Objects.isNull(properties) with properties == null
        if (Objects.isNull(properties))
        {
            properties = new Properties();
            properties.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\learning\\resources\\config.properties"));
        }
        return properties.getProperty(name);   
	}  
 
}
