package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.AddUserPage;
import com.pages.Dashboardpage;
import com.pages.LoginPage;
import com.pages.UsersPage;

public class AddUserTest extends BaseClass {

	LoginPage lp = null;
	Dashboardpage dp = null;
	UsersPage up = null;
	AddUserPage aup = null;

	@BeforeClass
	public void setup() {
		initialization();
		reportInit();
		lp = new LoginPage(driver);
		dp = lp.validLogin();
		up = dp.checkUsersLink();
		aup = up.checkaddUserBtn();
	}

//	@AfterSuite
//	public void teardown() {
//		report.flush();
//		driver.close();
//	}

	@Test
	public void verifyTextAddUser() {
		// up.checkaddUserBtn();
		String act = aup.checkHeaderAddUser();
		Assert.assertEquals(act, "Addd User");
	}

	@Test
	public void verifyText_Fill_Below_Details() {
		Assert.assertEquals(aup.checkTextFill_Details(), "Fill Below Details");
	}

	@Test
	public void verifyAddUser_Form() {
		String act = aup.addUserForm("shri", "123456789", "shri@gmail", "selenium", "323232", "963852741");
		driver.switchTo().alert().accept();
		Assert.assertEquals(act, "User Added Successfully. You can not see added user.");

	}

	@Test
	public void verifyCancelButtonOf_AddUserForm() {
		aup.addUserFormCancelButton("shri", "123456789", "shri@gmail", "sel", "121212", "123456789");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
		driver.navigate().back();
	}

	@Test
	public void verifyLinkJBK() {
		String act = aup.checkJBKLink();
		driver.navigate().back();
		Assert.assertEquals(act, "http://jbk.com/");
	}

	
	@AfterSuite
	public void closeSetup() {
		// driver.close();
		driver.quit();
	}

}
