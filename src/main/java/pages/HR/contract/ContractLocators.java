package pages.HR.contract;

import base.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractLocators extends BaseSetup {


    public ContractLocators(){}
    @FindBy(xpath = "//a[contains(., 'HR space') and .//i[contains(@class, 'nav-icon')]]")
    public WebElement HRSpace;


    @FindBy(xpath = "//li[@class='nav-item']/a[@href='/main/payroll/contract']")
    public WebElement contractnav;


    @FindBy(xpath = "//button[@class='btn btn-sm' and contains(@style, 'background-color: #1392bf !important;border-radius: 36px;')]")
    public WebElement addButton ;

    @FindBy(xpath = "//input[@class='k-input' and @tabindex='0' and @role='combobox']")
    public WebElement employee;

    @FindBy(xpath = "(//input[@class='k-input' and @tabindex='0' and @role='combobox'])[1]")
    public WebElement type;

   // @FindBy(xpath = "(//input[@class='k-input' and @tabindex='0' and @role='combobox'])[5]")
  //   public WebElement startDate;
    @FindBy(xpath = "(//input[@class='k-input' and @tabindex='0' and @role='combobox'])[2]")
    public WebElement salaryStructure;

    @FindBy(xpath = "(//input[@class='k-input' and @tabindex='0' and @role='combobox'])[3]")
    public WebElement socialContribution;

    @FindBy(xpath = "//tr[@role='row' and @aria-rowindex='2']//i[@class='las la-pen cursor-pointer edit-pencil la-lg']")
    public WebElement updateButton;

    @FindBy(xpath = "//input[@id='k-72ee07d3-8d6c-4770-84df-535343ca2e5a']")
    public WebElement updateType;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-save mx-1'][@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@placeholder='Search employee']")
    public WebElement searchContact;

    @FindBy(xpath = "//img[@id='dropdownMenuButton']")
    public WebElement exelButton;

    @FindBy(xpath = "//a[@class='dropdown-item dpItem']")
    public WebElement downloadExelFile;

}

