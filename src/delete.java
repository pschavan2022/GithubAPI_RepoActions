import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class delete {
    @Test
    public void postMethod() {

        given()
                .baseUri("https://api.github.com/")
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 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")
                .contentType(ContentType.JSON)
        .when()
                .delete("repos/pschavan2022/Hello-World")
        .then()
                .statusCode(204);

    }
}
