import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class post_tc {
    @Test
    public void postMethod() {
    	String requestBody = "{"
    	        + "\"name\": \"Hello-World\","
    	        + "\"description\": \"This is your first repository\","
    	        + "\"homepage\": \"https://github.com\","
    	        + "\"private\": false,"
    	        + "\"has_issues\": true,"
    	        + "\"has_projects\": true,"
    	        + "\"has_wiki\": true"
    	        + "}";

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://api.github.com/");
        request.header("Content-type", "application/json");
        request.header("Authorization", "Bearer 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");
        request.body(requestBody);
        request.contentType(ContentType.JSON);
        Response response = request.post("/user/repos");
        // Let's print response body.
        String resString = response.asString();
        System.out.println("Response Details : " + resString);
     
        ValidatableResponse valRes = response.then();
        // It will check if status code is 201
        valRes.statusCode(201);
  
    }
}