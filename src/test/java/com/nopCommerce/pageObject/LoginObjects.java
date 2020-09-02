package com.nopCommerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
	
	WebDriver driver;
	
	public LoginObjects(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(this.driver, this);
		
	}

	@FindBy(id = "Email")
	WebElement txtEmail;
	
	@FindBy(id= "Password") 
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement lnkLogOut;

	
	public void setTxtEmail(String txtEmail) {
		this.txtEmail.clear();
		this.txtEmail.sendKeys(txtEmail);
	}

	public void setTxtpwd(String txtpwd) {
		this.txtpwd.clear();
		this.txtpwd.sendKeys(txtpwd);
	}

	public void setBtnLogin() {
		this.btnLogin.click();
	}

	public void setLnkLogOut() {
		this.lnkLogOut.click();
	}
	
		
}
