package unitins.tp1.br;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import unitins.tp1.br.dto.FabricanteDTO;
import unitins.tp1.br.dto.FabricanteResponseDTO;
import unitins.tp1.br.service.FabricanteService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class FabricanteResourceTest {
    @Inject
    FabricanteService fabricanteService;

    @Test
    void testbuscarTodosFabricante() {
        given()
                .when()
                .get("fabricantes")
                .then()
                .statusCode(200);
    }

    @Test
    void testCriarFabricante() {
        FabricanteDTO fabricante = new FabricanteDTO(
                "229911",
                "aaaanatel",
                "55555555555555");

        given()
                .contentType(ContentType.JSON)
                .body(fabricante)
                .when().post("/fabricantes")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("cadastroF", is("229911"))
                .body("nome", is("aaaanatel"))
                .body("cnpj", is("55555555555555"));
    }

    @Test
    void testBuscarPorIdFabricante() {
       
        FabricanteDTO fabricante = new FabricanteDTO(
                "2295555",
                "baaanatel",
                "44444444444444");

        Long id = fabricanteService.create(fabricante).id();

        given()
                .when()
                .get("/fabricantes/id/" + id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id.intValue()))
                .body("cadastroF", is("2295555"))
                .body("nome", is("baaanatel"))
                .body("cnpj", is("44444444444444"));
    }

    @Test
    void testBuscarPorNomeFabricante() {
       
        FabricanteDTO fabricante = new FabricanteDTO(
                "2295555",
                "baaanatel",
                "44444444444444");

        String nome = fabricanteService.create(fabricante).nome();
        

        given()
                .when()
                .get("/fabricantes/" + nome)
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("cadastroF", is("2295555"))
                .body("nome", equalTo(nome))
                .body("cnpj", is("44444444444444"));
    }

    @Test
    void testAtualizarFabricante() {

        FabricanteDTO fabricante = new FabricanteDTO(
                "2295555",
                "baaanatel",
                "44444444444444");

        Long id = fabricanteService.create(fabricante).id();

        FabricanteDTO fabricanteAlterado = new FabricanteDTO(
                "2295555",
                "baaanatel - Alterado",
                "55555555555555");

        given()
                .contentType(ContentType.JSON)
                .body(fabricanteAlterado)
                .when().put("/fabricantes/" + id)
                .then()
                .statusCode(204);

        FabricanteResponseDTO response = fabricanteService.findById(id);
        assertThat(response.nome(), is("baaanatel - Alterado"));
        assertThat(response.cadastroF(), is("2295555"));
        assertThat(response.cnpj(), is("55555555555555"));
    }

    @Test
    void testDeletarFabricante() {
        FabricanteDTO fabricante = new FabricanteDTO(
                "229911",
                "aaaanatel",
                "55555555555555");

        Long id = fabricanteService.create(fabricante).id();

        given()
                .when()
                .delete("fabricantes/" + id)
                .then()
                .statusCode(204);
    }
}
