package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver rpdriver;

	public RegistrationPage(WebDriver driver) {
		this.rpdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'I already')]")
	private WebElement alrdymemlink;

	@FindBy(tagName = "p")
	private WebElement regNewMemText;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;

	@FindBy(id = "name_error")
	private WebElement name_err;

	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement mobile;

	@FindBy(id = "mobile_error")
	private WebElement mob_err;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "email_error")
	private WebElement eml_err;

	@FindBy(id = "password")
	private WebElement pwd;

	@FindBy(id = "password_error")
	private WebElement pwd_err;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInBtn;

	public LoginPage clickalreadyMembership() {
		alrdymemlink.click();
		return new LoginPage(rpdriver);
	}

	public String regNewMembershipText() {
		return regNewMemText.getText();

	}

	public String registrationPageForm(String Name, String mob, String Email, String password) {
		name.clear();
		name.sendKeys(Name);
		
		mobile.clear();
		mobile.sendKeys(mob);
		
		email.clear();
        email.sendKeys(Email);
		
        pwd.clear();
        pwd.sendKeys(password);
		signInBtn.click();
		
		//String act = rpdriver.switchTo().alert().getText();
		return rpdriver.switchTo().alert().getText() ;

	}
	
	public void registrationPageFormBlank(String Name, String mob, String Email, String password) {
		name.clear();
		name.sendKeys(Name);
		
		mobile.clear();
		mobile.sendKeys(mob);
		
		email.clear();
        email.sendKeys(Email);
		
        pwd.clear();
        pwd.sendKeys(password);
		signInBtn.click();
	
	}

	public String nameErrorMsg() {
		return name_err.getText();

	}

	public String mobileErrorMsg() {
		return mob_err.getText();
	}

	public String emailErrorMsg() {
		return eml_err.getText();
	}

	public String passwordErrorMsg() {
		return pwd_err.getText();
	}
}