package stepDefinitions;

import browser.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DashBoardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import runner.Hooks;
import utilities.Email;

import javax.mail.*;

public class UserRegistration extends Hooks {

    Email emailUtils = null;
    HomePage homeObject;
    LoginPage loginObject;
    DashBoardPage dashBoardObject;
    UserRegistrationPage userRegistrationObject;

    static Faker fakeData = new Faker();
    static String firstName = fakeData.name().firstName();
    static String lastName = fakeData.name().lastName();
    static String mobileNumber = "010"+fakeData.number().digits(8).toString();
    static String email = fakeData.internet().emailAddress();
    static String password = fakeData.regexify("[A-Za-z]{4}[$&+,:;=?@#|'<>.-^*()%!]{2}[0-9]{4}");
//    static String password = fakeData.letterify("ABCDEF123456789abcdef");

    @Given("I am on home page")
    public void iAmOnHomePage() {

    }

    @When("I click on Sign Up")
    public void iClickOnRegister() {
        homeObject = new HomePage(Driver.driver);
        homeObject.openRegistrationPage();
        Assert.assertTrue(Driver.driver.getCurrentUrl().contains("register"));
    }
    @When("I click on login")
    public void iClickOnLogin() {
        homeObject = new HomePage(Driver.driver);
        homeObject.openLoginPage();
        Assert.assertTrue(Driver.driver.getCurrentUrl().contains("login"));
    }

    @And("I logout")
    public void iLogout() {
        dashBoardObject = new DashBoardPage(Driver.driver);
        dashBoardObject.logOut();
    }

    @And("I have entered user login data")
    public void iHaveEnteredUserLoginData() {
        loginObject = new LoginPage(Driver.driver);
        loginObject.userLogin(email,password);
    }


    @Then("The user has been logged in successfully")
    public void theUserHasBeenRegisteredSuccessfully() {
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Hi, "+firstName+" "+lastName));
    }

    @And("I have entered user registration data")
    public void iEnteredRegistrationData() throws InterruptedException {
        userRegistrationObject = new UserRegistrationPage(Driver.driver);
        userRegistrationObject.userRegistration(firstName,lastName,mobileNumber,email,password,password);
        System.out.println("The First Name: " + firstName);
        System.out.println("The Last Name: " +lastName);
        System.out.println("The Mobile Number: " + mobileNumber);
        System.out.println("The Email: " +email);
        System.out.println("The Password: "+ password);

    }

    @And("I have entered {string} into {string}")
    public void iHaveEnteredInto(String text, WebElement element) {
    }
    @When("I connect to email {string} with password {string}")
    public void iConnectToEmalWithPassword(String email, String password) {
        try {
            emailUtils = new Email(email, password, "smtp.gmail.com", Email.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Then("I should receive message with subject {string}")
    public void iShouldReceiveMessageWithSubject(String messageSubject) {
        try{
            Message email = emailUtils.getMessagesBySubject(messageSubject, false, 5)[0];
            String content= emailUtils.getMessageContent(email);
            Assert.assertTrue(content.contains("Thanks for signup details are as follows :"));
            //TODO: continue testing
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}