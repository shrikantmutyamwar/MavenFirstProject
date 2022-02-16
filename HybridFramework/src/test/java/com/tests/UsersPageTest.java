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
import com.pages.AddUserPage;
import com.pages.Dashboardpage;
import com.pages.LoginPage;
import com.pages.UsersPage;


public class UsersPageTest extends BaseClass {
	
	LoginPage lp = null;
	Dashboardpage dp = null;
	UsersPage up = null;
	AddUserPage aup = null;

	@BeforeClass
	public void setup(){
		initialization();
		reportInit();
		lp = new LoginPage(driver);
		dp = lp.validLogin();
		up = dp.checkUsersLink();
	}
   @AfterClass
   public void teardown(){
	report.flush();
	driver.close();
}

    @Test
    public void verifyUserHeader(){
    	String act = up.checkHeaderUser();
    	Assert.assertEquals(act, "Users");
    }
    
    @Test
    public void verifyText_UserList(){
    	Assert.assertEquals(up.checkText_userList(), "User List");
    }
    
    @Test
    public void verifyLink_JavaByKiran_Clickable(){
    	String chldndw = up.checkLink_JavaByKiran();
    	String act = driver.switchTo().window(chldndw).getTitle();
    	driver.switchTo().window(chldndw).close();
    	String exp = "Java Classes in Pune | Selenium Training | Python Courses in pune";
    	Assert.assertEquals(act, exp);
    	String parentwnd = driver.getWindowHandles().toArray()[0].toString(); // as driver is in the child window
    	driver.switchTo().window(parentwnd);                                  // we have to move driver to parent window
    }
    
    @Test
    public void verify_UserTableColumn(){
    	List<WebElement>TbCol = up.check_TableCol();
    	for(WebElement TBCol : TbCol){
    		SoftAssert sa = new SoftAssert();
    		if(TBCol.getText().contains("#")){
    			String act = TBCol.getText();
    			String exp = "#";
    			System.out.println(act);
    			sa.assertEquals(act, exp);
    		}
    		else if(TBCol.getText().contains("Username")){
    			String act = TBCol.getText();
    			String exp = "Username";
    			System.out.println(act);
                sa.assertEquals(act, exp);
    	    }
    		else if(TBCol.getText().contains("Email")){
    			String act = TBCol.getText();
    			String exp = "Email";
    			System.out.println(act);
    			sa.assertEquals(act, exp);
    		}
    		else if(TBCol.getText().contains("Mobile")){
    			String act = TBCol.getText();
    			String exp = "Mobile";
    			System.out.println(act);
    			sa.assertEquals(act, exp);
    		}
    		else if(TBCol.getText().contains("Course")){
    			String act = TBCol.getText();
    			String exp = "Course";
    			System.out.println(act);
    			sa.assertEquals(act, exp);
    		}
    		else if(TBCol.getText().contains("Gender")){
    			String act = TBCol.getText();
    			String exp = "Gender";
    			System.out.println(act);
    			sa.assertEquals(act, exp);
    		}
    		else if(TBCol.getText().contains("State")){
    			String act = TBCol.getText();
    			String exp = "State";
    			System.out.println(act);
    			sa.assertEquals(act, exp);
    		}
    		else if(TBCol.getText().contains("Action")){
    			String act = TBCol.getText();
    			String exp = "Action";
    			System.out.println(act);
    			sa.assertEquals(act, exp);
    		}
    		sa.assertAll();
    	}
    }
    
    @Test
    public void verifyDeleteButton(){
    	String act = up.checkDeletePopupMsg();
    	driver.switchTo().alert().accept();
    	Assert.assertEquals(act,"You can not delete Default User");
    }
    
    @Test
    public void verifyAddUserBtnClickable(){
    	aup = up.checkaddUserBtn();
    	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Add User");
    	driver.navigate().back();

    }
    
}
