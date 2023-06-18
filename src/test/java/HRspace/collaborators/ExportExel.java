package HRspace.collaborators;

import org.testng.annotations.Parameters;
import org.yaml.snakeyaml.Yaml;
import base.BaseSetup;
import pages.HR.collaborators.CollabLocators;
import pages.authentification.AuthentificationLocators;
import tasks.collaborators.CollaboratorTasks;
import utils.ScreenshotUtils;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


@Epic("Stark HRM")
@Feature("Collaborators")
public class ExportExel extends CollabLocators {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("src/main/resources/appProperties.Yaml");
        Map<String, Object> yamlData = yaml.load(inputStream);
        String url = (String) yamlData.get("Stark-URL");
        BaseSetup.createDriver(Browsers.valueOf(browser.toUpperCase()));

        BaseSetup.getDriver().navigate().to(url);
        AuthentificationLocators authLocators = PageFactory.initElements(  BaseSetup.getDriver(), AuthentificationLocators.class);
        authLocators.login();}
    @Test
    public void exportExel(){
        CollaboratorTasks tasks = PageFactory.initElements(BaseSetup.getDriver(), CollaboratorTasks.class);
        tasks.navigateToHRSpacePage();
        tasks.navigateToCollaboratorPage();
        tasks.exportExel();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws IOException {if (!result.isSuccess()) {ScreenshotUtils.takeScreenshot(BaseSetup.getDriver());}}
}
