package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "/descendant::span[contains(text(),'Add to bag')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[contains(@id,'miniBag')]//*[contains(@class,'fr')]")
    private WebElement addToCartPopupHeader;

    @FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//*[contains(@class,'_1')]/*[contains(@href,'mini')]/span")
    private WebElement continueToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    public boolean isAddToCartPopupVisible() {
        return addToCartPopupHeader.isDisplayed();
    }

    public void isContinueShoppingButtonVisible() {
        continueShoppingButton.isDisplayed();
    }

    public String getAddToCartPopupHeaderText() {
        return addToCartPopupHeader.getText();
    }

    public void isContinueToCartButtonVisible() {
        continueToCartButton.isDisplayed();
    }

    public void clickContinueToCartButton() {
        continueToCartButton.click();
    }

    public WebElement getAddToCartPopupHeader() {
        return addToCartPopupHeader;
    }
}
