package tasks.contract;


import base.BaseSetup;
import objects.CollaboratorModel;
import objects.ContractModel;
import org.openqa.selenium.support.PageFactory;
import pages.HR.collaborators.CollabLocators;
import pages.HR.contract.ContractLocators;

public class ContractTasks extends BaseSetup {

    public ContractTasks () {

    }
    ContractLocators contractWebElements = PageFactory.initElements(BaseSetup.getDriver(), ContractLocators.class);

    public void addNewContract(ContractModel contract) {
        contractWebElements.addButton.click();
        contractWebElements.employee.sendKeys(contract.getEmployee());
        contractWebElements.type.sendKeys(contract.getType());
        //contractWebElements.startDate.sendKeys(("13052023"));
        contractWebElements.salaryStructure.sendKeys(contract.getsalaryStructure());
        contractWebElements.socialContribution.sendKeys(contract.getsocialContribution());
        contractWebElements.saveButton.click();

    }
    public void navigateToHRSpacePage(){

        contractWebElements.HRSpace.click();
    }

    public void navigateToContractPage() {

        contractWebElements.contractnav.click();
    }

    public void updateContract(){
        contractWebElements.updateButton.click();
        contractWebElements.updateType.sendKeys("CDI");
        contractWebElements.saveButton.click();
    }

    public void exportExel (){
        contractWebElements.exelButton.click();
        contractWebElements.downloadExelFile.click();

    }
    public void search (){
        contractWebElements.searchContact.click();
    }
}










