package org.example;

import org.testng.annotations.Test;

public class TestPage extends BaseTest {

    @Test(priority = 1)
    public void openPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginPage();
        loginPage.enterCredentials("performance_glitch_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.Logout();
        loginPage.enterCredentials("standard_user", "secret_sauce");
    }

    @Test(priority = 2)
    public void selectProduct() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.select();
        Thread.sleep(3000);
        productPage.checkCart();
    }

    @Test(priority = 3)
    public void removeAndSelect() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.RemoveProduct();
        Thread.sleep(3000);
        productPage.selectAnother();
        productPage.checkCart();
    }

    @Test(priority = 4)
    public void Checkout() {
        ProductPage productPage = new ProductPage(driver);
        productPage.checkout();
    }

    @Test(priority = 5)
    public void checkoutDetails() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterDetails("Lithira", "Fernando", "10350");
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void verify() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.verifyTotal();
    }
}
