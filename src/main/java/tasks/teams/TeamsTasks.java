package tasks.teams;

import base.BaseSetup;
import objects.CollaboratorModel;
import objects.ContractModel;
import objects.TeamsModel;
import org.openqa.selenium.support.PageFactory;
import pages.HR.collaborators.CollabLocators;
import pages.HR.contract.ContractLocators;
import pages.HR.teams.TeamsLocators;

public class TeamsTasks extends BaseSetup {
    public TeamsTasks (){

    }
    TeamsLocators teamsWebElements = PageFactory.initElements(BaseSetup.getDriver(), TeamsLocators.class);

    public void addNewTeam(TeamsModel team){
        teamsWebElements.addButton.click();
        teamsWebElements.name.sendKeys(team.getName());
        teamsWebElements.teamManager.sendKeys(team.getTeamManager());
        teamsWebElements.creationDate.sendKeys(team.getCreationDate());
        teamsWebElements.teamCode.sendKeys(team.getTeamCode());
        teamsWebElements.teamType.sendKeys(team.getTeamType());
        teamsWebElements.saveButton.click();

    }
public void navigateToTeamsPage(){
        teamsWebElements.HRSpace.click();
        teamsWebElements.teamsPage.click();
}


}

