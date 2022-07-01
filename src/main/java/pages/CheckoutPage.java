package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public CheckoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName() {
        return getDriver().findElement(lastName);
    }

    public WebElement getZipCode() {
        return getDriver().findElement(zipCode);
    }

    public WebElement getContinueButton() {
        return getDriver().findElement(continueButton);
    }

    /**
     * Metoda za dobijanje konfirmacione poruke
     */
    public String getConfirmationMessage(){
        return getDriver().findElement(confirmationMessage).getText();
    }

    public WebElement getFinishButton(){
        return getDriver().findElement(finishButton);
    }

    /**
     * Metoda za unos imena
     */
    public void enterFirstName(String firstName){
        clearField(this.firstName);
        getFirstName().sendKeys(firstName);
    }

    /**
     * Metoda za unos prezimena
     */
    public void enterLastName(String lastName){
        clearField(this.lastName);
        getLastName().sendKeys(lastName);
    }

    /**
     * Metoda za unos postanskog koda
     */
    public void enterZipCode(String zipCode){
        clearField(this.zipCode);
        getZipCode().sendKeys(zipCode);
    }

    /**
     * Metoda za klik na continue dugme
     */
    public void continueButtonClick(){
        getContinueButton().click();
    }

    /**
     * Metoda za klik na finish dugme
     */
    public void finishButtonClick(){
        getFinishButton().click();
    }

    /**
     * Metoda za kompletno popunjavanje forme
     */
    public void completeForm(String firstName, String lastName, String zipCode){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.firstName));
        enterFirstName(firstName);
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.lastName));
        enterLastName(lastName);
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.zipCode));
        enterZipCode(zipCode);
        continueButtonClick();
    }

}
