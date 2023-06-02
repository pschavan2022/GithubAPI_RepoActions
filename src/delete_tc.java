import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class delete_tc {
    @Test
    public void deleteMethod() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://api.github.com/");
        request.header("Content-type", "application/json");
        request.header("Authorization", "Bearer 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");
        request.contentType(ContentType.JSON);
        Response response = request.delete("repos/pschavan2022/Hello-World");
        // Let's print response body.
        String resString = response.asString();
        System.out.println("Response Details : " + resString+ "Created repository deleted here successfully");
     
        ValidatableResponse valRes = response.then();
        // It will check if status code is 204
        valRes.statusCode(204);
     
    }
}