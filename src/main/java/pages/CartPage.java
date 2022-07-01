package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{

    private By cartButton = By.className("shopping_cart_link");
    private By removeButton = By.className("btn_secondary");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getCartButton() {
        return getDriver().findElement(cartButton);
    }

    public WebElement getRemoveButton(){
        return getDriver().findElement(removeButton);
    }

    public WebElement getCheckoutButton(){
        return getDriver().findElement(checkoutButton);
    }

    /**
     * Metoda za klik na cart dugme
     */
    public void cartButtonClick(){
        getCartButton().click();
    }

    /**
     * Metoda za klik na checkout dugme
     */
    public void checkoutButtonClick(){
        getCheckoutButton().click();
    }

    /**
     * Metoda za proveru proizvoda u korpi na osnovu njihovih imena
     */
    public boolean areProductsInCart(String productName1, String productName2) {
        List<WebElement> productList = getDriver().findElements(By.className("cart_list"));
        for (WebElement product : productList) {
            if (product.getText().contains(productName1) && product.getText().contains(productName2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda za uklanjanje proizvoda iz korpe na osnovu imena
     * @param productName
     */
    public void removeProductFromCartByName(String productName) {
        List<WebElement> productsInCart = getDriver().findElements(By.className("cart_list"));
        for (WebElement product : productsInCart) {
            if (product.getText().contains(productName)) {
                getRemoveButton().click();
            }
        }
    }

    /**
     * Metoda za proveru pojedinacnog proizvoda u korpi na osnovu imena
     */
    public boolean isProductInCart(String productName) {
        List<WebElement> productList = getDriver().findElements(By.className("cart_list"));
        for (WebElement product : productList) {
            if (product.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

}
