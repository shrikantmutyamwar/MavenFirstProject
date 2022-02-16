package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperatorPage {

	WebDriver opdriver;

	public OperatorPage(WebDriver driver) {
		this.opdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(tagName = "h3")
	private WebElement txtoplst;

	@FindBy(tagName = "th")
	private List<WebElement> oplistTablecol;

	public String checkOPHeader() {
		return header.getText();
	}

	public String checkTextOperatorList() {
		return txtoplst.getText();
	}

	public List<WebElement> checkOpList_TableColmn() {
		return oplistTablecol;
	}

}
