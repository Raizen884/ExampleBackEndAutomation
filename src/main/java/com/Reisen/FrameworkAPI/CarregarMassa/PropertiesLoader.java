package com.Reisen.FrameworkAPI.CarregarMassa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Gerencia a leitura do arquivo properties
 * @author Vivian A. Rodrigues
 *
 */

public class PropertiesLoader {
	
	private final String APPLICATION_PROPERTIES = "\\application.properties";
    private Properties properties;

    public PropertiesLoader(String path) throws IOException{
    	try {
    		FileInputStream inp = new FileInputStream(new File(System.getProperty("user.dir") + "\\resources" + path)); 
    		properties = new Properties();
            properties.load(inp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
    
    public String getValue(String key) {
    	try {
            return properties.getProperty(key);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

	public String getApplicationProperties() {
		return APPLICATION_PROPERTIES;
	}

	public Properties getProperties() {
		return properties;
	}

    
}
