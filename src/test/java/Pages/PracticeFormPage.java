package Pages;

import Logger.LoggerUtility;
import ObjectData.PracticeFormObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) { super(driver); }

    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement email;
//    @FindBy(xpath = "//div[@id='genterWrapper']//div[@class='col-md-9 col-sm-12']//div//input[@value='Male']")
//    private WebElement genderMaleRadioButton;
//    @FindBy(xpath = "//div[@id='genterWrapper']//div[@class='col-md-9 col-sm-12']//div//input[@value='Female']")
//    private WebElement genderFemaleRadioButton;
//    @FindBy(xpath = "//div[@id='genterWrapper']//div[@class='col-md-9 col-sm-12']//div//input[@value='Other']")
//    private WebElement genderOtherRadioButton;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement genderMaleRadioButton;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement genderFemaleRadioButton;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement genderOtherRadioButton;
    @FindBy(id = "userNumber")
    private WebElement mobileNumber;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthField;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement dateOfBirthYearField;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement dateOfBirthMonthField;
    @FindBy(xpath = "//div[@class='react-datepicker__week']/*[not(contains(@class, 'outside-month'))][text()='']")
    private WebElement dateOfBirthDayField;
    @FindBy(id = "subjectsContainer")
    private WebElement subjectField;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement hobbySports;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement hobbyReading;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement hobbyMusic;
    @FindBy(xpath = "//input[@id='uploadPicture']")
    private WebElement chooseFileButton;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddressField;
    @FindBy(id = "state")
    private WebElement stateField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(className = "modal-body")
    private WebElement table;

    public void fillFirstSection(PracticeFormObject practiceFormObject) {
        elementMethods.fillElement(firstName, practiceFormObject.getFirstName());
        LoggerUtility.infoTest("The user fills First Name field with value:" + practiceFormObject.getFirstName());

        elementMethods.fillElement(lastName, practiceFormObject.getLastName());
        LoggerUtility.infoTest("The user fills First Name field with value:" + practiceFormObject.getLastName());

        elementMethods.fillElement(email, practiceFormObject.getEmail());
        LoggerUtility.infoTest("The user fills First Name field with value:" + practiceFormObject.getEmail());

        elementMethods.fillElement(mobileNumber, practiceFormObject.getMobileNumber());
        LoggerUtility.infoTest("The user fills Mobile Number field with value:" + practiceFormObject.getMobileNumber());
    }

    public void completeGender(PracticeFormObject practiceFormObject) {
        switch(practiceFormObject.getGender()) {
            case "Male":
                elementMethods.clickElement(genderMaleRadioButton);
                LoggerUtility.infoTest("The user clicks on gender field " + practiceFormObject.getGender());
                break;
            case "Female":
                elementMethods.clickElement(genderFemaleRadioButton);
                LoggerUtility.infoTest("The user clicks on gender field " + practiceFormObject.getGender());
                break;
            case "Other":
                elementMethods.clickElement(genderOtherRadioButton);
                LoggerUtility.infoTest("The user clicks on gender field " + practiceFormObject.getGender());
                break;
        }
    }

    public void completeDateOfBirth(PracticeFormObject practiceFormObject) {
        elementMethods.clickElement(dateOfBirthField);
        LoggerUtility.infoTest("The user clicks on Date Of Birth field ");

        elementMethods.selectByValue(dateOfBirthYearField, practiceFormObject.getDateOfBirthYear());
        LoggerUtility.infoTest("The user selects year " + practiceFormObject.getDateOfBirthYear());

        elementMethods.selectByText(dateOfBirthMonthField, practiceFormObject.getDateOfBirthMonth());
        LoggerUtility.infoTest("The user selects month " + practiceFormObject.getDateOfBirthMonth());

        WebElement day = driver.findElement(By.xpath("//div[@class='react-datepicker__week']/*[not(contains(@class, 'outside-month'))][text()='" + practiceFormObject.getDateOfBirthDay() + "']"));
        elementMethods.clickElement(day);
        LoggerUtility.infoTest("The user selects day " + practiceFormObject.getDateOfBirthDay());
    }

    public void completeSubject(PracticeFormObject practiceFormObject) {
        elementMethods.fillUsingActions(subjectField, practiceFormObject.getSubject());
        LoggerUtility.infoTest("The user fill Subject field with value " + practiceFormObject.getDateOfBirthDay());
    }

    public void selectHobbies(PracticeFormObject practiceFormObject) {
        for(String hobbiesArray: practiceFormObject.getHobby()) {
            if(hobbiesArray.contains("Sports")) {
                elementMethods.clickElement(hobbySports);
            }
            else if(hobbiesArray.contains("Reading")) {
                elementMethods.clickElement(hobbyReading);
            }
            else if(hobbiesArray.contains("Music")) {
                elementMethods.clickElement(hobbyMusic);
            }

            LoggerUtility.infoTest("The user adds " + practiceFormObject.getHobby() + " hobbies");
        }
    }

    public void uploadPicture() {
        String imagePath = "src/test/resources/poza1.jpg";

        chooseFileButton.sendKeys(imagePath);
        LoggerUtility.infoTest("The user uploads a photo");
    }

    public void enterCurrentAddress(PracticeFormObject practiceFormObject) {
        elementMethods.fillElement(currentAddressField, practiceFormObject.getCurrentAddress());
        LoggerUtility.infoTest("The user fills Current Address field with value: " + practiceFormObject.getCurrentAddress());
    }

    public void selectStateAndCity(PracticeFormObject practiceFormObject) {
        elementMethods.fillUsingActions(stateField, practiceFormObject.getState());
        LoggerUtility.infoTest("The user selects state " + practiceFormObject.getState());

        elementMethods.fillUsingActions(cityField, practiceFormObject.getCity());
        LoggerUtility.infoTest("The user selects city " + practiceFormObject.getCity());
    }

    public void submitForm() {
        submitButton.submit();
        //elementMethods.pressEnter();
        LoggerUtility.infoTest("The user presses submit button");
    }

    public void validateTableContent(PracticeFormObject practiceFormObject) {
        elementMethods.waitVisibleElement(table);

        String tableText = table.getText();

        String fullName = practiceFormObject.getFirstName() + " " + practiceFormObject.getLastName();
        Assert.assertTrue(tableText.contains(fullName));
        LoggerUtility.infoTest("The user validates the presence of " + fullName + " value");

        Assert.assertTrue(tableText.contains(practiceFormObject.getEmail()));
        LoggerUtility.infoTest("The user validates the presence of " + practiceFormObject.getEmail() + " value");

        Assert.assertTrue(tableText.contains(practiceFormObject.getGender()));
        LoggerUtility.infoTest("The user validates the presence of " + practiceFormObject.getGender() + " value");

        Assert.assertTrue(tableText.contains(practiceFormObject.getMobileNumber()));
        LoggerUtility.infoTest("The user validates the presence of " + practiceFormObject.getMobileNumber() + " value");

        String birthDate = practiceFormObject.getDateOfBirthDay() + " " + practiceFormObject.getDateOfBirthMonth() + "," + practiceFormObject.getDateOfBirthYear();
        Assert.assertTrue(tableText.contains(birthDate));
        LoggerUtility.infoTest("The user validates the presence of " + birthDate + " value");

        Assert.assertTrue(tableText.contains(practiceFormObject.getSubject()));
        LoggerUtility.infoTest("The user validates the presence of " + practiceFormObject.getSubject() + " value");

        for(String hobbies: practiceFormObject.getHobby()) {
            Assert.assertTrue(tableText.contains(hobbies));
        }
        LoggerUtility.infoTest("The user validates the presence of " + practiceFormObject.getHobby() + " value");

        Assert.assertTrue(tableText.contains(chooseFileButton.getText()));
        LoggerUtility.infoTest("The user validates the presence of picture");

        Assert.assertTrue(tableText.contains(practiceFormObject.getCurrentAddress()));
        LoggerUtility.infoTest("The user validates the presence of " + practiceFormObject.getCurrentAddress() + " value");

        String stateAndCity = practiceFormObject.getState() + " " + practiceFormObject.getCity();
        Assert.assertTrue(tableText.contains(stateAndCity));
        LoggerUtility.infoTest("The user validates the presence of " + stateAndCity + " value");
    }
}
