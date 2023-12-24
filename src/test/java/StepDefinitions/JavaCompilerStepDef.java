package StepDefinitions;

import Repository.JavaCompilerRepo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.Map;

/*
 * Step definition that glues with the features written
 * */
public class JavaCompilerStepDef {

    JavaCompilerRepo jCObj = new JavaCompilerRepo();

    @Given("the user launch the webpage and accept cookies")
    public void the_user_launch_the_webpage() {
        jCObj.launchWebPageAndValidate();
    }

    @When("deleting the existing code")
    public void delete_the_existing_code() {
        jCObj.deleteDefaultContent();
    }

    @When("^add the new java code$")
    public void add_the_new_java_code(DataTable codeTable) {
        for (Map<String, String> data : codeTable.asMaps(String.class, String.class)) {
            jCObj.addNewJavaCode(data.get("Code"));
        }

    }

    @When("click on the execute button")
    public void click_on_the_execute_button() {
        jCObj.clickOnExecuteButtonAndWait();
    }

    @Then("^output should be shown with expected (.+)$")
    public void output_should_be_shown_with_expected_product_of_x_y(String expected) {
        jCObj.verifyExpectedOutput(expected);
    }

    @When("^user change the font size to (.+)$")
    public void user_change_the_font_size_to(String size) {
        jCObj.changeFontSize(size);
    }

    @Then("^the editor should show the font size as (.+)$")
    public void the_editor_should_show_the_font_size_as_selected(String size) {
        jCObj.validateFontSize(size);
    }

    @When("the user clicks on External Libraries")
    public void the_user_clicks_on_external_libraries() {
        jCObj.clickExternalLibrary();
    }

    @When("^add the jar(.+)$")
    public void add_the_org_testng_testng_jar(String libName) {
        jCObj.addLibrary(libName);
    }

    @Then("^Library manager should have the (.+)$")
    public void library_manager_should_have_the_org_testng_testng_jar(String libName) {
        jCObj.validateLibInLibManager(libName);
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
        jCObj.clickOnLoginButton();
    }

    @When("^enter the (.+) and (.+)$")
    public void enter_the_usernameAndPassword(String username, String password) {
        jCObj.enterUsernameAndPassword(username, password);
    }

    @When("click on login button")
    public void click_on_login_button() {
        jCObj.clickOnLoginAfterEnteringDetails();
    }

    @Then("the user should get loggedIn")
    public void the_user_should_get_logged_in() {
        jCObj.validateUserLogin();
    }

    @When("the user hovers over the side panel")
    public void the_user_hovers_over_the_side_panel() {
        jCObj.hoverOverPanel();
    }

    @When("click on the Save As")
    public void click_on_the_save_as() {
        jCObj.clickOnSaveAs();
    }

    @When("^enters the project name as (.+)$")
    public void enters_the_project_name_(String projectName) {
        jCObj.enterProjectName(projectName);
    }

    @When("click on SaveAs button")
    public void click_on_save_as_button() {
        jCObj.clickSaveAsToSaveProject();
    }

    @Then("the project should get saved")
    public void the_project_should_get_saved() {
        jCObj.validateSuccessMessage();
    }

    @When("click on the My Projects")
    public void click_on_the_my_projects() {
        jCObj.clickOnMyProject();
    }

    @When("^Enter the name in search field (.+)$")
    public void enter_the_projectName(String projectName) {
        jCObj.enterProjectNameInSearch(projectName);
    }

    @When("click on Show Results")
    public void click_on_show_results() {
        jCObj.clickShowResults();
    }

    @Then("^user should see the project listed (.+)$")
    public void user_should_see_the_project_listed(String projectName) {
        jCObj.checkProjectListedAfterSearch(projectName);
    }

    @When("^clicking on delete button for the project (.+)$")
    public void clicking_on_delete_button_for_the_project(String projectName) {
        jCObj.deleteProjectAfterSearch(projectName);
    }

    @When("user accepts delete confirmation")
    public void user_accepts_delete_confirmation() {
        jCObj.confirmDeletePressingYes();
    }

    @Then("success message should be shown for deletion")
    public void success_message_should_be_shown_for_deletion() {
        jCObj.validateDeletion();
    }


}
