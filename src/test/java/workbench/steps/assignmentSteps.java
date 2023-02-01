package workbench.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import workbench.pages.assignmentPage;
import runners.CucumberRunner;

import java.awt.*;

public class assignmentSteps {

    assignmentPage assignment = new assignmentPage();
    CucumberRunner c = new CucumberRunner();

    @Given("^I am on page \"([^\"]*)\"$")
    public void i_am_on_page(String url) throws Throwable {
        c.setEnv(url);
    }

//    @Then("I verify the blank image in slide bar")
//    public void iVerifyTheBlankImageInSlideBar() {
//        myCarAuction.verifyBlankImage();
//    }

    @And("user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEnterAnd(String name, String pass) {
        assignment.enterCredentials(name,pass);
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        assignment.clickLoginBtn();
    }
    @And("user click on add product")
    public void userClickOnAdProduct() throws InterruptedException {
        assignment.clickAddProduct();
    }
    @And("user click on \"([^\"]*)\" type")
    public void userClickOnType(String value) {
        assignment.clickAuctionType(value);
    }
    @And("user click on next step button \"([^\"]*)\"$")
    public void userClickOnNextStepButton(int number) {
        assignment.clickNextStepButton(number);
    }
    @And("user enters the required fields")
    public void userEntersTheRequiredFields() {
        assignment.enterRequiredFields();
    }
    @And("user enters the auction \"([^\"]*)\"$")
    public void userEntersTheAuction(String value) {
        assignment.enterAuctionDetail(value);
    }
    @And("user enters the policy \"([^\"]*)\"$")
    public void userEntersThePolicy(String value) throws InterruptedException {
        assignment.enterPolicyDetail(value);
    }
    @And("user upload main image")
    public void userUploadMainImage() throws AWTException, InterruptedException {
        assignment.uploadImage();
    }

    @And("user enter buy now value")
    public void userEnterBuyNowValue() throws InterruptedException {
    assignment.enterBuNowVale();
    }

    @And("user enter start bid value")
    public void userEnterStartBidValue() {
        assignment.enterStartBidValue();
    }

    @And("user enter increase bid")
    public void userEnterIncreaseBid() {
        assignment.enterIncreaseBid();
    }

    @And("user enter date")
    public void userEnterDate() throws InterruptedException {
        assignment.enterDate();
    }

    @And("user enter time")
    public void userEnterTime() throws InterruptedException {
        assignment.enterTime();
    }

    @And("user enter the auction show type")
    public void userEnterTheAuctionShowType() {
        assignment.auctionShowType();
    }
}
