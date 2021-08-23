package test.MobileBanking.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MobileBankingBaseTest.CommonApps;
import MobileBankingBaseTest.Constant;
import MobileBankingBaseTest.MobileBankingBaseClass;
import test.MobileBanking.form.Registration;
import test.MobileBanking.form.FlashScreen;

public class RegistrationTest extends MobileBankingBaseClass {

	FlashScreen flash = new FlashScreen();
	Registration registration = new Registration();
	
	
	@Test
	public void registrationWithEmptyDateOfBirthAndVerifyError() throws InterruptedException
	{
		SoftAssert art =new SoftAssert();
		int testCaseRow = MobileBankingBaseClass.getTestCaseRowFromTitle("registrationWithEmptyDateOfBirthAndVerifyError");
		flash.clickUserRegistrationbtn();
		registration.enterEmail(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Email));
		registration.enterPassword(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Password));
		registration.selectProfile(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.ProfileFor));
		registration.enterFirstName(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.FirstName));
		registration.enterLastName(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.LastName));
		registration.selectGender(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Gender));
		registration.selectReligion(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Religion));
		registration.selectMotherTongue(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.MT));
		registration.selectCountry(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Country));
		registration.clickOnSubmitbtn();
		CommonApps.hideKeyboard();
		art.assertTrue(registration.getErrorMessage());
	}
	
	
	@Test(enabled=false)
	public void registrationWithAllValidData1() throws InterruptedException
	{
		
		int testCaseRow = MobileBankingBaseClass.getTestCaseRowFromTitle("registrationWithAllValidData1");

		registration.enterEmail(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Email));
		registration.enterPassword(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Password));
		registration.selectProfile(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.ProfileFor));
		registration.enterFirstName(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.FirstName));
		registration.enterLastName(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.LastName));
		registration.selectGender(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Gender));
		registration.selectDay(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Day));
		registration.selectMonth(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Month));
		registration.selectYear(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Year));
		registration.selectReligion(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Religion));
		registration.selectMotherTongue(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.MT));
		registration.selectCountry(MobileBankingBaseClass.getRowValue(testCaseRow, Constant.Country));
	}
	
}
