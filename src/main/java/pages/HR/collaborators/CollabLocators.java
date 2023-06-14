package pages.HR.collaborators;


import base.BaseSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CollabLocators extends BaseSetup {
    public CollabLocators() {
    }

    public void click(WebElement element) {
        element.click();
    }

    @FindBy(xpath = "//div//following::div[contains(@class,'align-items-stretch')]")
    public List<WebElement> collaboratorItems;
    @FindBy(xpath = "//a[contains(., 'HR space') and .//i[contains(@class, 'nav-icon')]]")
    public WebElement HRSpace;

    @FindBy(xpath = "//li/a[contains(@href,'payroll/employee')]")
    public WebElement collaborator;

    @FindBy(xpath = "//button[i[contains(@class,'AddIcon')]]")
    public WebElement addButton;

    public By clickAddButton() {
        try { Thread.sleep(250);

        } catch (InterruptedException e) { e.printStackTrace(); }
        click(addButton);
        return null;
    }

    @FindBy(xpath = "//label[text()=' First name']//following::input[1]")
    public WebElement firstName;

    public void setFirstname(String firstName) {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.firstName.clear();
        this.firstName.sendKeys("mira");
        // set(firstName, text);
        //  return this;
    }


    @FindBy(xpath = "//input[@formcontrolname='LastName']")
    public WebElement lastName;

    public CollabLocators setLastname(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys("kr");
        return this;
    }

    @FindBy(xpath = "//input[@formcontrolname='Email']")
    public WebElement professionalEmail;

    public void setEmailPro(String email) {
        professionalEmail.clear();
        professionalEmail.sendKeys("mira1236987@gmail.com");
    }

    @FindBy(xpath = "//kendo-combobox[@formcontrolname='Sex']/span/kendo-searchbar/input")
    public WebElement gender;

    public void setGender(String gender) {
        this.gender.clear();
        this.gender.sendKeys("male");
    }

    @FindBy(xpath = "//kendo-combobox[@name='idCountryColName']/span/kendo-searchbar/input")
    public WebElement nationality;

    public void setNationality(String nationality) {
        this.nationality.clear();
        this.nationality.sendKeys("Tunisia");
        this.nationality.sendKeys(Keys.DOWN);
        this.nationality.sendKeys(Keys.ENTER);
    }


    @FindBy(xpath = "//button[contains(@class,'btn-save')]")
    public WebElement saveButton;

    public void clickSave() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(saveButton);

    }

    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement yesButton;

    public void clickYes() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(yesButton);
    }

    public void clickYes(String text) {
        set((By) yesButton, text);
    }


    @FindBy(xpath = "//input[@placeholder='Search employee']")
    public WebElement search;
    @FindBy(xpath = "//div[@class='col pl-0 name-style']//a[text()='Amira KERROU']//ancestor::div[@class='card-body p-2']//i[@class='fa fa-trash-o trash-icon cursor-pointer la-lg']")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled' and text()='Yes']")
    public WebElement yesDeleteButton;

    @FindBy(xpath = "//kendo-searchbar[@class='k-searchbar']/input[@id='k-7c1abd16-2b89-4031-af0a-e4fc72fc8adc']")
    public WebElement status;

    // Locator Map/Line mode
    @FindBy(xpath = "//div[@class='col-auto p-1']/i[@class='fa fa-th-large la-2x']")
    public WebElement mode;

    @FindBy(xpath = "//img[@id='dropdownMenuButton']")
    public WebElement exportExel;

    @FindBy(xpath = "//div[@id='action_grid_toggle' and contains(@class,'show')]")
    public WebElement downloadFile;


}
















