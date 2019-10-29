import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {
    private WebDriver driver;

    // конструктор
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    // локаторы
    private By signInButton = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']");
    private By signUpButton = By.xpath("//a[2][contains(text(),'Sign up')]");
    private By userNameField = By.xpath("//*[@id='user[login]']");
    private By emailField = By.xpath("//*[@id='user[email]']");
    private By passwordField = By.xpath("//*[@id='user[password]']");
    private By signUpFormButton = By.xpath("//button[text()='Sign up for GitHub']");

    // методы
    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public IndexPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }
    public IndexPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public IndexPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    // метод регистрации:
    public SignUpPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}

