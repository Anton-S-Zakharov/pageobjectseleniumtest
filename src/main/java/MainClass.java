import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/Users/Anton/IdeaProjects/pageobjectseleniumtest/drivers/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://github.com");

        IndexPage indexPage = new IndexPage(driver); // и передадим туда driver.
        indexPage.register("anyUserSomeName","anyUserEmail@gmail.com", "qwertyuiop1234");


    }
}
