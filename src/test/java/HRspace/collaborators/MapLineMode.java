package HRspace.collaborators;

import org.testng.annotations.Parameters;
import base.BaseSetup;
import pages.HR.collaborators.CollabLocators;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tasks.authentification.AuthentificationTasks;
import tasks.collaborators.CollaboratorTasks;

import java.io.FileNotFoundException;


@Epic("Stark HRM")
@Feature("Collaborators")
public class MapLineMode extends CollabLocators {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        AuthentificationTasks login = PageFactory.initElements(  BaseSetup.getDriver(), AuthentificationTasks.class);
        login.setupTest(browser);}
    @Test
    public void mapLineMode() {
        CollaboratorTasks tasks = PageFactory.initElements(BaseSetup.getDriver(), CollaboratorTasks.class);
        tasks.navigateToHRSpacePage();
        tasks.navigateToCollaboratorPage();
        tasks.changeMode();

    }}
