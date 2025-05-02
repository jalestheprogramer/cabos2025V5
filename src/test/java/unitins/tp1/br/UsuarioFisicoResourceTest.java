package unitins.tp1.br;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import unitins.tp1.br.dto.UsuarioFisicoDTO;
import unitins.tp1.br.dto.UsuarioFisicoResponseDTO;
import unitins.tp1.br.service.UsuarioFisicoService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class UsuarioFisicoResourceTest {
        @Inject
        UsuarioFisicoService usuarioFisicoService;

        @Test
        void testBuscarTodosUsuarioFisico() {
                given()
                                .when()
                                .get("usuariofisico")
                                .then()
                                .statusCode(200);
        }

        @Test
        void testCriarUsuarioFisico() {
                UsuarioFisicoDTO usuarioJFisico = new UsuarioFisicoDTO(
                                "jales",
                                "64252123000",
                                true);

                given()
                                .contentType(ContentType.JSON)
                                .body(usuarioJFisico)
                                .when().post("/usuariofisico")
                                .then()
                                .statusCode(201)
                                .body("id", notNullValue())
                                .body("nome", is("jales"))
                                .body("cpf", is("64252123000"))
                                .body("userAdm", is(true));
        }

        @Test
        void testBuscarPorIdUsuarioFisico() {

                UsuarioFisicoDTO usuarioFisico = new UsuarioFisicoDTO(
                                "jales",
                                "64252123000",
                                true);

                Long id = usuarioFisicoService.create(usuarioFisico).id();

                given()
                                .when()
                                .get("/usuariofisico/" + id)
                                .then()
                                .statusCode(200)
                                .body("id", equalTo(id.intValue()))
                                .body("nome", is("jales"))
                                .body("cpf", is("64252123000"))
                                .body("userAdm", is(true));
        }

        @Test
        void testBuscarPorCpfUsuarioFisico() {
                UsuarioFisicoDTO usuarioFisico = new UsuarioFisicoDTO(
                                "jales",
                                "64252123000",
                                true);

                String cpf = usuarioFisicoService.create(usuarioFisico).cpf();
                given()
                                .when()
                                .get("usuariofisico/cpf/" + cpf)
                                .then()
                                .statusCode(200)
                                .body("id", notNullValue())
                                .body("nome", is("jales"))
                                .body("cpf", equalTo(cpf))
                                .body("userAdm", is(true));
        }
        
        @Test
        void testBuscarPorUserAdmUsuarioFisico() {
                UsuarioFisicoDTO UsuarioFisico = new UsuarioFisicoDTO(
                                "jales",
                                "64252123000",
                                true);

                boolean userAdm = usuarioFisicoService.create(UsuarioFisico).userAdm();

                given()
                                .when()
                                .get("/usuariofisico/userAdm/" + userAdm)
                                .then()
                                .statusCode(200)
                                .body("size()", greaterThan(0))
                                .body("[0].id", notNullValue())
                                .body("[0].nome", is("jales"))
                                .body("[0].cpf", is("64252123000"))
                                .body("[0].userAdm", equalTo(userAdm));
        }

        @Test
        void testBuscarPorNomeUsuarioFisico() {
                UsuarioFisicoDTO UsuarioFisico = new UsuarioFisicoDTO(
                                "jales",
                                "64252123000",
                                true);

                String nome = usuarioFisicoService.create(UsuarioFisico).nome();

                given()
                                .when()
                                .get("/usuariofisico/nome/" + nome)
                                .then()
                                .statusCode(200)
                                .body("size()", greaterThan(0))
                                .body("[0].id", notNullValue())
                                .body("[0].nome", equalTo(nome))
                                .body("[0].cpf", is("64252123000"))
                                .body("[0].userAdm", is(true));
        }

        @Test
        void testAtualizarUsuarioFisico() {

                UsuarioFisicoDTO usuarioFisico = new UsuarioFisicoDTO(
                                "jales",
                                "64252123000",
                                true);

                Long id = usuarioFisicoService.create(usuarioFisico).id();

                UsuarioFisicoDTO usuarioFisicoAlterado = new UsuarioFisicoDTO(
                                "jales - Alterado",
                                "64252123000",
                                true);
                given()
                                .contentType(ContentType.JSON)
                                .body(usuarioFisicoAlterado)
                                .when().put("/usuariofisico/" + id)
                                .then()
                                .statusCode(204);

                UsuarioFisicoResponseDTO response = usuarioFisicoService.findById(id);
                assertThat(response.nome(), is("jales - Alterado"));
                assertThat(response.cpf(), is("64252123000"));
                assertThat(response.userAdm(), is(true));
        }

        @Test
        void testDeletarUsuarioFisico77() {
                UsuarioFisicoDTO usuarioFisico = new UsuarioFisicoDTO(
                                "jales",
                                "64252123000",
                                true);

                Long id = usuarioFisicoService.create(usuarioFisico).id();

                given()
                                .when()
                                .delete("usuariofisico/" + id)
                                .then()
                                .statusCode(204);
        }
}
