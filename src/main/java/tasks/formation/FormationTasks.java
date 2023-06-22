package tasks.formation;


import base.BaseSetup;
import objects.FormationModel;
import org.openqa.selenium.support.PageFactory;
import pages.HR.formations.CatalogLocators;
import pages.HR.formations.RequestsLocators;
import pages.HR.formations.SessionsLocators;

public class FormationTasks extends BaseSetup {
    public FormationTasks() {
    }

    CatalogLocators catalogWebElements = PageFactory.initElements(BaseSetup.getDriver(), CatalogLocators.class);
    RequestsLocators RequestsWebElements = PageFactory.initElements(BaseSetup.getDriver(), RequestsLocators.class);
    SessionsLocators SessionsWebElements = PageFactory.initElements(BaseSetup.getDriver(), SessionsLocators.class);


    public void AddNewCtalog(FormationModel catalog) {
        catalogWebElements.addCatalog.click();
        catalogWebElements.title.sendKeys(catalog.getTitle());
        catalogWebElements.description.sendKeys(catalog.getDescription());
        catalogWebElements.saveCatalog.click();
    }



    public void navigateToCatalogSpace() {
        catalogWebElements.HRSpace.click();
        catalogWebElements.formationsButton.click();
        catalogWebElements.catalog.click();
    }

    public void planifySession() {
        catalogWebElements.planify.click();
        catalogWebElements.nameOfSession.sendKeys("Session for tesing");
        catalogWebElements.saveSession.click();
    }

public void sendRequest(){
        catalogWebElements.request.click();
        catalogWebElements.saveRequest.click();
}
public void searchTraining (){
        catalogWebElements.searchCatalog.sendKeys("Catalog 1 ");
    System.out.println(" New catalog has been added");
}
}


