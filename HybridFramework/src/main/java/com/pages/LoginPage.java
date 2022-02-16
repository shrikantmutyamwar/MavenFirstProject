package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver lpdriver;

	public LoginPage(WebDriver driver) {
		this.lpdriver = driver;
		PageFactory.initElements(driver, this); // to initialized webElement
	}

	@FindBy(xpath = "//img")
	private WebElement jbklogo;

	@FindBy(xpath = "//b")
	private WebElement companyName;

	@FindBy(tagName = "h4")
	private WebElement companyTechnologies;
	
	@FindBy(tagName = "p")
	private WebElement loginBoxmsg;

	@FindBy(id = "email")
	private WebElement uname;

	@FindBy(id = "password")
	private WebElement pass;
	
	@FindBy(id = "email_error")
	private WebElement email_err;
	
	@FindBy(id = "password_error")
	private WebElement pass_err;

	@FindBy(xpath = "//button")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Register a new membership']")
	private WebElement regLink;
	

	public void loginToApplication(String username, String password) {

		uname.clear();
		uname.sendKeys(username);
		pass.clear();
		pass.sendKeys(password);
		loginBtn.click();

	}

	public Dashboardpage validLogin() {
		uname.clear();
		uname.sendKeys("kiran@gmail.com");
		pass.clear();
		pass.sendKeys("123456");
		loginBtn.click();
		return new Dashboardpage(lpdriver);
	}

	public boolean verifyJBKLogo() {
		return jbklogo.isDisplayed();
	}

	public String companyName() {
		return companyName.getText();

	}
	
	public String companyTechnologies(){
		return companyTechnologies.getText();
	}
	
	public String verifyLoginBoxmsg(){
		return loginBoxmsg.getText();
	}
	
	public String emailErrorMsg(){
		return email_err.getText();
	}
	
	public String passwordErrorMsg(){
		return pass_err.getText();
	}
	
	public RegistrationPage registerLink(){
		regLink.click();
		return new RegistrationPage(lpdriver);
	}
	
	
}
