package Steps;

import BaseUtil.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BGP extends Base{

    public Base base;

    public BGP(Base base) {
        this.base = base;
    }

    @Given("^I navigate to BGP$")
    public void iNavigateToBGP() throws Throwable {

        // Login with server authentication
        base.Driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech");

    }

    @Then("^I am on the BGP portal$")
    public void iAmOnTheBGPPortal() throws Throwable {

        // Check if login button is displayed
        WebElement btnLogin = base.Driver.findElement(By.id("login-button"));
        Assert.assertEquals("Login button is not displayed.",btnLogin.isDisplayed(),true);
    }

    @When("^I click on login$")
    public void iClickOnLogin() throws Throwable {

        // Click on login button
        WebElement btnLogin = base.Driver.findElement(By.id("login-button"));
        btnLogin.click();
    }

    @And("^I login as a BGP user$")
    public void iLoginAsABGPUser() throws Throwable {

        // Select user from drop down list
        WebElement ddlUserList = base.Driver.findElement(By.name("SAMLart"));
        Select userList= new Select(ddlUserList);
        userList.selectByValue("S9111111A");

        // Login
        base.Driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("^I am logged in to the portal$")
    public void iAmLoggedInToThePortal() throws Throwable {

        // Verify login status
        WebElement btnLogout = base.Driver.findElement(By.id("logout-button"));
        Assert.assertEquals("Not logged in.",btnLogout.isDisplayed(),true);

    }

    @When("^I click on Get new grant$")
    public void iClickOnGetNewGrant() throws Throwable {

        // Click on Get New Grant
        base.Driver.findElement(By.xpath("//h4[contains(text(),'Get new grant')]")).click();
    }

    @Then("^I should be able to select the sector$")
    public void iShouldBeAbleToSelectTheSector() throws Throwable {

        // Verify on select sector page
        WebElement txtSelectSector = base.Driver.findElement(By.xpath("//h3[contains(text(),'Which sector best describes your business?')]"));
        Assert.assertEquals("Not on select sector page", txtSelectSector.isDisplayed(),true);
    }

    @When("^I select the sector$")
    public void iSelectTheSector() throws Throwable {

        // Click on main sector
        base.Driver.findElement(By.xpath("//div[contains(text(),'Building & Construction')]")).click();

        // Select sub sector
        base.Driver.findElement(By.xpath("//div[@class='itemname'][contains(text(),'Builders (Contractors)')]")).click();

    }

    @Then("^I should be asked for my purpose of applying the grant$")
    public void iShouldBeAskedForMyPurposeOfApplyingTheGrant() throws Throwable {

        // Verify should be asked for purpose
        WebElement txtPurpose = base.Driver.findElement(By.xpath("//h3[contains(text(),'I need this grant to')]"));
        Assert.assertEquals("Not asked for purpose page",txtPurpose.isDisplayed(),true);

    }

    @When("^I select my purpose for applying the grant$")
    public void iSelectMyPurposeForApplyingTheGrant() throws Throwable {

        // Select purpose
        base.Driver.findElement(By.xpath("//div[contains(text(),'Upgrade key business areas')]")).click();

    }

    @Then("^I should be asked for the area to develop with the grant$")
    public void iShouldBeAskedForTheAreaToDevelopWithTheGrant() throws Throwable {

        // Verify on select area to develop page
        WebElement txtAreaToDevelop = base.Driver.findElement(By.xpath("//h3[contains(text(),'Which best describes the area you will develop with this grant?')]"));
        Assert.assertEquals("Not on select area to develop page",txtAreaToDevelop.isDisplayed(),true);

    }

    @When("^I select the area to develop with the grant$")
    public void iSelectTheAreaToDevelopWithTheGrant() throws Throwable {

        // Select area to develop
        base.Driver.findElement(By.xpath("//div[contains(text(),'Pre-Approved Productivity Solutions')]")).click();

    }

    @Then("^I should be able to apply for the grant$")
    public void iShouldBeAbleToApplyForTheGrant() throws Throwable {

        // Verify that Apply button is enabled
        WebElement btnApply = base.Driver.findElement(By.id("go-to-grant"));
        Assert.assertEquals("Apply button is not enabled",btnApply.isEnabled(),true);

        // Click Apply
        btnApply.click();

    }

    @When("^I am on Grant Actions page$")
    public void iAmOnGrantActionsPage() throws Throwable {

        // Verify on Grant Actions page
        WebElement btnProceed = base.Driver.findElement(By.id("keyPage-form-button"));
        Assert.assertEquals("Not able to proceed with application", btnProceed.isDisplayed(),true);

    }

    @Then("^I should be able to proceed with my application$")
    public void iShouldBeAbleToProceedWithMyApplication() throws Throwable {

        // Click Proceed
        base.Driver.findElement(By.id("keyPage-form-button")).click();

    }

    @When("^I am on Check my Eligibility page$")
    public void iAmOnCheckMyEligibilityPage() throws Throwable {

        // Verify on Check Your Eligibility page
        WebElement txtChkEligibleQn = base.Driver.findElement(By.xpath("//label[contains(text(),'Does the applicant meet the eligibility criteria?')]"));
        Assert.assertEquals("No check for eligibility question displayed",txtChkEligibleQn.isDisplayed(),true);
    }

    @Then("^I should see different behaviour based on my answer to the eligibility criteria$")
    public void iShouldSeeDifferentBehaviourBasedOnMyAnswerToTheEligibilityCriteria() throws Throwable {

        // Based on different response to question, should have different behaviour
        WebElement radYes = base.Driver.findElement(By.xpath("//span[contains(text(),'Yes')]"));
        WebElement radNo = base.Driver.findElement(By.xpath("//span[contains(text(),'No')]"));
        WebElement btnNext = base.Driver.findElement(By.id("next-btn"));


        if(radYes.isSelected()==false && radNo.isSelected()==false){

            Assert.assertEquals("Next button is enabled", btnNext.isEnabled()==false, true);

        } else if(radYes.isSelected()==true){

        } else {

        }

    }
}
