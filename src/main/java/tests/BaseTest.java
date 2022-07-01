package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Acer\\geckodriver.exe");
        driver = new FirefoxDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
        loginPage = new LoginPage(driver,driverWait);
        inventoryPage = new InventoryPage(driver, driverWait);
        productPage = new ProductPage(driver, driverWait);
        cartPage = new CartPage(driver, driverWait);
        checkoutPage = new CheckoutPage(driver, driverWait);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public InventoryPage getInventoryPage() {
        return inventoryPage;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public CartPage getCartPage(){
        return cartPage;
    }

    public CheckoutPage getCheckoutPage(){
        return checkoutPage;
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }

}
