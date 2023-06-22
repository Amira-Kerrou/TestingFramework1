package objects;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FormationModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }













}
