package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'empty-bag')]/descendant::*[contains(text(),'Your bag is empty')]")
    private WebElement shoppingCartTitle;

    @FindBy(xpath = "//*[contains(@class,'--main')]//*[contains(@class,'total-button')]/*")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[contains(@class,'--main')]//*[contains(@class,'total-button')]/*")
    private WebElement shoppingCartItem;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingCartTitle() {
        return shoppingCartTitle;
    }

    public boolean isShoppingCartTitleVisible() {
        return shoppingCartTitle.isDisplayed();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public WebElement getShoppingCartItem() {
        return shoppingCartItem;
    }

}
