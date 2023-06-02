import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class post {
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

        given()
                .baseUri("https://api.github.com/")
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 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")
                .body(requestBody)
                .contentType(ContentType.JSON)
        .when()
                .post("/user/repos")
        .then()
                .statusCode(201)
                .body("name", equalTo("Hello-World"))
                .body("description", equalTo("This is your first repository"));
    }
}
