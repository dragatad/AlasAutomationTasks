package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getUsername() {
        return getDriver().findElement(username);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    /**
     * Metoda za unos korisnickog imena
     */
    public void enterUsername(String username){
        clearField(this.username);
        getUsername().sendKeys(username);
    }

    /**
     * Metoda za unos sifre
     */
    public void enterPassword(String password){
        clearField(this.password);
        getPassword().sendKeys(password);
    }

    /**
     * Metoda za klik na login dugme
     */
    public void loginButtonClick(){
        getLoginButton().click();
    }

    /**
     * Metoda za kompletan login process
     */
    public void loginProcess(String username, String password){
        enterUsername(username);
        enterPassword(password);
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginButtonClick();
    }
}
