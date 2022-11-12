package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ConfirmationPage;
import pages.HomePage;
import pages.RegistrationPage;
import utils.Helper;

public class RegistrtionPageTests {
	private static WebDriver driver = null;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public static void succesfulRegUsernameMinimumCharacters() {

		String username = "Milos";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage.goToHomePage(driver);

		HomePage homePage = new HomePage(driver);

		homePage.clicOnSingIn();
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();

		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = ConfirmationPage.getConfirmationMessage(driver);
		String expected = "Your account registration has been submitted and is pending email verification ";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegTooShortUsername() {

		String username = "Milo";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		homePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getUsernameErrorMessage();
		String expected = "Username is invalid.";
		assertEquals(actual, expected);
	}

	@Test
	public static void successfulRegUsernameMaximumCharacters() {

		String username = "Milosasdfghjklaszxcvbnmkjhgfds";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";
		HomePage homePage = new HomePage(driver);
		homePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = ConfirmationPage.getConfirmationMessage(driver);
		String expected = "Your account registration has been submitted and is pending email verification ";
		assertEquals(actual, expected);
	}

	@Test
	public static void tooLongUsername() {
		String username = "Milosasdfghjklaszxcvbnmkjhgfdse";

		HomePage homePage = new HomePage(driver);
		homePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();

		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.typeUserName(username);
		String username1 = registrationPage.getUserName();
		int actual = username1.length();

		assertEquals(actual, 30);

	}

	@Test
	public static void unsuccessfulRegUsurnameWithSpecialCharacters() {

		String username = "Mi.,s";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getUsernameErrorMessage();
		String expected = "Username is invalid.";
		assertEquals(actual, expected);
	}

	@Test
	public static void successfulRegUsernameWithNumbers() {

		String username = "12345";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = ConfirmationPage.getConfirmationMessage(driver);
		String expected = "Your account registration has been submitted and is pending email verification ";
		assertEquals(actual, expected);
	}

//
	@Test
	public static void successfulRegUsernameWithNumbersAndLetters() {

		String username = "123ffs45";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = ConfirmationPage.getConfirmationMessage(driver);
		String expected = "Your account registration has been submitted and is pending email verification ";
		assertEquals(actual, expected);
	}

	@Test
	public static void successfulRegUsernameWithLowerCase() {

		String username = "milos";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = ConfirmationPage.getConfirmationMessage(driver);
		String expected = "Your account registration has been submitted and is pending email verification ";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegEmptyUsurname() {

		String username = "";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);

		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getUsernameErrorMessage();
		String expected = "Username is invalid.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegEmptyPasswordAndConfirmPassword() {

		String username = "milos";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "";
		String confirmPassword = "";

		HomePage homePage = new HomePage(driver);

		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();

		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual1 = registrationPage.getPasswordErrorMessage();
		String expected1 = "Your password must be at least 5 characters long.";
		assertEquals(actual1, expected1);
		String actual2 = registrationPage.getConfirmPasswordErrorMessage();
		String expected2 = "Your password must be at least 5 characters long.";
		assertEquals(actual2, expected2);
	}

	@Test
	public static void unsuccessfulRegTooShortPassword() {

		String username = "milos";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "mari";
		String confirmPassword = "mari";
		HomePage homePage = new HomePage(driver);

		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual1 = registrationPage.getPasswordErrorMessage();
		String expected1 = "Your password must be at least 5 characters long.";
		assertEquals(actual1, expected1);
		String actual2 = registrationPage.getConfirmPasswordErrorMessage();
		String expected2 = "Your password must be at least 5 characters long.";
		assertEquals(actual2, expected2);

	}

	@Test
	public static void unsuccessfulRegWrongConfirmPasswordMoreThan5Char() {

		String username = "milos";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marinaaa";
		String confirmPassword = "marinaa";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getConfirmPasswordErrorMessage();
		String expected = "Password does not match, please check again.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegWrongConfirmPasswordLessThan5Char() {

		String username = "milos";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marinaaa";
		String confirmPassword = "mar";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getConfirmPasswordErrorMessage();
		String expected = "Your password must be at least 5 characters long.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegEmptyConfirmPassword() {

		String username = "milos";
		String imailAddress = "marina.vasovic" + Helper.getCurrentTime() + "@TCail.com";
		String password = "marina";
		String confirmPassword = "";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getConfirmPasswordErrorMessage();
		String expected = "Your password must be at least 5 characters long.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegInvalidEmailAddress() {

		String username = "milos";
		String imailAddress = "marina.vasovicTCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getEmailErrorMessage();
		String expected = "Please enter a valid email address.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegInvalidEmailAddressMissingDot() {

		String username = "milos";
		String imailAddress = "marina.vasovicTCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getEmailErrorMessage();
		String expected = "Please enter a valid email address.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegCheckboxIsNotCheked() {

		String username = "milos";
		String imailAddress = "marina.vasovicTCail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getTermsAndConditionsErrorMessage();
		String expected = "Please accept our Terms and Conditions.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegInvalidEmailAddressWithSpecialCharacters() {

		String username = "milos";
		String imailAddress = "mari#nav*aso.vic@TCailcom";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getEmailErrorMessage();
		String expected = "Please enter a valid email address.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegInvalidEmailAddressBeginsWithDot() {

		String username = "milos";
		String imailAddress = ".marinavasovic@gmail.com";
		String password = "marina";
		String confirmPassword = "marina";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		RegistrationPage.clickOnAgreeCheckbox(driver);
		registrationPage.clickOnCreateAccounButton();
		String actual = registrationPage.getEmailErrorMessage();
		String expected = "Please enter a valid email address.";
		assertEquals(actual, expected);
	}

	@Test
	public static void unsuccessfulRegAllFieldsAreEmpty() {

		String username = "";
		String imailAddress = "";
		String password = "";
		String confirmPassword = "";

		HomePage homePage = new HomePage(driver);
		HomePage.goToHomePage(driver);
		RegistrationPage registrationPage = homePage.clicOnSingUp();
		homePage.clicOnSingIn();
		registrationPage.clicOnCookieButton();
		homePage.clicOnSingUp();
		registrationPage.clicOnCookieButton();
		registrationPage.typeUserName(username);
		registrationPage.typeImailAddress(imailAddress);
		registrationPage.typePassword(password);
		registrationPage.typeConfirmPassword(confirmPassword);

		registrationPage.clickOnCreateAccounButton();

		String actualUsername = registrationPage.getUsernameErrorMessage();
		String expectedUsername = "Username is invalid.";
		assertEquals(actualUsername, expectedUsername);

		String actualEmail = registrationPage.getEmailErrorMessage();
		String expectedEmail = "Please enter a valid email address.";
		assertEquals(actualEmail, expectedEmail);

		String actualPassword = registrationPage.getPasswordErrorMessage();
		String expectedPassword = "Your password must be at least 5 characters long.";
		assertEquals(actualPassword, expectedPassword);

		String actualConfirmP = registrationPage.getConfirmPasswordErrorMessage();
		String expectedConfirmP = "Your password must be at least 5 characters long.";
		assertEquals(actualConfirmP, expectedConfirmP);

		String actual = registrationPage.getTermsAndConditionsErrorMessage();
		String expected = "Please accept our Terms and Conditions.";
		assertEquals(actual, expected);

	}

}
