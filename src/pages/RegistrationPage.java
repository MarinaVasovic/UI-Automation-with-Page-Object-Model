package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

	@FindBy(css = "input#ContentPlaceHolder1_txtUserName")
	private WebElement usernameInputFiledLocator;

	@FindBy(xpath = "//button[@id='btnCookie']")
	private WebElement cookieButton;

	@FindBy(id = "ContentPlaceHolder1_txtEmail")
	private WebElement emailAddressInputFiledLocator;

	@FindBy(id = "ContentPlaceHolder1_txtPassword")
	private WebElement passwordInputFiledLocator;

	@FindBy(id = "input#ContentPlaceHolder1_txtPassword2")
	private WebElement confirmPasswordInputFiledLocator;

	@FindBy(xpath = "#ContentPlaceHolder1_btnRegister")
	private WebElement createAccountButton;

	@FindBy(css = "ContentPlaceHolder1_txtUserName-error")
	private WebElement usernameInvalidMesageLocator;

	@FindBy(css = "ContentPlaceHolder1_txtEmail-error")
	private WebElement emailInvalidMesageLocator;

	@FindBy(css = "ContentPlaceHolder1_txtPassword-error")
	private WebElement passowordInvalidMesageLocator;

	@FindBy(css = "ContentPlaceHolder1_txtPassword2-error")
	private WebElement ConfirmPassowordInvalidMesageLocator;

	@FindBy(css = "//*[@class='invalid-feedback' and contains(text(),'Please accept')]")
	private WebElement agreeToTheTermsAndConditiondInvalidMesageLocator;

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void typeUserName(String username) {

		usernameInputFiledLocator.clear();
		usernameInputFiledLocator.sendKeys(username);
	}

	public void typeImailAddress(String emailAddress) {
		emailAddressInputFiledLocator.clear();
		emailAddressInputFiledLocator.sendKeys(emailAddress);

	}

	public void typePassword(String password) {
		passwordInputFiledLocator.clear();
		passwordInputFiledLocator.sendKeys(password);
	}

	public void typeConfirmPassword(String confirmPassword) {
		confirmPasswordInputFiledLocator.clear();
		confirmPasswordInputFiledLocator.sendKeys(confirmPassword);

	}

	public static void clickOnAgreeCheckbox(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementById('ContentPlaceHolder1_MyCheckBox').click();");

	}

	public void clickOnCreateAccounButton() {
		createAccountButton.click();

	}

	public void clicOnCookieButton() {
		cookieButton.click();

	}

	public String getUsernameErrorMessage() {
		return usernameInvalidMesageLocator.getText();

	}

	public String getEmailErrorMessage() {

		return emailInvalidMesageLocator.getText();
	}

	public String getPasswordErrorMessage() {
		return passowordInvalidMesageLocator.getText();

	}

	public String getConfirmPasswordErrorMessage() {

		return ConfirmPassowordInvalidMesageLocator.getText();
	}

	public String getTermsAndConditionsErrorMessage() {
		return agreeToTheTermsAndConditiondInvalidMesageLocator.getText();
	}

	public String getUserName() {
		return usernameInputFiledLocator.getAttribute("value");
	}

}
