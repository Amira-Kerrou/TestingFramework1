package tasks.contract;


import base.BaseSetup;
import pages.HR.contract.ContractLocators;

public class ContractTasks extends BaseSetup {

    public ContractTasks () {

    }
    ContractLocators contractWebElements = new ContractLocators();

    public void addNewContract() {
        contractWebElements.addButton.click();
        contractWebElements.employee.sendKeys("aaa AAA");
        contractWebElements.type.sendKeys("CDD");
        contractWebElements.startDate.sendKeys(("13052023"));
        contractWebElements.salaryStructure.sendKeys("CDD");
        contractWebElements.socialContribution.sendKeys("NORMAL");
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










