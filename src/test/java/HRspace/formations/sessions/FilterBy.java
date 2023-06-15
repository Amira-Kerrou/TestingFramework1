package HRspace.formations.sessions;

import base.BaseSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tasks.authentification.Authentification;
import tasks.formation.FormationTasks;
import utils.ScreenshotUtils;

import java.io.FileNotFoundException;

public class FilterBy {
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
        tasks.searchTraining();

    }


    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {if (!result.isSuccess()) {
        ScreenshotUtils.takeScreenshot(BaseSetup.getDriver());}}
}
