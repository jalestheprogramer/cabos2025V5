package unitins.tp1.br;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import unitins.tp1.br.dto.CabosDTO;
import unitins.tp1.br.dto.CabosResponseDTO;
import unitins.tp1.br.service.CabosService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class CabosResourceTest {
    @Inject
    CabosService cabosService;

    @Test
    void testbuscarTodos() {
        given()
                .when()
                .get("cabos")
                .then()
                .statusCode(200);
    }

    @Test
    void testCriarCabo() {
        CabosDTO cabos = new CabosDTO(
                "cabo",
                1L,
                2,
                1);

        given()
                .contentType(ContentType.JSON)
                .body(cabos)
                .when().post("/cabos")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("nome", is("cabo"))
                .body("fabricante.id", is(1))
                .body("fabricante.nome", is("intel"))
                .body("fabricante.cnpj", is("11111111111111"));
    }

    @Test
    void testBuscarPorId() {
        // Criar cabo primeiro
        CabosDTO cabos = new CabosDTO(
                "Cabo HDMI",
                1L,
                2,
                1);

        Long id = cabosService.create(cabos).id();

        given()
                .when()
                .get("/cabos/" + id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id.intValue()))
                .body("nome", is("Cabo HDMI"));
    }

    @Test
    void testAtualizarCabo() {
        CabosDTO cabos = new CabosDTO(
                "cabo",
                1L,
                2,
                1);

        long id = cabosService.create(cabos).id();

        CabosDTO cabosAlterado = new CabosDTO(
                "cabo - Alterado",
                1L,
                1,
                1);

        given()
                .contentType(ContentType.JSON)
                .body(cabosAlterado)
                .when().put("/cabos/" + id)
                .then()
                .statusCode(204);

        CabosResponseDTO response = cabosService.findById(id);
        assertThat(response.nome(), is("cabo - Alterado"));
        assertThat(response.fabricante().id(), is(1L));
        assertThat(response.tecnologia().getTecnologia(), is("Cat-5"));
        assertThat(response.tamanho().getTAMANHO(), is("10M"));
    }

    @Test
    void testDeletarCabo() {
        given()
                .when()
                .delete("cabos/1")
                .then()
                .statusCode(204);
    }
}
