package Tests;

import ObjectData.WebTableObject;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.WebTablesPage;
import ReportUtility.ExtentUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.Hooks;

public class WebTableTest extends Hooks {

    @Test
    public void metodaLoginTest(){
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsPage();
        ExtentUtility.attachTestLog("pass","I make a click on Elements");

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickElementsPage();
        ExtentUtility.attachTestLog("pass","I make a click on Web Element Table");

        WebTablesPage webTablesPage = new WebTablesPage(getDriver());
        webTablesPage.clickAddButton(webTableObject);
        ExtentUtility.attachTestLog("pass","I make a click on Add button");

        webTablesPage.fillRegisterForm(webTableObject);
        ExtentUtility.attachTestLog("pass","I fill the form then click Submit");

        webTablesPage.validateTableSize(webTableObject);
        ExtentUtility.attachTestLog("pass","I validate table size");

        webTablesPage.validateTableContent(webTableObject);
        ExtentUtility.attachTestLog("pass","I validate table content");

        webTableObject.setFirstName("Mandarin");
        webTablesPage.modifyNewEntry(webTableObject);
        ExtentUtility.attachTestLog("pass","I validate the First Name has been changed");
        webTablesPage.validateTableContent(webTableObject);
        ExtentUtility.attachTestLog("pass","I validate table content");

        webTablesPage.deleteNewEntry(webTableObject);
        ExtentUtility.attachTestLog("pass","I validate last entry was deleted");
        webTablesPage.validateTableAfterDelete(webTableObject);
        ExtentUtility.attachTestLog("pass","I validate table size after deletion");
    }
}
