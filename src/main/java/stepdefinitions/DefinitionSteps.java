package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
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



    @And("User checks languages panel visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isLanguagePanelVisible();
    }



    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
    }



    @And("User switch to Russian language")
    public void selectLanguage() {
        homePage.selectLanguage();
    }

    @And("User clicks “Generate Lorem Ipsum” button")
    public void clickSearchButton() throws InterruptedException {
        sleep(1500);
        homePage.clickLoremIpsumButton();
    }

    @And("User clicks on checkbox if {string}")
    public void clickCheckBox(String click_condition) throws InterruptedException {
        final boolean b = parseBoolean(click_condition);
        if (b) {
        homePage.clickCheckBox();}
        else {
            return;
        }

    }



    @And("User clicks {string}")
    public void clickButton(String button) throws InterruptedException {
        sleep(1500);
        homePage.clickWords(button);
    }

    @And("User verifies that the first paragraph, contains the word {string}")
    public void checkWordinPara(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(homePage.getWordInPara(expectedAmount), true);
    }

    @And("User checks that text starts with \"Lorem ipsum dolor sit amet, consectetur adipiscing elit\" is {string}")
    public void checkStartsWithString(String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(homePage.startsWithString(LIPSUM), parseBoolean(expectedAmount));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User inputs into the number field {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);

    }

    @And("User verifies that result has {string} words" )
    public void checkAmountOfWords(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(homePage.getAmountOfWords(), expectedAmount);
    }


    @And("User verifies {string}")
    public void checkWords(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals((homePage.getWords(expectedAmount)), 3.0,0.00);
    }
}
