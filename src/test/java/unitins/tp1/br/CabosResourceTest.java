package unitins.tp1.br;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import com.google.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import unitins.tp1.br.service.CabosService;

@QuarkusTest
public class CabosResourceTest {
    @Inject
    CabosService cabosService;

    @Test
    void buscarTodos() {
        given()
            .when()
                .get("/cabos")
            .then()
                .statusCode(200);
    }
}
