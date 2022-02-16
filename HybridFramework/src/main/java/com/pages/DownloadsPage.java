package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadsPage {

	WebDriver dldriver;
	public DownloadsPage(WebDriver driver) {
       this.dldriver = driver;
       PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	private WebElement header;
	
	@FindBy(tagName = "h3")
	private WebElement txtdwnst;

	@FindBy(xpath = "//tr[1]")
	private List<WebElement> colname;
	
	@FindBy(xpath="//tr[2]/td[8]//a")
	private WebElement offweb;
	
	@FindBy(xpath="//tr[3]/td[8]/a")
	private WebElement offwebseljar;
	
	@FindBy(xpath="//tr[5]/td[8]/a")
	private WebElement offwebchrme;
	
	@FindBy(xpath="//tr[7]/td[8]/a")
	private WebElement offwebfirefox;
	
	public String checkHeaderdownloads(){
		return header.getText();
	}
	
	public String checkTextdownloadsList(){
		return txtdwnst.getText();
	}
	
//	public List<WebElement> checkText_ofDownloadsList_AllColumnName(){
//		return colname;
//	}
	
	public String checkOfficialwebsiteOfJDK_Clickable(){
		offweb.click();
		return dldriver.getWindowHandles().toArray()[1].toString();
	}
	public String checkOfficialwebsiteOfstandaloneJAR_Clickable(){
		offwebseljar.click();
		return dldriver.getWindowHandles().toArray()[1].toString();
	}
	
	public String checkOfficialwebsiteOfGoogleChrome_Clickable(){
		offwebchrme.click();
		return dldriver.getWindowHandles().toArray()[1].toString();
	}
	public String checkOfficialwebsiteOfFireFox_Clickable(){
		offwebfirefox.click();
		return dldriver.getWindowHandles().toArray()[1].toString();
	}
}
