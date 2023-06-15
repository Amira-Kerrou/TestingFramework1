package objects;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ContractModel {
    @JsonProperty("employee")
    private String employee;

    @JsonProperty("type")
    private String type;

    public String getEmployee() {
        return employee;
    }

    public String getType() {
        return type;
    }





}
