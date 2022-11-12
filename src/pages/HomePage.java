package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[@href='/login']")
	private WebElement signInLocator;

	@FindBy(xpath = "//a[@href='/register']")
	private WebElement signUpLocator;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public static void goToHomePage(WebDriver driver) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.navigate().refresh();
	}

	public void clicOnSingIn() {
		signInLocator.click();
	}

	public RegistrationPage clicOnSingUp() {
		signUpLocator.click();
		return new RegistrationPage(driver);
	}
}