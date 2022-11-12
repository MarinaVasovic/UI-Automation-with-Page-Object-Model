package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage {

	public static final String CONFIRMATIONMESSAGE_CSS = ".alert-info";

	public static String getConfirmationMessage(WebDriver driver) {
		WebElement getConfirmationMessage = (WebElement) driver.findElements(By.cssSelector(CONFIRMATIONMESSAGE_CSS));
		return getConfirmationMessage.getText();
	}

}
