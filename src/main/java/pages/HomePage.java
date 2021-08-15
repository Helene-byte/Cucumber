package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//*[contains(@class, '_3Wo6fpk')]/*[contains(@class,'_6')]/*[contains(@class,'DU')]")
    private WebElement cartIcon;

    @FindBy(xpath = ".//a[contains(@class, 'header-top-bar__input__language')]/span")
    private WebElement languageButton;

    @FindBy(xpath = "//*[contains(@class, '_3i')]/*[contains(@class,'_e')]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[contains(@class, '_3i')]/*[contains(@class,'_2')]")
    private WebElement registerButton;

    @FindBy(xpath = "//*[contains(@class, '_3i')]/*[contains(@class,'_e')]")
    private WebElement signInPopup;

    @FindBy(xpath = "//*[contains(@class, '_3i')]/*[contains(@class,'_e')]/descendant::*[contains(text(),'Sign')]")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@name='password'][contains(@placeholder, '*')]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='gigya-screen-dialog-close']")
    private WebElement signInPopupCloseButton;

    @FindBy(xpath = "//div[@class='header-store parbase']//button//span")
    private WebElement storeButton;

    @FindBy(xpath = "//div[@class='global-store__popup-wrapper']//div[@class='store-search']")
    private WebElement storePopup;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//*[contains(@class, '_36m0W_u')]/descendant::*[contains(@class,'h-7')]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[contains(@class, '_3')]/*[contains(@class,'_6')]/*[contains(@class,'_26')]")
    private WebElement wishListProductsCount;

    @FindBy(xpath = "/descendant::*[contains(@class,'itemCount')]")
    private WebElement wishListProductsCountText;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public String getLanguageButtonText() {
        return languageButton.getText();
    }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }
    public void clickWishList() {
        wishListProductsCount.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void isRegisterButtonVisible() {
        registerButton.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public WebElement getSignInPopup() {
        return signInPopup;
    }

    public void clickSignInPopupCloseButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    }

    public void clickStoreButton() {
        storeButton.click();
    }

    public boolean isStorePopupVisible() {
        return storePopup.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void clickLanguageButton() {
        languageButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getWishListProductsCount() {
        return wishListProductsCount;
    }

    public String getAmountOfProductsInWishList() {
        return wishListProductsCountText.getText();
    }

}
