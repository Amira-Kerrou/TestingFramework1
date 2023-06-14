package tasks.contract;


import java.io.FileReader;
import java.util.Properties;

import Objects.CollaboratorModel;
import Objects.ContractModel;
import base.BaseSetup;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pages.HR.contract.Contract;

public class ContractTasks extends BaseSetup {

    public ContractTasks () {

    }
    Contract contractWebElements = new Contract();

    public void addNewContract(ContractModel contract) {
        contractWebElements.addButton.click();
        contractWebElements.employee.sendKeys(contract.getEmployee());
        contractWebElements.type.sendKeys(contract.getType());
        contractWebElements.saveButton.click();


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


    public void navigateToHRSpacePage(){

        contractWebElements.HRSpace.click();
    }

    public void navigateToContractPage() {

        contractWebElements.contractnav.click();
    }
}










