package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

	WebDriver updriver;
	public UsersPage(WebDriver driver) {
		this.updriver = driver;
		PageFactory.initElements(driver, this);  //to initialized webElement
	}
	@FindBy(tagName = "h1")
	private WebElement userHeader;
	
	@FindBy(xpath = "//button[text()='Add User']")
	private WebElement addUserBtn;

	@FindBy(tagName = "h3")
	private WebElement userListText;
	
	@FindBy(xpath = "//a[text()='JavaByKiran']")
	private WebElement jbkLink;
	
	@FindBy(tagName = "th")
	private List<WebElement> tablecol;
	
	@FindBy(xpath="//tr[2]//a/span")
	private WebElement deleteBtn;
	
	public String checkHeaderUser(){
		return userHeader.getText();
	}
	
	public String checkText_userList(){
		return userListText.getText();
	}
	
	public AddUserPage checkaddUserBtn(){
		addUserBtn.click();
		return new AddUserPage(updriver);
	}
	
	public String checkLink_JavaByKiran(){
		jbkLink.click();
		return updriver.getWindowHandles().toArray()[1].toString();
	}
	
	public List<WebElement> check_TableCol(){
		    return tablecol;
	}
	
	public String checkDeletePopupMsg(){
		deleteBtn.click();
       return updriver.switchTo().alert().getText();
	}
	
}
