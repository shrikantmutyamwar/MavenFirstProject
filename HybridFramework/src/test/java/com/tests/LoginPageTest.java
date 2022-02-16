package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.listeners.ListenerEx;
import com.pages.Dashboardpage;
import com.pages.LoginPage;
import com.utility.PropertiesUtility;

//@Listeners(ListenerEx.class)
public class LoginPageTest extends BaseClass {

	LoginPage lp = null;
	Dashboardpage dp = null;

	@BeforeSuite
	public void setup() {
		log.info("inside loginPage before suite");
		reportInit();
		//driver.manage().deleteAllCookies();
	}

	@AfterSuite
	public void teardown() {
		log.info("inside loginPage after suite");
		report.flush(); // to save all the data into the report
	   // driver.close();
	}

	@BeforeClass
	public void setup1() {
		log.info("inside loginPage before class");
		initialization();
		//reportInit();
		lp = new LoginPage(driver);
	}

	@AfterClass
	public void closesetup() {
		log.info("inside loginPage after class");
		//report.flush();
		driver.close();
	}

	@Test
	public void verifyLoginPageTitle() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}

	@Test
	public void test03() {
		throw new SkipException("skipping a test case");

	}

	@Test
	public void verifycompanyName() {
		String act = lp.companyName();
		String exp = "Java By Kiran";
		Assert.assertEquals(act, exp);
	}

	@Test
	public void verifyCompanyTechnologies() {
		String act = lp.companyTechnologies();
		String exp = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(act, exp);
	}

	@Test
	public void verifyLoginBoxMsg() {
		// String act = lp.verifyLoginBoxmsg();
		// String exp = "Sign in to start your session";
		// Assert.assertEquals(act, exp);
		throw new SkipException("skipping a test case verify login box msg");
	}

	@Test
	public void verifyCorrectLoginCredentials() {
		driver.get(PropertiesUtility.readproperty("url"));
		dp = lp.validLogin();
		String act = driver.getTitle();
		String exp = "JavaByKiran | Dashboard";
		Assert.assertEquals(act, exp);
		driver.navigate().back();

	}

	@Test
	public void verifyIncorrectLoginCredentials() {
		// driver.navigate().to(url);
		lp.loginToApplication("shrikant@gmail", "654321");
		String act = lp.emailErrorMsg();
		// System.out.println(act);
		String exp = "Please enter email as kiran@gmail.com";
		String act1 = lp.passwordErrorMsg();
		String exp1 = "Please enter password 123456";
		// System.out.println(act1);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(act, exp);
		sa.assertEquals(act1, exp1);
		sa.assertAll();

	}

	@Test
	public void verifyIncorrectEmail() {
		// driver.navigate().to(url);
		lp.loginToApplication("shrikant@gmail.com", "123456");
		String act = lp.emailErrorMsg();
		String exp = "Please enter email as kiran@gmail.com";
		Assert.assertEquals(act, exp);
	}

	@Test
	public void verifyIncorrectPassword() {
		lp.loginToApplication("kiran@gmail.com", "654321");
		Assert.assertEquals(lp.passwordErrorMsg(), "Please enter password 123456");
	}

	@Test
	public void verifyNoDataLogin() {
		lp.loginToApplication("", "");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(lp.emailErrorMsg(), "Please enter email.");
		sa.assertEquals(lp.passwordErrorMsg(), "Please enter password.");
		sa.assertAll();
	}

	@Test
	public void verifyBlankEmailField() {
		// driver.navigate().to("file:///D:/Jbk%20soft/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		lp.loginToApplication("", "123456");
		Assert.assertEquals(lp.emailErrorMsg(), "Please enter email");
	}

	@Test
	public void verifyBlankPasswordField() {
		lp.loginToApplication("kiran@gmail.com", "");
		Assert.assertEquals(lp.passwordErrorMsg(), "Please enter password.");
	}

	@Test
	public void verifyRegisterNewMembershipLinkClikable() {
		lp.registerLink();
		String act = driver.getTitle();
		String exp = "JavaByKiran | Registration Page";
		// driver.navigate().back();
		Assert.assertEquals(act, exp);
		driver.navigate().back();
	}
}