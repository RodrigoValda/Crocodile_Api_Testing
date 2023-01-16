package StepDefinitions;

import Entity.UserInformation;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class LoginSteps {
    Response response;
    String URL = "https://test-api.k6.io/auth/basic/login/";
    UserInformation user;

    @Given("The user has to be an account")
    public void theUserHasToBeAnAccount(){
        user = UserInformation.builder().username("RodrigoValda3342").password("76244525").build();
        System.out.println("The user has to be registered in the page");
    }

    @When("The user provide the username and password")
    public void theUserProvideTheUsernameAndPassword(){
        Gson gson = new Gson();
        String body = gson.toJson(user);
        response = RestAssured.given().contentType(ContentType.JSON).body(body).post(URL);
    }

    @Then("The response status code is OK")
    public void theResponseStatusCodeIsOk(){
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
