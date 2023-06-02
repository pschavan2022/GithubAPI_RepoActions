import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class get_tc {
    @Test
    public void getMethod() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://api.github.com/");
        request.header("Content-type", "application/json");
        request.header("Authorization", "Bearer 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");

        request.contentType(ContentType.JSON);
        Response response = request.get("/users/pschavan2022/repos");
        // Let's print response body.
        String resString = response.asString();
        System.out.println("Response Details : " + resString);
     
        ValidatableResponse valRes = response.then();
        // It will check if status code is 200
        valRes.statusCode(200);
    
    }
}