package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboardpage {

	WebDriver dpdriver;

	public Dashboardpage(WebDriver driver) {
		this.dpdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(xpath = "//b[text()='Java By Kiran']")
	private WebElement jbkHeader;

	@FindBy(tagName = "img")
	private WebElement uimg;

	@FindBy(xpath = "//ul/following::li")
	private List<WebElement> sidebrMenu;

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashLink;

	@FindBy(xpath = "//h3[text()='Selenium']")
	private WebElement selHeading;

	@FindBy(xpath = "//p[text()='Automation Testing']")
	private WebElement autoTest;

	@FindBy(xpath = "//a[@href='../pdf/selenium-testing-syllabus-jbk.pdf']")
	private WebElement selMoreinfo;

	@FindBy(xpath = "//h3[text()='Java / J2EE']")
	private WebElement javaj2eeHeading;

	@FindBy(xpath = "//p[text()='Software Development']")
	private WebElement swdevlop;

	@FindBy(xpath = "//span[text()='Users']")
	private WebElement userLink;

	@FindBy(xpath = "//span[text()='Operators']")
	private WebElement oprtrlnk;

	@FindBy(xpath = "//span[text()='     Useful Links']")
	private WebElement useflinks;

	@FindBy(xpath = "//span[text()='Downloads']")
	private WebElement downloads;

	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logout;
	
	public boolean verifyHeader() {
		return header.isDisplayed();
	}

	public String verifyHeaderText() {
		return header.getText();
	}

	public String verify_Header_javaByKiran() {
		return jbkHeader.getText();

	}

	public boolean verify_UserImage() {
		return uimg.isDisplayed();
	}

	public List<WebElement> checkSideBar_Menu() {
		return sidebrMenu;

	}

	public Dashboardpage clickDashboard() {
		dashLink.click();
		return new Dashboardpage(dpdriver);

	}

	public String verifHeadingSelenium() {
		return selHeading.getText();

	}

	public String checkSmallText_AutomationTesting() {
		return autoTest.getText();

	}

	public String clickSelenium_Moreinfo() {
		selMoreinfo.click();
		return dpdriver.getWindowHandles().toArray()[1].toString();
	}

	public String checkHeadingJavaJ2EE() {
		return javaj2eeHeading.getText();
	}

	public String check_SoftwareDevelopment_Text() {
		return swdevlop.getText();
	}

	public UsersPage checkUsersLink() {
		userLink.click();
		return new UsersPage(dpdriver);

	}

	public OperatorPage checkOperatorLink_Clickable() {
		oprtrlnk.click();
		return new OperatorPage(dpdriver);
	}
	
	public UsefulLinksPage checkUsefulLinks_Clickable(){
		useflinks.click();
		return new UsefulLinksPage(dpdriver);
	}
	
	public DownloadsPage checkDownloads_clickable(){
		downloads.click();
		return new DownloadsPage(dpdriver);
	}
	
	public LoginPage checkLogoutLink(){
		logout.click();
		return new LoginPage(dpdriver);
	}
}
