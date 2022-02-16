package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.listeners.ListenerEx;
import com.pages.LoginPage;
import com.pages.RegistrationPage;

//@Listeners(ListenerEx.class)
public class RegistrationPageTest extends BaseClass{
// in this page driver comes from baseClass so no need to initialize.
	LoginPage lp = null;
	RegistrationPage rp = null;
	
	@BeforeClass
	public void setup(){
		initialization();            // calling from baseClass
		//reportInit();                // calling from baseClass
		lp = new LoginPage(driver);  // this driver comes from base class and goes to login page
		rp = lp.registerLink();
	}

	@AfterClass
	public void teardown(){
		//report.flush();   // to save all the data into the report
        driver.close();
       // driver.quit();
	}
	@Test
	public void verifyAlreadyMembershipLink(){
		 rp.clickalreadyMembership();
		 Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test
	public void verifyTextRegNewMembership(){
		Assert.assertEquals(rp.regNewMembershipText(), "Register a new membership");;
	    //driver.navigate().back();
	}
	
	@Test
	public void verifyRegistrationPageForm(){
        String act = rp.registrationPageForm("shrikant", "123456789", "Shrikant@gmail.com", "123456");
		driver.switchTo().alert().accept();
		Assert.assertEquals(act, "User registered successfully.");
	}

	@Test
	public void verifyBlankDataOnRegistrationForm(){
		rp = lp.registerLink();
        rp.registrationPageFormBlank("", "", "", "");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(rp.nameErrorMsg(), "Please enter Name.");
		sa.assertEquals(rp.mobileErrorMsg(), "Please enter Mobile.");
		sa.assertEquals(rp.emailErrorMsg(), "Please enter Email.");
		sa.assertEquals(rp.passwordErrorMsg(), "Please enter Password.");
        sa.assertAll();
	}
}
