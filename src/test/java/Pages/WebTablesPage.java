package Pages;

import Logger.LoggerUtility;
import ObjectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage extends BasePage{
    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addButtonElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitButtonElement;
    @FindBy(xpath = "//div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> tableRowsList;
    @FindBy(xpath = "//span[@title='Edit']")
    private List<WebElement> editButtonsList;
    @FindBy(xpath = "//span[@title='Delete']")
    private List<WebElement> deleteButtonsList;


    public void clickAddButton(WebTableObject webTableObject) {
        webTableObject.setTableSize(tableRowsList.size());
        elementMethods.clickElement(addButtonElement);
        LoggerUtility.infoTest("The user clicks on Add button");
    }

    public void fillRegisterForm(WebTableObject webTableObject) {
        elementMethods.fillElement(firstNameElement, webTableObject.getFirstName());
        LoggerUtility.infoTest("The user fills First Name field with value:" + webTableObject.getFirstName());
        elementMethods.fillElement(lastNameElement, webTableObject.getLastName());
        LoggerUtility.infoTest("The user fills Last Name field with value:" + webTableObject.getLastName());
        elementMethods.fillElement(emailElement, webTableObject.getEmail());
        LoggerUtility.infoTest("The user fills Email field with value:" + webTableObject.getEmail());
        elementMethods.fillElement(ageElement, webTableObject.getAge());
        LoggerUtility.infoTest("The user fills Age field with value:" + webTableObject.getAge());
        elementMethods.fillElement(salaryElement, webTableObject.getSalary());
        LoggerUtility.infoTest("The user fills Salary field with value:" + webTableObject.getSalary());
        elementMethods.fillElement(departmentElement, webTableObject.getDepartment());
        LoggerUtility.infoTest("The user fills Department field with value:" + webTableObject.getDepartment());

        elementMethods.clickElement(submitButtonElement);
        LoggerUtility.infoTest("The user clicks on Submit button");
    }

    public void validateTableSize(WebTableObject webTableObject) {
        Assert.assertEquals(webTableObject.getTableSize() + 1, tableRowsList.size());
        LoggerUtility.infoTest("The user validates the expected table row count with the value:" + tableRowsList.size());
    }

    public void validateTableContent(WebTableObject webTableObject) {
        String rowContent = tableRowsList.get(webTableObject.getTableSize()).getText();

        Assert.assertTrue(rowContent.contains(webTableObject.getFirstName()));
        LoggerUtility.infoTest("The user validates the presence of " + webTableObject.getFirstName() + " value");
        Assert.assertTrue(rowContent.contains(webTableObject.getLastName()));
        LoggerUtility.infoTest("The user validates the presence of " + webTableObject.getLastName() + " value");
        Assert.assertTrue(rowContent.contains(webTableObject.getEmail()));
        LoggerUtility.infoTest("The user validates the presence of " + webTableObject.getEmail() + " value");
        Assert.assertTrue(rowContent.contains(webTableObject.getAge()));
        LoggerUtility.infoTest("The user validates the presence of " + webTableObject.getAge() + " value");
        Assert.assertTrue(rowContent.contains(webTableObject.getSalary()));
        LoggerUtility.infoTest("The user validates the presence of " + webTableObject.getSalary() + " value");
        Assert.assertTrue(rowContent.contains(webTableObject.getDepartment()));
        LoggerUtility.infoTest("The user validates the presence of " + webTableObject.getDepartment() + " value");
    }

    public void modifyNewEntry(WebTableObject webTableObject) {
        editButtonsList.get(webTableObject.getTableSize()).click();
        LoggerUtility.infoTest("The user clicks on Edit button");

        elementMethods.clearElement(firstNameElement);
        elementMethods.fillElement(firstNameElement, webTableObject.getFirstName());
        LoggerUtility.infoTest("The user sets First Name to " + webTableObject.getFirstName());

        elementMethods.clickElement(submitButtonElement);
        LoggerUtility.infoTest("The user clicks on Submit button after it was modified");
    }

    public void deleteNewEntry(WebTableObject webTableObject) {
        deleteButtonsList.get(webTableObject.getTableSize()).click();
        webTableObject.setTableSize(tableRowsList.size());
        LoggerUtility.infoTest("The user clicks on Delete button");
    }

    public void validateTableAfterDelete(WebTableObject webTableObject) {
        Assert.assertEquals(webTableObject.getTableSize(), tableRowsList.size());
        LoggerUtility.infoTest("The user validates the expected table row count with the value:" + tableRowsList.size());
    }
}
