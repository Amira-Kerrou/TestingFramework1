package HRspace.teams;
import base.constants.ContractConstants;
import base.BaseSetup;
import base.constants.TeamsConstants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import objects.ContractModel;
import objects.TeamsModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tasks.authentification.AuthentificationTasks;
import tasks.contract.ContractTasks;
import tasks.teams.TeamsTasks;
import utils.DataProviderUtil;
import utils.ScreenshotUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Epic("Stark HRM")
@Feature("Contracts")
public class AddNewTeam extends TeamsTasks {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        AuthentificationTasks login = PageFactory.initElements(  BaseSetup.getDriver(), AuthentificationTasks.class);
        login.setupTest(browser);
    }
    @DataProvider(name = "DataProvider")
    public Object[][] getItemsDataProvider() throws IOException {
        List<TeamsModel> itemList = DataProviderUtil.getListFromJsonFile(
                TeamsConstants.RELATIVE_PATH + "teamsData.json", "team", TeamsModel.class); return new Object[][] { { itemList } };
    }
    @Test(description = "Add new team using data provider",  dataProvider = "DataProvider")
    public void contractPage(List<TeamsModel> itemList) {
        TeamsTasks tasks = PageFactory.initElements(  BaseSetup.getDriver(), TeamsTasks.class);
        tasks.navigateToTeamsPage();
        tasks.addNewTeam(itemList.get(0));



    }
    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {if (!result.isSuccess()) {ScreenshotUtils.takeScreenshot(  BaseSetup.getDriver());}
    }
}



