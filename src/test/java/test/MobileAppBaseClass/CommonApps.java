package test.MobileAppBaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonApps {

	/**
	 * @param element This is generic method and used to wait till element is
	 *                enabled.
	 */
	public static void waitForElementToBeEnabled(String element) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
	}

	/**
	 * 
	 * @throws Exception Swipe list till element is visible.
	 */
	public static void swipeVerticalTillElementWithGivenTextVisible(String text) {
		int counter = 0;

		while (Driver.getInstance().findElements(By.xpath("//*[@text='" + text + "']")).size() == 0) {
			if (counter < 3) {
				swipeUp();
				counter++;
			}
		}

	}
	
	/**
	 * Swipe screen up side till given xpath element is visible.
	 * @throws Exception
	 */
	public static void swipeTillElementVislble(String xpath) {
		int counter = 0;

		while (Driver.getInstance().findElements(By.xpath(xpath)).size() == 0) {
			if (counter < 3) {
				swipeUp();
				counter++;
			}
		}
	
	}
	
	
	private static void swipeUp() {
		Dimension size = Driver.getInstance().manage().window().getSize();
		int anchor = (int) (size.width * 0.2);
		int startPoint = (int) (size.height * 0.7);
		int endPoint = (int) (size.height * 0.5);
		try {
			new TouchAction<>(Driver.getInstance())
			.press(PointOption.point(anchor, startPoint))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
			.moveTo(PointOption.point(anchor, endPoint))
			.release().perform();
		}catch(Exception e){
		}
	}

}
