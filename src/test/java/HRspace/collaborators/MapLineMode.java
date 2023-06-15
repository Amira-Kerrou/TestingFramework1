package HRspace.collaborators;

import org.testng.annotations.Parameters;
import base.BaseSetup;
import pages.HR.collaborators.CollabLocators;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tasks.authentification.Authentification;
import tasks.collaborators.CollabTasks;

import java.io.FileNotFoundException;


@Epic("Stark HRM")
@Feature("Collaborators")
public class MapLineMode extends CollabLocators {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String browser) throws FileNotFoundException {
        Authentification login = PageFactory.initElements(  BaseSetup.getDriver(), Authentification.class);
        login.setupTest(browser);}
    @Test
    public void mapLineMode() {
        CollabTasks tasks = PageFactory.initElements(BaseSetup.getDriver(), CollabTasks.class);
        tasks.navigateToHRSpacePage();
        tasks.navigateToCollaboratorPage();
        tasks.changeMode();

    }}
