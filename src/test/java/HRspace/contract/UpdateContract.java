package HRspace.contract;
import objects.CollaboratorModel;
import base.BaseSetup;
import base.constants.CollaboratorsConstants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import objects.ContractModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tasks.authentification.AuthentificationTasks;
import tasks.contract.ContractTasks;
import utils.DataProviderUtil;
import utils.ScreenshotUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Epic("Stark HRM")
@Feature("Collaborators")
public class UpdateContract extends ContractTasks {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        AuthentificationTasks login = PageFactory.initElements(  BaseSetup.getDriver(), AuthentificationTasks.class);
        login.setupTest(browser);
    }
    @DataProvider(name = "DataProvider")
    public Object[][] getItemsDataProvider() throws IOException {
        List<ContractModel> itemList = DataProviderUtil.getListFromJsonFile(
                CollaboratorsConstants.RELATIVE_PATH + "contractData.json", "contract", ContractModel.class); return new Object[][] { { itemList } };
    }
    @Test(description = "Add new contract using data provider")
    public void contractPage() {
        ContractTasks tasks = PageFactory.initElements(  BaseSetup.getDriver(), ContractTasks.class);
        tasks.navigateToHRSpacePage();
        tasks.navigateToContractPage();
        tasks.updateContract();


    }
    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {if (!result.isSuccess()) {ScreenshotUtils.takeScreenshot(  BaseSetup.getDriver());}
    }
}



