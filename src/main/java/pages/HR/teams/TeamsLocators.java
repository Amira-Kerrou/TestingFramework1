package pages.HR.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamsLocators {
   // @FindBy(xpath = "")
   // public WebElement ;

    @FindBy(xpath = "//li[@class=\"nav-item\"]/a[@routerlinkactive=\"active\" and @class=\"nav-link\" and @href=\"/main/payroll/team\"]")
    public WebElement teamsPage;

    @FindBy(xpath = "//span[@_ngcontent-c32 and @style=color: white]")
    public WebElement addButton;

    @FindBy(xpath = "//input[@class=\"form-control ng-pristine ng-invalid has-error ng-touched\" and @formcontrolname=\"Name\" and @type=\"text\"]")
    public WebElement name ;

    @FindBy(xpath = "(\"//input[@class='k-input']\")[0]")
     public WebElement teamManager ;
    @FindBy(xpath = "//input[@formcontrolname='TeamCode']")
    public WebElement teamCode ;

    @FindBy(xpath = "(\"//input[@class='k-input']\")[1]")
    public WebElement creationDate ;

    @FindBy(xpath = "(\"//input[@class='k-input']\")[2]")
    public WebElement teamType ;


    @FindBy(xpath = "//button[@class='btn btn-sm btn-success mx-1' and @type='submit']")
    public WebElement saveButton ;
    @FindBy(xpath = "//ul/li/a[i[@class='nav-icon icon-people']]")
    public WebElement HRSpace;




}
