package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[contains(@id,'Outer')]//*[contains(@id,'Languages')]")
    private WebElement languagePanel;

    @FindBy(xpath = "//*[contains(@id,'Outer')]//*[contains(@id,'Languages')]//*[contains(@href,'ru')]")
    private WebElement languageSelection;

    @FindBy(xpath = "//*[contains(@id,'generate')]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[contains(@id,'start')]")
    private WebElement checkBox;

    @FindBy(xpath = "//*[contains(@id,'words')]")
    private WebElement wordsRadioButton;

    @FindBy(xpath = "//*[contains(@id,'Content')]//*[contains(@id,'Panes')]//p")
    private List<WebElement> panesToCheck;

    @FindBy(xpath = "//*[contains(@id,'Content')]")
    private WebElement paraToCheck;

    @FindBy(xpath = "//*[contains(@id,'lipsum')/p]")
    private List<WebElement> paragraphsToCheck;

    @FindBy(xpath = "//*[contains(@id,'amount')]")
    private WebElement searchField;


    @FindBy(xpath = "//*[contains(@id,'lipsum')]/p")
    private WebElement wordsList;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }


    public void isLanguagePanelVisible() {
        languagePanel.isDisplayed();
    }

    public void selectLanguage() {
        languageSelection.click();
    }

    public void clickSearchButton() {
        languageSelection.click();
    }

    public void clickLoremIpsumButton() {
        searchButton.click();
    }

    public void clickCheckBox() {
        checkBox.click();
    }

    public void clickWords(String button) {
        driver.findElement(By.xpath("//*[contains(@id,'" + button + "')]")).click();
    }

    public boolean getWordInPara(String expectedAmount) {
        String str = (panesToCheck.get(0)).getText();
        int indexR = str.indexOf(expectedAmount);
        if (indexR == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean startsWithString(String expectedAmount) {
        String str = paraToCheck.getText();
        if (str.startsWith(expectedAmount)) {
            return true;
        } else {
            return false;
        }
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }


    public String getAmountOfWords() {
        Scanner in = new Scanner(wordsList.getText());
        int count = (int) Pattern.compile("\\W+")
                .splitAsStream(in.nextLine())
                .count();
        return String.valueOf(count);
    }

    public double getWords(String expectedAmount) {
        final String PARAGRAPH_SPLIT_REGEX = "\n\n";
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            searchButton.click();
            String str = paraToCheck.getText();
            String[] paragraphs = str.split(PARAGRAPH_SPLIT_REGEX);
            for (String paragraph : paragraphs) {
                int indexR = str.indexOf(expectedAmount);
                if (indexR == -1) {
                    return 0;
                } else {
                    count++;
                }
                return IntStream.of(new int[]{count}).average().getAsDouble();
            }
            return 0;
        }
        return 0;
    }
}