package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage{

    private By addToCartButton = By.className("btn_primary");
    private By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAddToCartButton() {
        return getDriver().findElement(addToCartButton);
    }

    public WebElement getCartBadge(){
        return getDriver().findElement(cartBadge);
    }

    /**
     * Get metoda za pronalazak web elementa na osnovu imena proizvoda
     */
    public WebElement getProductByName(String name) {
        return getDriver().findElement(By.linkText(name));
    }

    /**
     Klik na web element proizvoda za otvaranje detaljnog pregleda na osnovu imena prozivoda
     */
    public void openDetails(String productName) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getProductByName(productName)).click().perform();
    }

    /**
     * Klik na dugme add to cart
     */
    public void addToCartButtonClick() {
        getAddToCartButton().click();
    }

    /**
     * Metoda za proveru update na cart dugmetu
     */
    public boolean isCartUpdated(){
        String cartCount = getDriver().findElement(By.className("shopping_cart_badge")).getText();
        return true;
    }












}
