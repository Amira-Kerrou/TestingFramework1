package HRspace.collaborators;

import objects.CollaboratorModel;
import base.BaseSetup;
import base.constants.CollaboratorsConstants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tasks.authentification.Authentification;
import tasks.collaborators.CollabTasks;
import utils.DataProviderUtil;
import utils.ScreenshotUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Epic("Stark HRM")
@Feature("Collaborators")
public class DeleteCollaborator extends CollabTasks {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        Authentification login = PageFactory.initElements(BaseSetup.getDriver(), Authentification.class);
        login.setupTest(browser);
    }

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
        tasks.addNewCollaborator(itemList.get(1));
        tasks.searchCollaborator(itemList.get(1).getFirstName() + itemList.get(1).getLastName());
        tasks.deleteCollaborator();
    }


    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            ScreenshotUtils.takeScreenshot(BaseSetup.getDriver());
        }
    }
}



