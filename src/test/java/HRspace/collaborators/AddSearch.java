package HRspace.collaborators;

import Objects.CollaboratorModel;
import base.BaseSetup;
import base.CollaboratorsConstants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.yaml.snakeyaml.Yaml;
import pages.authentification.Authentification;
import tasks.collaborators.CollabTasks;
import utils.DataProviderUtil;
import utils.ScreenshotUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Epic("Stark HRM")
@Feature("Collaborators")
public class AddSearch extends CollabTasks {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("src/main/resources/appProperties.Yaml");
        Map<String, Object> yamlData = yaml.load(inputStream);
        String url = (String) yamlData.get("Stark-URL");
        BaseSetup.createDriver(Browsers.valueOf(browser.toUpperCase()));
        // BaseSetup.getDriver()=getDriver();
        BaseSetup.getDriver().navigate().to(url);
        Authentification authLocators = PageFactory.initElements(BaseSetup.getDriver(), Authentification.class);
        authLocators.login();
    }

    // WebDriver driveCollab = BaseSetup.getDriver();
    /*@BeforeClass(alwaysRun = true)
   public void crendentials() {
        Authentification authLocators = PageFactory.initElements(driveCollab, Authentification.class);
        authLocators.login();}*/


    @DataProvider(name = "DataProvider")
    public Object[][] getItemsDataProvider() throws IOException {
        List<CollaboratorModel> itemList = DataProviderUtil.getListFromJsonFile(
                CollaboratorsConstants.RELATIVE_PATH + "collaboratorData1.json", "Collaborators", CollaboratorModel.class);
        return new Object[][]{{itemList}};
    }

    @Test(description = "Add collaborator using data provider", dataProvider = "DataProvider")
    public void collabPage(List<CollaboratorModel> itemList) {
        CollabTasks tasks = PageFactory.initElements(BaseSetup.getDriver(), CollabTasks.class);
        tasks.navigateToHRSpacePage();
        tasks.navigateToCollaboratorPage();
        tasks.addNewCollaborator(itemList.get(0));
        tasks.searchCollaborator(itemList.get(0).getFirstName() + itemList.get(0).getLastName());
        tasks.deleteCollaborator();
    }
    /*@Test(description = "Add collaborator using data provider", dataProvider = "dataProvider1")
    public void testAdd(HashMap<String, String> hashMap) {
        CollabTasks tasks = PageFactory.initElements(driver, CollabTasks.class); }*/

    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            ScreenshotUtils.takeScreenshot(BaseSetup.getDriver());
        }
    }
}



