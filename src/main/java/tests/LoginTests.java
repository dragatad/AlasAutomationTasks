package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{


    @Test (priority = 1)
    public void verifySuccessfulLogin(){
        getLoginPage().loginProcess("standard_user", "secret_sauce");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test (priority = 2)
    public void verifyCartCounter() throws InterruptedException {
        Thread.sleep(5000);
        getInventoryPage().openDetails("Sauce Labs Backpack");
        getInventoryPage().addToCartButtonClick();
        Assert.assertTrue(getInventoryPage().isCartUpdated());
    }

    @Test (priority = 3)
    public void verifyAddProductToCart(){
        getInventoryPage().openDetails("Sauce Labs Bike Light");
        getProductPage().addToCartClick();
        getCartPage().cartButtonClick();
        Assert.assertTrue(getCartPage().areProductsInCart("Sauce Labs Backpack","Sauce Labs Bike Light"));
    }

    @Test (priority = 4)
    public void verifyRemoveProductFromCart(){
        getCartPage().removeProductFromCartByName("Sauce Labs Backpack");
        Assert.assertTrue(getCartPage().isProductInCart("Sauce Labs Bike Light"));
    }

    @Test (priority = 5)
    public void verifySuccessfulCheckout(){
        getCartPage().checkoutButtonClick();
        getCheckoutPage().completeForm("John","Johnson","7896");
        getCheckoutPage().finishButtonClick();
        Assert.assertEquals(getCheckoutPage().getConfirmationMessage(),"THANK YOU FOR YOUR ORDER");
    }







}
