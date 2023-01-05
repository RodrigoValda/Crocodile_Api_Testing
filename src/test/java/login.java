import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login {

    /*GET Method is not allowed, the request should display 405 status code*/
    @Test
    public void testLoginGetMethod(){
        Response response = RestAssured.get("https://test-api.k6.io/auth/basic/login/");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,405);
    }

    @Test
    public void testLoginPostMethod(){
        Response response = RestAssured.given().contentType(ContentType.JSON).body("" +
                "{\n" +
                "   \"username\": \"RodrigoValda3342\",\n" +
                "   \"password\": \"76244525\"\n" +
                "}")
                .post("https://test-api.k6.io/auth/basic/login/").then()
                .extract().response();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println(statusCode);
        System.out.println(response.asString());
    }

    @Test
    public void testLoginOptionsMethod(){
        Response response = RestAssured.given().contentType(ContentType.JSON).body("" +
                        "{\n" +
                        "   \"username\": \"RodrigoValda3342\",\n" +
                        "   \"password\": \"76244525\"\n" +
                        "}")
                .options("https://test-api.k6.io/auth/basic/login/").then()
                .extract().response();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println(statusCode);
        System.out.println(response.asString());
    }
}
