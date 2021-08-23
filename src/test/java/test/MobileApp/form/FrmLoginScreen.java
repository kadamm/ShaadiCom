package test.MobileApp.form;

import org.openqa.selenium.By;
import test.MobileAppBaseClass.Driver;
import test.MobileAppBaseClass.MobileAppBaseClass;

public class FrmLoginScreen {
	FrmHomeScreen home = new FrmHomeScreen();
	FrmUpgradePremium premium = new FrmUpgradePremium();

	/**
	 * 
	 * @return True if Login screen is visible else return false.
	 */
	public boolean isLoginScreen() {
		try {
		return Driver.getInstance().findElement(By.xpath(MobileAppBaseClass.getElement("frmLogin_title")))
				.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	/**
	 * @param email This method is used to enter the Email ID on Login. screen.
	 */
	public void enterEmail(String email) {
		Driver.getInstance().findElement(By.id(MobileAppBaseClass.getElement("frmLogin_username_inputfield")))
				.sendKeys(email);
	}

	/**
	 * @param password This method is used to enter Password on Login screen.
	 */
	public void enterPassword(String password) {
		Driver.getInstance().findElement(By.id(MobileAppBaseClass.getElement("frmLogin_password_inputfield")))
				.sendKeys(password);
	}

	/**
	 * This method is used to click login button on login screen.
	 */
	public void clickOnSubmitbtn() {
		Driver.getInstance().findElement(By.id(MobileAppBaseClass.getElement("frmLogin_login_button"))).click();
	}

	public void doLogin() throws InterruptedException {
		//Enter username
		enterEmail("kadammanoj123@gmail.com");
		//Enter password
		enterPassword("john@123");
		//Click on the submit button.
		clickOnSubmitbtn();
		//if device location alert display, accept it.
		home.acceptDeviceLocation();
		//if upgrade to premium screen display, click on back button.
		premium.clickBackIfUpgradeToPremiumScreenDisplay();
		
	}

}
