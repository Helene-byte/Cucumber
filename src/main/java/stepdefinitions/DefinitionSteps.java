package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks cart visibility")
    public void checkCartVisibility() {
        homePage.isCartIconVisible();
    }



    @And("User checks register button visibility")
    public void checkRegisterButtonVisibility() {
        homePage.isRegisterButtonVisible();
    }

    @And("User checks sign in dropdown visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @When("User opens 'Sign In' dropdown")
    public void clickSignInButton() {
        homePage.clickRegisterButton();
    }



    @Then("User checks 'Sign In' visibility on 'Sign In' dropdown")
    public void checkEmailVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInPopup());
        assertTrue(homePage.isEmailFieldVisible());

    }

    @And("User closes sign in popup")
    public void closeSignInPopup() {
        homePage.clickSignInPopupCloseButton();
    }

    @And("User opens store popup")
    public void openStorePopup() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickStoreButton();
    }

    @And("User checks that store popup visible")
    public void checkStorePopupVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isStorePopupVisible());
    }

    @And("User opens shopping cart")
    public void openShoppingCart() {
        homePage.clickCartButton();
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
    }

    @When("User clicks language button")
    public void clickLanguageButton() {
        homePage.clickLanguageButton();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
    }

    @And("User checks that shopping cart title visible")
    public void checkShoppingCartTitleVisibility() {
        assertTrue(shoppingCartPage.isShoppingCartTitleVisible());
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() throws InterruptedException {
        sleep(1500);
        homePage.clickSearchButton();
    }

    @And("User clicks 'Add to Cart' button on product")
    public void clickAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart popup visible")
    public void checkAddToCartPopupVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartPopupHeader());
        assertTrue(productPage.isAddToCartPopupVisible());
    }

    @And("User checks 'Continue Shopping' button visibility")
    public void checkContinueShoppingButtonVisibility() {
        productPage.isContinueShoppingButtonVisible();
    }

    @And("User checks 'Continue to Cart' button visibility")
    public void checkContinueToCartButtonVisibility() {
        productPage.isContinueToCartButtonVisible();
    }

    @And("User checks that add to cart popup header is {string}")
    public void checkAddToCartPopupHeader(final String expectedText) {
        assertEquals(productPage.getAddToCartPopupHeaderText(), expectedText);
    }

    @And("User clicks 'Continue to Cart' button")
    public void clickContinueToCartButton() {
        productPage.clickContinueToCartButton();
    }

    @And("User clicks 'Checkout' button")
    public void clickCheckoutButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartItem());
        shoppingCartPage.clickCheckoutButton();
    }

    @And("User checks 'Sign in' screen visibility")
    public void clickPaymentCartButton() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        checkoutPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(checkoutPage.isCompleteOrderButtonVisible());
    }

    @And("User checks payment form visibility")
    public void checkPaymentFormVisibility() {
        assertTrue(checkoutPage.isPaymentFormVisible());
    }

    @And("User checks billing form visibility")
    public void checkBillingFormVisibility() {
        assertTrue(checkoutPage.isBillingFormVisible());
    }

    @And("User checks 'Sign in' screen")
    public void checkCompleteOrderButtonVisibility() {
        assertTrue(checkoutPage.isCompleteOrderButtonVisible());
    }

    @And("User clicks wish list on first product")
    public void clickWishList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickWishListOnFirstProduct();
    }

    @When("User opens Wish List")
    public void clickWishListButton() {
        homePage.clickWishList();
    }

    @And("User checks that amount of products in wish list are {string}")
    public void checkAmountOfProductsInWishList(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getWishListProductsCount());
        assertEquals(homePage.getAmountOfProductsInWishList(), expectedAmount);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
