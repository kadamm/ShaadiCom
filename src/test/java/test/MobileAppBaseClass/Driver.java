package MobileBankingBaseTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {
	
	static AndroidDriver<MobileElement> driver;
	
	public static DesiredCapabilities getCapability()
	{
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "Sony");
		capability.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/testApplication/Shaadi_5.11.1.apk");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability("appPackage", "com.shaadi.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.shaadi.android.ui.achivement_splash.SplashActivity");
		return capability;
	}

	public static AndroidDriver<MobileElement> initializeDriver()
	{
		try{
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), getCapability());
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}catch(Exception e){
			e.printStackTrace();
		}
		return driver;
	}
	
	public static AndroidDriver<MobileElement> getInstance()
	{
		try{
			if(driver==null){
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), getCapability());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return driver;
	}

}
