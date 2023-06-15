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

    @FindBy(xpath = "//input[@id='k-8017306f-f03f-4369-8dce-138473af9396']")
    public WebElement employee;
    @FindBy(xpath = "//input[@id='k-6f512973-3e31-4dc2-9bc3-ca983b760b52']")
    public WebElement type;
    @FindBy(xpath = "//input[@id='k-2197da59-8182-48ed-b801-71c766b01712']")
    public WebElement startDate;
    @FindBy(xpath = "//input[@id='k-4f3da532-d574-4e20-8ea3-74756eeadd71']")
    public WebElement salaryStructure;

    @FindBy(xpath = "//input[@id='k-fa396bb2-bedb-4dda-8ca1-7c21b7a56cb8']")
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

