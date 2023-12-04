package Pages;

import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elements;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement forms;


    public void clickElementsPage() {
        elementMethods.clickElement(elements);
        LoggerUtility.infoTest("The user clicks on Elements field");
    }

    public void clickFormsPage() {
        elementMethods.clickElement(forms);
        LoggerUtility.infoTest("The user clicks on Forms field");
    }
}
