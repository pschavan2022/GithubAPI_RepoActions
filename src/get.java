import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class get {
    @Test
    public void getMethod() {
        given()
                .baseUri("https://api.github.com/")
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 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")
                .contentType(ContentType.JSON)
        .when()
                .get("/users/pschavan2022/repos")
        .then()
                .statusCode(200)
                .extract().response()
                .prettyPrint();
    }
}
