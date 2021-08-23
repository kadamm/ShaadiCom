package test.MobileApp.form;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import test.MobileAppBaseClass.CommonApps;
import test.MobileAppBaseClass.Driver;
import test.MobileAppBaseClass.MobileAppBaseClass;

public class FrmHomeScreen {

	/**
	 * 
	 * @return True if My Shaadi home screen is visible else return false.
	 */
	public boolean isHomeScreen() {
		try {
			return Driver.getInstance().findElement(By.xpath(MobileAppBaseClass.getElement("frmHomeScreen_title")))
					.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * click on the home button
	 * @throws InterruptedException 
	 */
	public void clickHomeButton() throws InterruptedException {
		MobileElement element = Driver.getInstance()
				.findElement(By.id(MobileAppBaseClass.getElement("frmHomeScreen_menu_button")));
		element.click();
		Thread.sleep(5000);
	}

	/**
	 * Click on connect now profile button.
	 */
	public void clickConnectForPremiumFrofile() {
		CommonApps.swipeTillElementVislble(MobileAppBaseClass.getElement("frmHomeScreen_Connect_button"));
		MobileElement element = Driver.getInstance().findElement(By.xpath(MobileAppBaseClass.getElement("frmHomeScreen_Connect_button")));
		element.click();
	}

	/**
	 * Click on connect now profile button.
	 */
	public void clickConnectForNewMatchesFrofile() {
		CommonApps.swipeTillElementVislble(MobileAppBaseClass.getElement("frmHomeScreen_NewMatches_connect_button"));
		MobileElement element = Driver.getInstance().findElement(By.xpath(MobileAppBaseClass.getElement("frmHomeScreen_Connect_button")));
		element.click();
	}

	/**
	 * 
	 * @return true if location access alert visible else return false.
	 */
	public boolean isLocationAlertVisible() {
		try {
			return Driver.getInstance().findElement(By.id(MobileAppBaseClass.getElement("device_location_alert")))
					.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void acceptDeviceLocation() {
		if(isLocationAlertVisible()) {
		MobileElement allowbutton = Driver.getInstance()
				.findElement(By.id(MobileAppBaseClass.getElement("locatin_alert_allow_button")));
		allowbutton.click();
		}
	}

}
