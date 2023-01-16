import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class logout {
    @Test
    public void testLoginPostMethod(){
        Response response = RestAssured.given().contentType(ContentType.JSON).body("" +
                        "{\n" +
                        "   \"username\": \"RodrigoValda3342\",\n" +
                        "   \"password\": \"76244525\"\n" +
                        "}")
                .options("https://test-api.k6.io/auth/cookie/logout/").then()
                .extract().response();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
