package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburgerIcon;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    @FindBy(linkText = "Sauce Labs Backpack")
    WebElement productOne;

    @FindBy(linkText = "Sauce Labs Fleece Jacket")
    WebElement productTwo;

    @FindBy(linkText = "Sauce Labs Bolt T-Shirt")
    WebElement productThree;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBtn;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addToCartTwo;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartThree;

    @FindBy(id = "back-to-products")
    WebElement backBtn;

    @FindBy(className = "shopping_cart_link")
    WebElement cart;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeProduct;

    @FindBy(id = "continue-shopping")
    WebElement continueBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Logout() throws InterruptedException {
        hamburgerIcon.click();
        Thread.sleep(Duration.ofMillis(3000));
        logout.click();
    }

    public void select() throws InterruptedException{
        productOne.click();
        addToCartBtn.click();
        Thread.sleep(Duration.ofMillis(3000));
        backBtn.click();
        productTwo.click();
        addToCartTwo.click();
        backBtn.click();
    }

    public void checkCart() {
        cart.click();
    }

    public void RemoveProduct() throws InterruptedException{
        removeProduct.click();
        Thread.sleep(Duration.ofMillis(3000));
        continueBtn.click();
    }

    public void selectAnother() {
        productThree.click();
        addToCartThree.click();
    }

    public void checkout() {
        checkoutBtn.click();
    }

}
