package test.MobileAppBaseClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {
	
	static AppiumDriver<MobileElement> driver;
	
	public static DesiredCapabilities getCapability()
	{
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "Sony");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability("appPackage", "com.shaadi.android");
		capability.setCapability("appActivity", "com.shaadi.android.ui.login.NewLoginActivity");
		return capability;
	}

	public static AppiumDriver<MobileElement> initializeDriver()
	{
		try{
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), getCapability());
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}catch(Exception e){
			e.printStackTrace();
		}
		return driver;
	}
	
	public static AppiumDriver<MobileElement> getInstance()
	{
		try{
			if(driver==null){
				initializeDriver();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return driver;
	}

}
