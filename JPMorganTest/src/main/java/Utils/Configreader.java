package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Configreader {
	
	String browser;
	String url;
	Properties p;
	public void readProp(){
			try {
			p=new Properties();
			FileInputStream propfile=new FileInputStream("./src/test/resources/config.properties");
			p.load(propfile);
			}catch(Exception e) {
				
			}
	}
	
	
		public String getprop(String prop) {
			return p.getProperty(prop);	 
		}
}
