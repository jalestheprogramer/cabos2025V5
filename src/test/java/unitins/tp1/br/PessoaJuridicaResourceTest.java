package unitins.tp1.br;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import unitins.tp1.br.dto.PessoaJuridicaDTO;
import unitins.tp1.br.dto.PessoaJuridicaResponseDTO;
import unitins.tp1.br.service.PessoaJuridicaService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class PessoaJuridicaResourceTest {
    @Inject
    PessoaJuridicaService pessoaJuridicaService;

    @Test
    void testBuscarTodosPessoaJuridica() {
        given()
                .when()
                .get("pessoajuridica")
                .then()
                .statusCode(200);
    }

    @Test
    void testCriarPessoaJuridica() {
        PessoaJuridicaDTO pessoaJuridica = new PessoaJuridicaDTO(
                "havan",
                "88888888888888");

        given()
                .contentType(ContentType.JSON)
                .body(pessoaJuridica)
                .when().post("/pessoajuridica")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("nome", is("havan"))
                .body("cnpj", is("88888888888888"));
    }

    @Test
    void testBuscarPorIdPessoaJuridica() {

        PessoaJuridicaDTO pessoaJuridica = new PessoaJuridicaDTO(
                "havan",
                "88888888888888");

        Long id = pessoaJuridicaService.create(pessoaJuridica).id();

        given()
                .when()
                .get("/pessoajuridica/" + id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id.intValue()))
                .body("nome", is("havan"))
                .body("cnpj", is("88888888888888"));
    }

    @Test
    void testBuscarPorCnpjPessoaJuridica() {
        PessoaJuridicaDTO pessoaJuridica = new PessoaJuridicaDTO(
                "havan",
                "88888888888888");

        given()
                .contentType(ContentType.JSON)
                .body(pessoaJuridica)
                .when()
                .post("/pessoajuridica")
                .then()
                .statusCode(201);

        given()
                .when()
                .get("pessoajuridica/cnpj/88888888888888")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("nome", is("havan"))
                .body("cnpj", is("88888888888888"));
    }

        @Test
        void testBuscarPorNomePessoaJuridica() {
                PessoaJuridicaDTO pessoaJuridica = new PessoaJuridicaDTO(
                                "havan",
                                "64252123000105");

                String nome = pessoaJuridicaService.create(pessoaJuridica).nome();

                given()
                                .when()
                                .get("/pessoajuridica/" + nome)
                                .then()
                                .statusCode(200)
                                .body("size()", greaterThan(0))
                                .body("[0].id", notNullValue())
                                .body("[0].nome", equalTo(nome))
                                .body("[0].cnpj", is("64252123000105"));
        }

    @Test
    void testAtualizarPessoaJuridica() {

        PessoaJuridicaDTO pessoaJuridica = new PessoaJuridicaDTO(
                "havan",
                "88888888888888");

        Long id = pessoaJuridicaService.create(pessoaJuridica).id();

        PessoaJuridicaDTO pessoaJuridicaAlterado = new PessoaJuridicaDTO(
                "havan - Alterado",
                "88888888888888");

        given()
                .contentType(ContentType.JSON)
                .body(pessoaJuridicaAlterado)
                .when().put("/pessoajuridica/" + id)
                .then()
                .statusCode(204);

        PessoaJuridicaResponseDTO response = pessoaJuridicaService.findById(id);
        assertThat(response.nome(), is("havan - Alterado"));
        assertThat(response.cnpj(), is("88888888888888"));
    }

    @Test
    void testDeletarPessoaJuridica() {
        PessoaJuridicaDTO pessoaJuridica = new PessoaJuridicaDTO(
                "havan",
                "88888888888888");

        Long id = pessoaJuridicaService.create(pessoaJuridica).id();

        given()
                .when()
                .delete("pessoajuridica/" + id)
                .then()
                .statusCode(204);
    }
}
