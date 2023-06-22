package objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamsModel {

    @JsonProperty("name")
    private String name;

    @JsonProperty("teamManager")
    private String teamManager;

    @JsonProperty("teamCode")
    private String teamCode;

    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("teamType")
    private String teamType;


    public String getName() {
        return name;
    }

    public String getTeamManager() {
        return teamManager;
    }
    public String getTeamCode() {
        return teamCode;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public String getTeamType() {
        return teamType;
    }




}
