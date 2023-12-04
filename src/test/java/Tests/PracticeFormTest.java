package Tests;

import ObjectData.PracticeFormObject;
import ObjectData.WebTableObject;
import Pages.FormsPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import ReportUtility.ExtentUtility;
import org.testng.annotations.Test;
import sharedData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
    public void practiceFormTest() {
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsPage();
        ExtentUtility.attachTestLog("pass","I make a click on Forms page");

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeForm();
        ExtentUtility.attachTestLog("pass","I make a click on Practice Form");

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillFirstSection(practiceFormObject);
        ExtentUtility.attachTestLog("pass","I fill first First Name, Last Name, Email and Mobile Number");

        practiceFormPage.completeGender(practiceFormObject);
        ExtentUtility.attachTestLog("pass","I select Gender");

        practiceFormPage.completeDateOfBirth(practiceFormObject);
        ExtentUtility.attachTestLog("pass","I select Date Of Birth");

        practiceFormPage.selectHobbies(practiceFormObject);
        ExtentUtility.attachTestLog("pass","I select hobbies");

//        practiceFormPage.completeSubjectField(practiceFormObject);
//        ExtentUtility.attachTestLog("pass","I select Subject");
    }
}
