import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // локаторы
    private By loginField = By.xpath("//*[@id='login_field']");
    private By passwordField = By.xpath("//*[@id='password']");
    private By signInButton = By.xpath("//*[@name='commit']");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header')]/h1");
    private By error = By.xpath("//*[@id='js-flash-container']//div[@class='container']");
    private By creatAccLink = By.xpath("//a[text()='Create an account']");


    // методы
    public LoginPage typeUserName(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    // невалидные данные:
    public LoginPage loginWithInvalidCregs(String username, String password) {
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    // текст заголовка:
    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage creatAccount() {
        driver.findElement(creatAccLink).click();
        return new SignUpPage(driver);
    }
}

