package Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CollaboratorModel {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("gender")
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGender() {
        return gender;
    }

}
