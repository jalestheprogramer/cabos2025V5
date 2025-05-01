package unitins.tp1.br;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import unitins.tp1.br.dto.PessoaFisicaDTO;
import unitins.tp1.br.dto.PessoaFisicaResponseDTO;
import unitins.tp1.br.service.PessoaFisicaService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class PessoaFisicaResourceTest {
        @Inject
        PessoaFisicaService pessoaFisicaService;

        @Test
        void testbuscarTodosPessoaFisicaService() {
                given()
                                .when()
                                .get("pessoafisica")
                                .then()
                                .statusCode(200);
        }

        @Test
        void testCriarPessoaFisica() {
                PessoaFisicaDTO pessoaFisica = new PessoaFisicaDTO(
                                "janio",
                                "30254478395");

                given()
                                .contentType(ContentType.JSON)
                                .body(pessoaFisica)
                                .when().post("/pessoafisica")
                                .then()
                                .statusCode(201)
                                .body("id", notNullValue())
                                .body("nome", is("janio"))
                                .body("cpf", is("30254478395"));
        }

        @Test
        void testBuscarPorIdPessoaFisica() {

                PessoaFisicaDTO pessoaFisica = new PessoaFisicaDTO(
                                "janio",
                                "30254478395");

                Long id = pessoaFisicaService.create(pessoaFisica).id();

                given()
                                .when()
                                .get("/pessoafisica/" + id)
                                .then()
                                .statusCode(200)
                                .body("id", equalTo(id.intValue()))
                                .body("nome", is("janio"))
                                .body("cpf", is("30254478395"));
        }

        @Test
        void testBuscarPorCpfPessoaFisica() {
            PessoaFisicaDTO pessoaFisica = new PessoaFisicaDTO(
                "janio",
                 "30254478395");
        
            
            given()
                .contentType(ContentType.JSON)
                .body(pessoaFisica)
            .when()
                .post("/pessoafisica")
            .then()
                .statusCode(201); 
        
            
            given()
                .when()
                .get("/pessoafisica/cpf/30254478395")
            .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("nome", is("janio"))
                .body("cpf", is("30254478395"));
        }
        

        @Test
        void testBuscarPorNomePessoaFisica() {
                PessoaFisicaDTO pessoaFisica = new PessoaFisicaDTO(
                                "janio",
                                "30254478395");

                String nome = pessoaFisicaService.create(pessoaFisica).nome();

                given()
                                .when()
                                .get("/pessoafisica/" + nome)
                                .then()
                                .statusCode(200)
                                .body("size()", greaterThan(0))
                                .body("[0].id", notNullValue())
                                .body("[0].nome", equalTo(nome))
                                .body("[0].cpf", is("30254478395"));
        }

        @Test
        void testAtualizarPessoaFisica() {

                PessoaFisicaDTO pessoaFisica = new PessoaFisicaDTO(
                                "janio",
                                "30254478395");

                Long id = pessoaFisicaService.create(pessoaFisica).id();

                PessoaFisicaDTO pessoaFisicaAlterado = new PessoaFisicaDTO(
                                "janio - Alterado",
                                "30254478395");

                given()
                                .contentType(ContentType.JSON)
                                .body(pessoaFisicaAlterado)
                                .when().put("/pessoafisica/" + id)
                                .then()
                                .statusCode(204);

                PessoaFisicaResponseDTO response = pessoaFisicaService.findById(id);
                assertThat(response.nome(), is("janio - Alterado"));
                assertThat(response.cpf(), is("30254478395"));
        }

        @Test
        void testDeletarPessoaFisica() {
                PessoaFisicaDTO pessoaFisica = new PessoaFisicaDTO(
                                "janio",
                                "30254478395");

                Long id = pessoaFisicaService.create(pessoaFisica).id();

                given()
                                .when()
                                .delete("pessoafisica/" + id)
                                .then()
                                .statusCode(204);
        }
}
