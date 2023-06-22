package objects;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ContractModel {
    @JsonProperty("employee")
    private String employee;

    @JsonProperty("type")
    private String type;
    @JsonProperty("salaryStructure")
    private String salaryStructure;
    @JsonProperty("socialContribution")
    private String socialContribution;


    public String getEmployee() {
        return employee;
    }

    public String getType() {
        return type;
    }
    public String getsalaryStructure() {
        return salaryStructure;
    }
    public String getsocialContribution() {
        return socialContribution;
    }








}
