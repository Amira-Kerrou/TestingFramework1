package HRspace.contract;

import Objects.ContractModel;
import base.ContractConstant;
import org.testng.annotations.*;
import pages.HR.contract.Contract;
import base.BaseSetup;
import tasks.authentification.authentification;
import tasks.contract.ContractTasks;
import utils.DataProviderUtil;
import utils.ScreenshotUtils;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Epic("Stark HRM")
@Feature("Contract")
public class AddContract extends Contract {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        authentification login = PageFactory.initElements(BaseSetup.getDriver(), authentification.class);
        login.setupTest(browser);
    }

    @DataProvider(name = "DataProvider")
    public Object[][] getItemsDataProvider() throws IOException {
        List<ContractModel> List = DataProviderUtil.getListFromJsonFile(
                ContractConstant.RELATIVE_PATH + "contractData.json", "contract", ContractModel.class);
        return new Object[][]{{List}};
    }

    @Test(dataProvider = "DataProvider")
    public void testContractPage(List<ContractModel> contracts) {
        ContractTasks tasks = PageFactory.initElements(BaseSetup.getDriver(), ContractTasks.class);
        tasks.navigateToHRSpacePage();
        tasks.navigateToContractPage();
        tasks.addNewContract(contracts.get(0));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            ScreenshotUtils.takeScreenshot(BaseSetup.getDriver());
        }
    }
}
