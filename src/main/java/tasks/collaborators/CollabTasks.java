package tasks.collaborators;

import Objects.CollaboratorModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HR.collaborators.CollabLocators;
import base.BaseSetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;

public class CollabTasks extends BaseSetup {
    public CollabTasks() {
    }

    CollabLocators collaboratorWebElements = PageFactory.initElements(  BaseSetup.getDriver(), CollabLocators.class);
    CollaboratorModel collabModel = PageFactory.initElements(  BaseSetup.getDriver(), CollaboratorModel.class);
    

    public void deleteCollaborator() {
        collaboratorWebElements.deleteButton.click();
        collaboratorWebElements.yesDeleteButton.click();
    }

    public void addNewCollaborator(CollaboratorModel collaborator) {

        collaboratorWebElements.clickAddButton();
        collaboratorWebElements.firstName.sendKeys(collaborator.getFirstName());
        collaboratorWebElements.lastName.sendKeys(collaborator.getLastName());
        collaboratorWebElements.nationality.sendKeys(collaborator.getNationality());
        collaboratorWebElements.gender.sendKeys(collaborator.getGender());
        collaboratorWebElements.professionalEmail.sendKeys(collaborator.getEmail());
     /*   collabModel.getFirstName();
        collabModel.getLastName();
        collabModel.getGender();
        collabModel.getEmail();
        collabModel.getNationality();*/
        JavascriptExecutor js = (JavascriptExecutor)   BaseSetup.getDriver();
        js.executeScript("window.scrollBy(0, 250)", "");
        collaboratorWebElements.clickSave();
        collaboratorWebElements.clickYes();

    }


    public void searchCollaborator(String firstAndLastNames) {
        collaboratorWebElements.search.click();
        collaboratorWebElements.search.sendKeys(firstAndLastNames);
        collaboratorWebElements.search.sendKeys(Keys.RETURN);
        Assert.assertTrue(collaboratorWebElements.collaboratorItems.size() != 0, "Collaborator with first name and lastName is well created");

      /*  WebElement collaboratorElement = driver.findElement(By.xpath("//xpath_expression"));
        boolean isCollaboratorAdded = collaboratorElement.isDisplayed();
        Assert.assertTrue(isCollaboratorAdded, "Collaborator '" + collaboratorElement + "' has been successfully added.");*/
        System.out.println("Collaborator  has been successfully added.");
    }


    public void navigateToHRSpacePage() {
        collaboratorWebElements.HRSpace.click();
    }

    public void navigateToCollaboratorPage() {
        collaboratorWebElements.collaborator.click();

    }

    public void exportExel() {
        collaboratorWebElements.exportExel.click();
        collaboratorWebElements.downloadFile.click();

    }

    public void changeMode() {
        collaboratorWebElements.mode.click();
    }
}
