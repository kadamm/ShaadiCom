package test.MobileApp.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.MobileApp.form.FrmHomeScreen;
import test.MobileApp.form.FrmLoginScreen;
import test.MobileAppBaseClass.MobileAppBaseClass;

public class HomeConnectProfile extends MobileAppBaseClass {

	FrmLoginScreen login = new FrmLoginScreen();
	FrmHomeScreen home = new FrmHomeScreen();
	
	@BeforeMethod
	public void setHomeScreen() throws InterruptedException {
		if (!home.isHomeScreen()) {
			if (login.isLoginScreen()) {
				login.doLogin();
				home.clickHomeButton();
			}
		}
	}
	
	
	@Test
	public void connectPremiumAndNewMatchesProfile() throws InterruptedException
	{
		
		//click on connect now on the premium profile 
		home.clickConnectForPremiumFrofile();
		
		//click on the New Matches profile
		home.clickConnectForNewMatchesFrofile();
	}
	
}
