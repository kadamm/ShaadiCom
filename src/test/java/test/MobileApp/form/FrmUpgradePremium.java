package test.MobileApp.form;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import test.MobileAppBaseClass.Driver;
import test.MobileAppBaseClass.MobileAppBaseClass;

public class FrmUpgradePremium {
	
	/**
	 * 
	 * @return True if Upgrade account screen is visible else return false.
	 */
	public boolean isUpgradeToPremiumScreen() {
		try {
		return Driver.getInstance().findElement(By.xpath(MobileAppBaseClass.getElement("frmPremimuAccount_title")))
				.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickBackButton() {
		MobileElement backbutton = Driver.getInstance().findElement(MobileBy.AccessibilityId(MobileAppBaseClass.getElement("frmPremiumAccount")));
		backbutton.click();
	}
	
	public void clickBackIfUpgradeToPremiumScreenDisplay() {
		if(isUpgradeToPremiumScreen()) {
			clickBackButton();
		}
	}

}
