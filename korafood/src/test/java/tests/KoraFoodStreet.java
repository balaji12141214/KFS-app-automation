package tests;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.korafood.dependencies.LaunchKoraFoodApp;
import com.korafood.dependencies.WaitTime;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pages.KoraFoodStreetHomePageElements;

public class KoraFoodStreet extends LaunchKoraFoodApp {

	// intializing driver object
	AndroidDriver<WebElement> driver;

	// creating logger object for write loggers
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(KoraFoodStreet.class);

	// creating elements object to access page elements [page object model]
	KoraFoodStreetHomePageElements elements = new KoraFoodStreetHomePageElements();

	// creating wait time object
	WaitTime wait = new WaitTime();

	@BeforeTest
	public void instantiateApp() throws MalformedURLException, InterruptedException {

		logger.info("launching kora food street mobile app");
		driver = launchKoraFoodStreetMobileApp();

		logger.info("verify app launched successfully");
		wait.Simply(3);
	}

	@Test
	public void koraFoodStreetAppHomePage() {
		try {
		logger.info("capturing 'Email Id' text || app launched status also conformed ");
		String emailFieldText = driver.findElement(elements.emailFieldId).getText();

		logger.info("capturing 'password' text ");
		String passwordFieldText = driver.findElement(elements.passwordFieldId).getText();

		logger.info("capturing forgot password? text");
		String forgotPasswordText = driver.findElement(elements.forgotPasswordId).getText();

		logger.info("capturing signin button text");
		String signInButtonText = driver.findElement(elements.signInButtonId).getText();

		logger.info("capturing hompage souce");
		String homePageSource = driver.getPageSource();

		logger.info("sign up button text");
		String signUpButtonText = driver.findElement(elements.signUpButtonId).getText();

		logger.info("asserting emailid text with home page");
		Assert.assertEquals(emailFieldText, elements.emailId);

		logger.info("asserting password text with home page");
		Assert.assertEquals(passwordFieldText, elements.password);

		logger.info("asserting eye icon is available or not");
		Assert.assertTrue(homePageSource.contains((CharSequence) elements.eyeIcon));

		logger.info("asserting forgot password? text with home page");
		Assert.assertEquals(forgotPasswordText, elements.forgotPassword);

		logger.info("asserting signin button text with home page");
		Assert.assertEquals(signInButtonText, elements.signInButtonText);

		logger.info("asserting noAccountText text with home page");
		Assert.assertTrue(homePageSource.contains(elements.noAccountText));

		logger.info("asserting signup button text with home page");
		Assert.assertEquals(signUpButtonText, elements.signUpText);

		logger.info("asserting guest user? text with home page");
		Assert.assertTrue(homePageSource.contains(elements.guestUserText));
		}

		catch(Exception message)
		{
			message.printStackTrace();
			Assert.fail();
		}
	}

	@AfterSuite
	public void closeApp() {

		logger.info("closing launched application");
		((AppiumDriver<WebElement>) driver).closeApp();

	}
}
