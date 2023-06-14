package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import lombok.Getter;

import static org.openqa.selenium.remote.Browser.*;


public class BaseSetup {
    @Getter
    public enum Browsers {

        //Chrome Browser
        CHROME,

        //Edge browser.
        EDGE,

        //Firefox browser.
        FIREFOX,

        //Remote Grid / cloud Chrome browser.
        REMOTE_CHROME,

        //Remote Grid / cloud Firefox browser.
        REMOTE_FIREFOX,
        //Remote Grid / cloud edge browser.
        REMOTE_EDGE,

    }

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
   //   public static   WebDriver driver;
    private static final Logger LOG = LogManager.getLogger("DriverManager.class");
    private static final String HUB_URL;
    static public Map<String, String> properties;

    static {
        try {
            properties = parseYamlFile("src/main/resources/appProperties.Yaml");
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        if (properties != null) {
            HUB_URL = (String) properties.get("Hub-URL");
        } else {
            HUB_URL = null;
        }
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (null != DRIVER.get()) {
            LOG.info("Closing the driver...");
            BaseSetup.getDriver().quit();
            DRIVER.remove();
        }
    }

    public void set(By locator, String text) {
        getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(text);
    }

    public void tab(By locator) {
        getDriver().findElement(locator).sendKeys(Keys.TAB);
    }

    public static void createDriver(final Browsers browser) {
        switch (browser) {
            case REMOTE_CHROME:
                setupRemoteChrome();
                break;
            case REMOTE_EDGE:
                setupRemoteEdge();
                break;
            case REMOTE_FIREFOX:
                setupRemoteFirefox();
                break;
            case CHROME:
            default:
                setupChromeDriver();
        }
        setupBrowserTimeouts();
    }

    private static void setupBrowserTimeouts() {
        LOG.info("Setting Browser Timeouts....");
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage()
                .timeouts()
                .scriptTimeout(Duration.ofSeconds(30));
    }

    private static void setupChromeDriver() {
        LOG.info("Setting up Chrome Driver....");
        final boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless"));
        final boolean defaultValue = false;
        final HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("safebrowsing.enabled", "true");
        chromePrefs.put("download.prompt_for_download", "false");
        chromePrefs.put("download.default_directory",
                String.valueOf(Paths.get(System.getProperty("user.home"), "Downloads")));

        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1050,600");
        if (isHeadless) {
            options.addArguments("--headless");
        }
        options.addArguments("--safebrowsing-disable-download-protection");
        options.setExperimentalOption("prefs", chromePrefs);
        setDriver(WebDriverManager.chromedriver()
                .capabilities(options)
                .create());
        LOG.info("Chrome Driver created successfully!");
    }


    private static void setupRemoteChrome() {
        try {
            LOG.info("Setting up Remote Chrome Driver....");
            final DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(CHROME.browserName());
            setDriver(new RemoteWebDriver(new URL(properties.get("Hub-URL")), caps));
            LOG.info("Remote Chrome Driver created successfully!");
        } catch (final MalformedURLException e) {
            LOG.error("Error setting remote_chrome", e);
        }
    }

    private static void setupRemoteFirefox() {
        try {
            LOG.info("Setting up Remote Firefox Driver....");
            final DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(FIREFOX.browserName());
            setDriver(new RemoteWebDriver(new URL(properties.get("Hub-URL")), caps));
            LOG.info("Remote Firefox Driver created successfully!");
        } catch (final MalformedURLException e) {
            LOG.error("Error setting remote_firefox", e);
        }
    }
    private static void setupRemoteEdge() {
        try {
            LOG.info("Setting up Remote Edge Driver....");
            final DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(EDGE.browserName());
            setDriver(new RemoteWebDriver(new URL(properties.get("Hub-URL")), caps));
            LOG.info("Remote Edge Driver created successfully!");
        } catch (final MalformedURLException e) {
            LOG.error("Error setting remote_edge", e);
        }
    }


    public static WebDriver getDriver() {
        return BaseSetup.DRIVER.get();
    }
    private static void setDriver(final WebDriver driver) {
        DRIVER.set(driver);
    }

    public static Map parseYamlFile(String path) {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        }
        properties = yaml.load(inputStream);
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
        return properties;
    }


}