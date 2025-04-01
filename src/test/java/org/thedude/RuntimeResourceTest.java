package org.thedude;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@QuarkusTest
class RuntimeResourceTest {

    @Test
    void testRuntimeInfo() {
        given()
                .when().get("/api/runtime")
                .then()
                .statusCode(200)
                .body("jdk", notNullValue(),
                        "version", equalTo("24"),
                        "upTime", notNullValue(),
                        "message", notNullValue());
    }
}
