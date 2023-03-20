package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement zipCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
    WebElement price;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[7]")
    WebElement tax;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[8]")
    WebElement TotalAmount;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(id = "back-to-products")
    WebElement backToProductBtn;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterDetails(String first_name, String last_name, String zip) {
        firstName.sendKeys(first_name);
        lastName.sendKeys(last_name);
        zipCode.sendKeys(zip);
        continueButton.click();
    }

    public void verifyTotal() {
        String priceOfProducts = price.getText();
        String[] part1 = priceOfProducts.split("\\$");
        String taxprice = tax.getText();
        String[] part2 = taxprice.split("\\$");
        System.out.println(Arrays.toString(part1));
        System.out.println(Arrays.toString(part2));
        double val1 = Double.parseDouble(part1[1]);
        double val2 = Double.parseDouble(part2[1]);
        double totalPrice = val2 + val1;
        System.out.println(totalPrice);
        String totalAmount = TotalAmount.getText();
        String[] part3 = totalAmount.split("\\$");
        double val3 = Double.parseDouble(part3[1]);
        Assert.assertEquals(totalPrice, val3);
        System.out.println(val3);
        finishBtn.click();
        backToProductBtn.click();
    }
}
