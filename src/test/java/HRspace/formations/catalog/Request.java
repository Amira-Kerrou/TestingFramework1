package HRspace.formations.catalog;

import base.BaseSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tasks.authentification.Authentification;
import tasks.formation.FormationTasks;
import utils.ScreenshotUtils;

import java.io.FileNotFoundException;


@Epic("Stark HRM")
@Feature("Collaborators")
public class Request extends FormationTasks {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        Authentification login = PageFactory.initElements(BaseSetup.getDriver(), Authentification.class);
        login.setupTest(browser);
    }

    @Test(description = "Add new training in the catalog")
    public void catalogPage(){
        FormationTasks tasks = PageFactory.initElements(BaseSetup.getDriver(), FormationTasks.class);
        tasks.navigateToCatalogSpace();
        tasks.sendRequest();

    }


    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {if (!result.isSuccess()) {ScreenshotUtils.takeScreenshot(BaseSetup.getDriver());}}
}



