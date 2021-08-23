package MobileBankingBaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class CommonApps {

	/**
	 * @param element This is generic method and used to wait till element is enabled.
	 */
	public static void waitForElementToBeEnabled(String element)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(),60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
	}

	/**
	 * 
	 * @param textAttributeValue This method is used to select element from the list on the basis of 'Text' attribute value.
	 */
	public static void selectElementFromList(String text)
	{
		Driver.getInstance().findElement(By.xpath("//*[@text='"+text+"']")).click();
	}
	
	public static void hideKeyboard()
	{
		Driver.getInstance().hideKeyboard();
	}
	
	
	/**
	 * 
	 * @throws Exception Swipe list till element is visible.
	 */
	public static void gestSwipeVerticalTillElementVisible(String text) {
		int counter=0;

		while(Driver.getInstance().findElements(By.xpath("//*[@text='"+text+"']")).size()==0){
			if(counter<3)
			{
				Dimension size = Driver.getInstance().manage().window().getSize();
				int startx= size.width/2;
				int endx=size.width/2;
				int starty=(int) (size.height*.20);
				int endy=(int) (size.height*.15);
				new TouchAction<>(Driver.getInstance()).press(PointOption.point(startx,starty))
				.moveTo(PointOption.point(endx,endy)).release().perform();
				counter++;
			}
		}

	}
	
}
