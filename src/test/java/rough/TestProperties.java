package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public static Properties config = new Properties();
	public Properties OR = new Properties();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream("user.dir"+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		//FileInputStream fis = new FileInputStream("user+dir"+"\\src\\test\\resources\\properties\\OR.properties");
		//OR.load(fis);
	}

}
