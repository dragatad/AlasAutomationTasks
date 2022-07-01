package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{

    private By addToCartButton = By.className("btn_primary");

    public ProductPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAddToCartButton() {
        return getDriver().findElement(addToCartButton);
    }

    /**
     * Metoda za klik na add to cart dugme
     */
    public void addToCartClick(){
        getAddToCartButton().click();
    }
}
