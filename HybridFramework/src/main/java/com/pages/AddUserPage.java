package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {

	WebDriver aupdriver;
	public AddUserPage(WebDriver driver) {
		this.aupdriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(tagName="h1")
	private WebElement headerAddUser;

	@FindBy(tagName="h3")
	private WebElement filldetails;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement uname;
	
	@FindBy(xpath="//input[@id='mobile']")
	private WebElement mb;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement eml;
	
	@FindBy(xpath="//input[@id='course']")
	private WebElement corse;
	
	@FindBy(xpath="//input[@id='Male']")
	private WebElement rmale;
	
	@FindBy(tagName="select")
	private WebElement dropdwn;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@placeholder='FriendMobile']")
	private WebElement frndmob;
	
	@FindBy(tagName="button")
	private WebElement submitBtn;
	
	
	@FindBy(xpath="//span[text()='Cancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//a[text()='JBK']")
	private WebElement jbklink;
	
	@FindBy(xpath="//span[text()='Operators']")
	private WebElement oprtrlnk;
	
	public String checkHeaderAddUser(){
		return headerAddUser.getText();
	}
	
	public String checkTextFill_Details(){
		return filldetails.getText();
	}
	
	public String addUserForm(String Name,String mobile,String email,String course,String passw,String frndmobile){
		uname.clear();
		uname.sendKeys(Name);
		mb.clear();
		mb.sendKeys(mobile);
		eml.clear();
		eml.sendKeys(email);
		corse.clear();
		corse.sendKeys(course);
		rmale.click();
		Select se = new Select(dropdwn);
		se.selectByVisibleText("Maharashtra");
		pwd.clear();
		pwd.sendKeys(passw);
		frndmob.clear();
		frndmob.sendKeys(frndmobile);
		submitBtn.click();
		
		return aupdriver.switchTo().alert().getText();
	}
	
	public UsersPage addUserFormCancelButton(String Name,String mobile,String email,String course,String passw,String frndmobile){
		uname.clear();
		uname.sendKeys(Name);
		mb.clear();
		mb.sendKeys(mobile);
		eml.clear();
		eml.sendKeys(email);
		corse.clear();
		corse.sendKeys(course);
		rmale.click();
		Select se = new Select(dropdwn);
		se.selectByVisibleText("Maharashtra");
		pwd.clear();
		pwd.sendKeys(passw);
		frndmob.clear();
		frndmob.sendKeys(frndmobile);
		cancelBtn.click();
		
		return new UsersPage(aupdriver);

}
	public String checkJBKLink(){
		jbklink.click();
		return aupdriver.getCurrentUrl();
	}
	
	public OperatorPage checkOperatorLink(){
		oprtrlnk.click();
		return new OperatorPage(aupdriver);
	}
}