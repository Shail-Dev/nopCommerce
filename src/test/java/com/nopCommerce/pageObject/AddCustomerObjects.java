package com.nopCommerce.pageObject;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerObjects {
	
	WebDriver driver;
	
	public AddCustomerObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/ul/li[4]/a/span")
	@CacheLookup
	WebElement lnkMainCustomer;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a/span")
	@CacheLookup
	WebElement lnkCustomer;
	
	@FindBy(xpath="//a[@class='btn bg-blue']")
	WebElement lnkAddNew;
	
	@FindBy(id="Email")
	WebElement txtAddCustomerEmail;
	
	@FindBy (id="Password")
	WebElement txtAddCustomerPassword;
	
	@FindBy (id="FirstName")
	WebElement txtAddCustomerFirstName;
	
	@FindBy (id = "LastName")
	WebElement txtAddCustomerLastName;
	
	@FindBy (id="Gender_Male")
	WebElement rdoAddCustomerMaleGender;
	
	@FindBy (id="Gender_Female")
	WebElement rdoAddCustomerFemaleGender;
	
	@FindBy (id="DateOfBirth")
	WebElement dateDOB;
	
	@FindBy(id = "Company")
	WebElement txtAddCustomerCompanyName;
	
	@FindBy(id = "IsTaxExempt")
	WebElement chkAddCustomerTax;
	
	@FindBy(id = "VendorId")
	WebElement drpAddCustomerVenderId;
	
	@FindBy (id="Active")
	WebElement chkAddCustomerActive;
	
	@FindBy(id="SelectedCustomerRoleIds_taglist")
	WebElement tagListSelectedCustomerRoleIds_taglist;
	
	@FindBy (xpath="//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div")//*[@id="customer-info"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div
	WebElement txtCustomerRoles;//txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	@FindBy (xpath="//li[contains(text(),'Administrators')]")
	WebElement  lstitemAdministrators;
	
	@FindBy (xpath = "//li[contains(text(),'Registered')]")
	WebElement  lstitemRegistered;
	
	@FindBy (xpath ="//li[contains(text(),'Guests')]")
	WebElement  lstitemGuests;
	
	public WebElement getLstitemGuests() {
		return lstitemGuests;
	}

	public void setLstitemGuests() {
		
		//tagListSelectedCustomerRoleIds_taglist.click();//This is for clear the default value
		this.txtCustomerRoles.click();
		
		//this.Administrators.sendKeys(lstitemGuests);
		JavascriptExecutor js = (JavascriptExecutor)this.driver;
		js.executeScript("arguments[0].click();", lstitemAdministrators);
	}

	@FindBy (xpath="//li[contains(text(),'Vendors')]")
	WebElement  lstitemVendors;
	
	@FindBy (name = "save")
	WebElement btnSave;
	
	public void setSaveButton() {
		this.btnSave.click();
	}
	
	public void setLnkMainCustomer() {
		this.lnkMainCustomer.click();;
	}

	public void setLnkCustomer() {
		this.lnkCustomer.click();
	}

	public void setLnkAddNew() {
		this.lnkAddNew.click();
	}

	public void setdateDOB(String dateDOB) {
		this.dateDOB.sendKeys(dateDOB);
	}
	
	public void setTxtAddCustomerEmail(String txtAddCustomerEmail) {
		this.txtAddCustomerEmail.sendKeys(txtAddCustomerEmail);
	}

	public void setTxtAddCustomerPassword(String txtAddCustomerPassword) {
		this.txtAddCustomerPassword.sendKeys(txtAddCustomerPassword);
	}

	public void setTxtAddCustomerFirstName(String txtAddCustomerFirstName) {
		this.txtAddCustomerFirstName.sendKeys(txtAddCustomerFirstName);
	}

	public void setTxtAddCustomerLastName(String txtAddCustomerLastName) {
		this.txtAddCustomerLastName.sendKeys(txtAddCustomerLastName);
	}

	public void setRdoAddCustomerMaleGender() {
		this.rdoAddCustomerMaleGender.click();
	}

	public void setRdoAddCustomerFemaleGender() {
		this.rdoAddCustomerFemaleGender.click();
	}

	public void setTxtAddCustomerCompanyName(String txtAddCustomerCompanyName) {
		this.txtAddCustomerCompanyName.sendKeys(txtAddCustomerCompanyName);
	}

	public void setChkAddCustomerTax() {
		this.chkAddCustomerTax.click();
	}

	public void setDrpAddCustomerVenderId(String drpAddCustomerVenderId) {
		this.drpAddCustomerVenderId.sendKeys(drpAddCustomerVenderId);
	}

	public void setChkAddCustomerActive() {
		this.chkAddCustomerActive.click();
	}

	public void setTxtCustomerRoles(String customerRole) {
		
		tagListSelectedCustomerRoleIds_taglist.click();
		this.txtCustomerRoles.click();
		WebElement listItem = lstitemGuests;
		
//		tagListSelectedCustomerRoleIds_taglist.click();
//		this.txtCustomerRoles.click();
//		WebElement listItem;
//		switch(customerRole)
//		{
//		case "Administrators":
//			listItem = lstitemAdministrators; break;
//		case "Guests":
//			listItem=lstitemGuests; break;
//		case "Registered":
//			listItem=lstitemRegistered; break;
//		case "Vendors":
//			listItem=lstitemVendors; break;
//		default:
//			listItem=lstitemGuests;
//		}
					
		JavascriptExecutor js = (JavascriptExecutor)this.driver;
		js.executeScript("arguments[0].click();", listItem);
	}

	

	public void setLstitemVendors(String Vendors) {
		
		Select drp=new Select(lstitemVendors);
		drp.selectByVisibleText(Vendors);
	}

	
	
	

}
