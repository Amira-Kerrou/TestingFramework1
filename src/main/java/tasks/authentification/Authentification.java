package tasks.authentification;

import base.BaseSetup;
import org.openqa.selenium.support.PageFactory;
import org.yaml.snakeyaml.Yaml;
import pages.authentification.AuthentificationLocators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class Authentification {

    public void setupTest(final String browser) throws FileNotFoundException {

        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("src/main/resources/appProperties.Yaml");
        Map<String, Object> yamlData = yaml.load(inputStream);
        String url = (String) yamlData.get("Stark-URL");
        BaseSetup.createDriver(BaseSetup.Browsers.valueOf(browser.toUpperCase()));
        BaseSetup.getDriver().navigate().to(url);
        AuthentificationLocators authLocators = PageFactory.initElements(  BaseSetup.getDriver(), AuthentificationLocators.class);
        authLocators.login();


    }
}




