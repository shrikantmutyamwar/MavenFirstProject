package com.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pages.Dashboardpage;
import com.pages.DownloadsPage;
import com.pages.LoginPage;
import com.pages.OperatorPage;
import com.pages.UsefulLinksPage;
import com.pages.UsersPage;

public class DashboardPageTest extends BaseClass {
	LoginPage lp = null;
	Dashboardpage dp = null;
	UsersPage up = null;
	OperatorPage op = null;
	UsefulLinksPage ulp = null;
	DownloadsPage dlp = null;
	
	@BeforeClass
	public void setup(){
		initialization();
		reportInit();
		lp = new LoginPage(driver);
		dp = lp.validLogin();
	}
	@AfterClass
	public void teardown(){
		report.flush();   // to save all the data into the report
        driver.close();
        driver.quit();
	}

@Test
public void verifyDpHeader() {
	boolean b = dp.verifyHeader();
	System.out.println(b);
	Assert.assertTrue(b);

}


@Test
public void verifyDPHeaderText() {

	String act = dp.verifyHeaderText();
	String exp = "Dashboard Courses Offered";
	System.out.println(act);
	Assert.assertEquals(act, exp);

}

@Test
public void verify_HeaderJavaByKiran() {
	Assert.assertEquals(dp.verify_Header_javaByKiran(), "Java By Kiran");
}

@Test
public void verify_UserImage() {
	boolean b = dp.verify_UserImage();
	Assert.assertTrue(b);
}

@Test
public void verifySidebar_Menu() {
	List<WebElement> menu = dp.checkSideBar_Menu();
	for (WebElement Menu : menu) {

		SoftAssert sa = new SoftAssert();
		
		if (Menu.getText().contains("Logout")) {
				String act = Menu.getText();
				String exp = "Logout";
				System.out.println(act);
				sa.assertEquals(act, exp);
			}
		else if(Menu.getText().contains("MAIN NAVIGATION")) {
			String act = Menu.getText();
			String exp = "MAIN NAVIGATION";
			System.out.println(act);
			sa.assertEquals(act, exp);
		}
		else if (Menu.getText().contains("Dashboard")) {
			String exp = "Dashboard";
			String act = Menu.getText();
			System.out.println(act);
			sa.assertEquals(act, exp);
		}
		else if (Menu.getText().contains("Users")) {
			String act = Menu.getText();
			String exp = "Users";
			System.out.println(act);
			sa.assertEquals(act, exp);
		}
		else if (Menu.getText().contains("Operators")) {
			String act = Menu.getText();
			String exp = "Operators";
			System.out.println(act);
			sa.assertEquals(act, exp);
		}
		else if (Menu.getText().contains("Useful Links")) {
			String act = Menu.getText();
			String exp = "Useful Links";
			System.out.println(act);
			sa.assertEquals(act, exp);
		}
		else if (Menu.getText().contains("Downloads")) {
			String act = Menu.getText();
			String exp = "Downloads";
			System.out.println(act);
			sa.assertEquals(act, exp);
		}
		
		sa.assertAll();
	}

}

@Test
public void verify_DashboardLink_Clickable() {
	dp.clickDashboard();
	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
}

@Test
public void verify_SeleniumHeading_Text() {

	Assert.assertEquals(dp.verifHeadingSelenium(), "Selenium");

}

@Test
public void verify_SmallText_AutomationTesting() {
	
    Assert.assertEquals(dp.checkSmallText_AutomationTesting(), "Automation Testing");
}

@Test
public void verify_MoreinfoLink_OfSelenium_Clickable() {
	String chldwindow = dp.clickSelenium_Moreinfo();
	String act = driver.switchTo().window(chldwindow).getCurrentUrl();
	driver.switchTo().window(chldwindow).close();
	String exp = "file:///D:/Jbk%20soft/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf";
	String parentwnd = driver.getWindowHandles().toArray()[0].toString(); // as driver is in the child window
	driver.switchTo().window(parentwnd);                                  // we have to move driver to parent window
	
	Assert.assertEquals(act, exp);
    }

@Test
public void verify_HeadingJavaJ2EE() {
	String act = dp.checkHeadingJavaJ2EE();
	Assert.assertEquals(act, "Java / J2EE");
}

@Test
public void verify_samllText_SoftwareDevelopment() {
	
    Assert.assertEquals(dp.check_SoftwareDevelopment_Text(), "Software Development");
}

@Test
public void verify_UsersLinkClickable(){
	up = dp.checkUsersLink();
	Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	//driver.navigate().back();
}

 @Test
   public void verifyOperatorLink(){
	  op = dp.checkOperatorLink_Clickable();
	  Assert.assertEquals(driver.getTitle(), "JavaByKiran | Operators");
	 // driver.navigate().back();

   }
 
 @Test
 public void verifyUsefulLinksClickable(){
	 ulp = dp.checkUsefulLinks_Clickable();
	 Assert.assertEquals(driver.getTitle(), "JavaByKiran | Useful Links");
	 // driver.navigate().back();

 }
 
 @Test 
 public void verifyDownloadsClickable(){
   dlp =  dp.checkDownloads_clickable();
	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Downloads");
	 // driver.navigate().back();
	
 }
	
}
