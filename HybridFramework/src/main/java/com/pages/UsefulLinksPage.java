package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsefulLinksPage {

	WebDriver uldriver;
	public UsefulLinksPage(WebDriver driver) {
        this.uldriver = driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(tagName = "h3")
	private WebElement txtintreq;
	
	@FindBy(xpath = "//tr[1]")
	private List<WebElement> tbcolname;
	
	@FindBy(xpath = "//tr[1]/following::td[3]/a/span")
	private WebElement go;
	
	@FindBy(xpath = "//tr[2]/following::td[3]/a/span")
	private WebElement go1;
	
	@FindBy(xpath = "//tr[6]/following::td[3]/a/span")
	private WebElement go2;
	
	public String checkHeader_UsefulLinks(){
		return header.getText();
	}
	
	public String checkText_InternetRequired(){
		return txtintreq.getText();
	}
	
	public List<WebElement> checkTableColName(){
		return tbcolname;
	}
	
	public String checkLink_Go_ofSchedule_Clickable(){
		go.click();
		return uldriver.getWindowHandles().toArray()[1].toString();
		
	}
	public String checkLink_Go_ofvideoLectures_Clickable(){
		go1.click();
		return uldriver.getWindowHandles().toArray()[1].toString();
	}	
	
//	public String checkLink_Go_ofPlacements_Clickable(){
//		go2.click();
//		return uldriver.getWindowHandles().toArray()[1].toString();
//	}	
}
