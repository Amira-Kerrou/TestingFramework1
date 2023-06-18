package HRspace.teams;

import base.BaseSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tasks.authentification.AuthentificationTasks;
import tasks.formation.FormationTasks;
import utils.ScreenshotUtils;

import java.io.FileNotFoundException;

public class TeamManagersHistory {
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        AuthentificationTasks login = PageFactory.initElements(BaseSetup.getDriver(), AuthentificationTasks.class);
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
