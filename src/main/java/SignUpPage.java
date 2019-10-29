import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//main//h1");
    //поля, кнопка:
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By userEmailField = By.xpath("//input[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
    // сообщения с ошибками:
    private By mainError = By.xpath("//div[@id='js-flash-container']//p[1]");
    private By userNameError = By.xpath("//input[@id='user_login']/ancestor::dl//div[contains(@class,'mb-1')]");
    private By emailError = By.xpath("//input[@id='user_email']/ancestor::dl/dd[@class='error']");
    private By passwordError = By.xpath("//input[@id='user_password']/ancestor::password-strength//span[@class='text-red text-bold'][1]");

    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }
    public SignUpPage typeEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }
    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton);
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }
    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }
    public String getUserNameErrorText() {
        return driver.findElement(userNameError).getText();
    }
    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }
    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

}
