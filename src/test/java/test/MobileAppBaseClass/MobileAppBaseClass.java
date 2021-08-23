package test.MobileAppBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeSuite;


public class MobileAppBaseClass {

	static Properties pro;

	@BeforeSuite
	public void Setup() throws FileNotFoundException, IOException
	{
		pro = new Properties();
		pro.load(new FileInputStream("src\\test\\resources\\mobileWidgetid.properties"));
		Driver.initializeDriver();
	}


	public static String getElement(String element)
	{
		return pro.getProperty(element);
	}
	
}
