package ApiTest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class LoginTest extends InitTest {

    //endUrlOne = https://test-stand.gb.ru/gateway/login
    @Test
    void postTest1() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Username", getNoValidLogin())
                .formParam("Password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then()
                .statusCode(400);

    }

    @Test
    void postTest2() {
        String mess = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Username", getNoValidLogin())
                .formParam("Password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then().extract()
                .jsonPath()
                .get("message")
                .toString();
        assertThat(mess, equalTo("The key \"username\" must be provided."));

    }

    @Test
    void zpostForFeil() {
        String mess = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Username", getNoValidLogin())
                .formParam("Password", getNoValidPassword())
                .when()
                .post(getEndUrlOne())
                .then().extract()
                .jsonPath()
                .get("message")
                .toString();
        assertThat(mess, equalTo("The key \"username\" must be painted."));

    }
}

