package Repository;

import GeneralFunctions.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class JavaCompilerRepo extends BasePage {

    By login = By.xpath("(//button//*[contains(text(),'Login')])[1]");
    By acceptCookies = By.xpath("//button[text()=' Got it! ']");

    By defaultContent = By.cssSelector("#code .ace_content");

    By textArea = By.xpath("//div[@id='code']/textarea");

    By executeButton = By.xpath("//button[contains(text(),'Execute')]");

    By stopExecution = By.xpath("//button[contains(text(),'Stop Execution')]");
    By jDoodleInAction = By.xpath("//div[text()='JDoodle in Action.... Running the program...']");

    public By outputString(String value) {
        return By.xpath("//div[contains(text(),\"" + value + "\")]");
    }

    By fontSize = By.xpath("(//Select[@id='fontSizeSelect'])[1]");

    By editorScroll = By.xpath("(//div[@class='ace_scroller'])[1]");

    By externalLibraries = By.xpath("(//button[contains(text(),'External Libraries')])[2]");

    By libInputField = By.xpath("(//*[text()='Add Jar from Maven Library'])[2]/following-sibling::div/input");

    By addLibraryButton = By.xpath("(//button[contains(text(),'Add Library')])[2]");

    By libManager = By.xpath("(//h6[text()='Library Manager'])[2]/..//p");

    By username = By.xpath("(//input[contains(@id,'Email')])[1]");

    By password = By.xpath("(//input[contains(@id,'login_pwd')])[1]");

    By loginButton = By.xpath("//button[@class='btn-primary btn-rounded-md mt-6 text-base']");

    By dashboard = By.xpath("(//span[text()='Dashboard'])[1]");

    By sidePanel = By.xpath("(//div[contains(@class,' overflow-visible')])[2]");

    By saveAs = By.xpath("(//span[contains(text(),'Save')])[1]");

    By projectNameInput = By.xpath("(//input[@id='Project NameProject Name'])[1]");

    By saveAsSubmit = By.xpath("(//*[contains(text(),'Project Name')])[1]/../../..//*[@type='submit']");

    By successMessagePro = By.xpath("//p[text()='New Project Saved Successfully']");

    By myProjects = By.xpath("//*[text()='My Projects']");

    By searchField = By.xpath("//input[@placeholder='Search Files']");

    By showResults = By.xpath("(//button[contains(text(),' Show results ') and contains(@class,'btn-primary')])[1]");

    public By projectNameInSearch(String projectName) {
        return By.xpath("//p[text()='" + projectName + "']");
    }

    public By deleteProject(String projectName) {
        return By.xpath("//p[text()='" + projectName + "']/../div/button[2]");
    }

    By confirmDelete = By.xpath("//button[@data-hs-overlay='#hs-confirm' and text()='Yes']");

    By deleteMessage = By.xpath("//p[text()='Project Deleted Successfully']");

    /**
     * To launch web page, validate whether login button is available and accept cookies
     */
    public void launchWebPageAndValidate() {
        launchWebPage();
        waitForElement(login);
        getElement(acceptCookies).click();
    }

    /**
     * To click on default content and delete the existing content using key strokes
     */
    public void deleteDefaultContent() {
        getElement(defaultContent).click();
        useActionsToPressBackSpace(200);

    }

    /**
     * Trim the code to remove double quotes received and send the code to editor text aread
     * @param javaCode Code to be added in the editor
     */
    public void addNewJavaCode(String javaCode) {
        javaCode = trimQuotes(javaCode);
        getElement(textArea).sendKeys(javaCode);
    }

    /**
     * Scroll to execute button to make it visible
     * Click on execute button and wait for Stop execution and execution in progress
     */
    public void clickOnExecuteButtonAndWait() {
        scrollToElementJS(executeButton);
        getElement(executeButton).click();
        waitForElement(stopExecution);
        waitForElement(jDoodleInAction);

    }

    /**
     * wait for the expected output
     * @param expectedOutput Expected output as per the execution
     */
    public void verifyExpectedOutput(String expectedOutput) {
        waitForElement(outputString(expectedOutput));
    }

    /**
     * Wait for element to be visible
     * Select the required font size
     * @param size Font size to be set
     */
    public void changeFontSize(String size) {
        waitForElement(fontSize);
        Select sizeDropDown = new Select(getElement(fontSize));
        sizeDropDown.selectByValue(size);
    }

    /**
     * Fetch the actual font size and validate it against expected
     * @param size Expected font size
     */
    public void validateFontSize(String size) {
        String actualSize = getElement(editorScroll).getCssValue("font-size");
        if (!actualSize.equalsIgnoreCase(size + "px")) {
            Assert.fail("Font size didnt change as expected");
        }
    }

    /**
     * Click on external library
     */
    public void clickExternalLibrary() {
        getElement(externalLibraries).click();
    }

    /**
     * Scroll to external libraries
     * Send library name and click on add library button
     * @param libName Name of library to be added
     */
    public void addLibrary(String libName) {
        scrollToElementJS(externalLibraries);
        getElement(libInputField).sendKeys(libName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getElement(addLibraryButton).click();
    }

    /**
     * Get the library name from library manager and validate it against expected
     * @param libName Library to be added
     */
    public void validateLibInLibManager(String libName) {
        String libContents = getElement(libManager).getText();

        if (!libContents.contains(libName)) {
            Assert.fail("Library is not added as expected");
        }
    }

    /**
     * Click on login button
     */
    public void clickOnLoginButton() {
        getElement(login).click();
    }

    /**
     * Enter the username and password
     * @param usernameStr Username of the user
     * @param passwordStr Password of the user
     */
    public void enterUsernameAndPassword(String usernameStr, String passwordStr) {
        getElement(username).sendKeys(usernameStr);
        getElement(password).sendKeys(passwordStr);
    }

    /**
     * Click on submit after entering username and password
     */
    public void clickOnLoginAfterEnteringDetails() {
        getElement(loginButton).click();
    }

    /**
     * Wait for the dashbaord element to be present and confirm login
     */
    public void validateUserLogin() {
        waitForElement(dashboard);
    }

    /**
     * Hover over the side panel
     */
    public void hoverOverPanel() {
        waitForElement(sidePanel);
        hoverOverElement(sidePanel);
    }

    /**
     * Wait for element Save As to be visible
     * Hover over it and click on it
     */
    public void clickOnSaveAs() {
        waitForElement(saveAs);
        hoverOverElement(saveAs);
        getElement(saveAs).click();
    }

    /**
     * Enter project name
     * @param projectName Name to be given for the project while saving it
     */
    public void enterProjectName(String projectName) {
        getElement(projectNameInput).sendKeys(projectName);

    }

    /**
     * Click on submit button to save project
     */
    public void clickSaveAsToSaveProject() {
        getElement(saveAsSubmit).click();
    }

    /**
     * Wait for success message shown after saving project
     */
    public void validateSuccessMessage() {
        waitForElement(successMessagePro);
    }

    /**
     * Wait for element My projects
     * Hover over it and click on the element
     */
    public void clickOnMyProject() {
        waitForElement(myProjects);
        hoverOverElement(myProjects);
        getElement(myProjects).click();
    }

    /**
     * Enter the project name in search field
     * @param projectName Project name to be entered for search
     */
    public void enterProjectNameInSearch(String projectName) {
        getElement(searchField).sendKeys(projectName);
    }

    /**
     * Click on show results
     */
    public void clickShowResults() {
        getElement(showResults).click();
    }

    /**
     * Wait for project to be shown after search
     * @param projectName Project name to be shown after search
     */
    public void checkProjectListedAfterSearch(String projectName) {
        waitForElement(projectNameInSearch(projectName));
    }

    /**
     * Click on delete button against the project name
     * @param projectName To be deleted
     */
    public void deleteProjectAfterSearch(String projectName) {
        getElement(deleteProject(projectName)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Click on Yes while asking for project deletion
     */
    public void confirmDeletePressingYes() {
        getElement(confirmDelete).click();
    }

    /**
     * Validate success message after deletion
     */
    public void validateDeletion() {
        waitForElement(deleteMessage);
    }
}
