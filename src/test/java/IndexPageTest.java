import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class IndexPageTest {
    private WebDriver driver;
    private IndexPage indexPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/Anton/IdeaProjects/pageobjectseleniumtest/drivers/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://github.com");

        indexPage = new IndexPage(driver);
    }

    @Test
    public void signIn() {
        LoginPage loginPage = indexPage.clickSignInButton();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);

    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = indexPage.register("anyUserSomeName","anyUserEmail@gmail.com", "qwertyuiop1234");
        String error = signUpPage.getPasswordErrorText();
        Assert.assertEquals("Password is weak and can be easily guessed", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
