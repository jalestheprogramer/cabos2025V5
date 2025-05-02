package unitins.tp1.br;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import unitins.tp1.br.dto.UsuarioJuridicoDTO;
import unitins.tp1.br.dto.UsuarioJuridicoResponseDTO;
import unitins.tp1.br.service.UsuarioJuridicoService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest   
public class UsuarioJuridicoResourceTest {
    @Inject
    UsuarioJuridicoService usuarioJuridicoService;

    @Test
    void testBuscarTodosUsuarioJuridico() {
        given()
                .when()
                .get("usuariojuridico")
                .then()
                .statusCode(200);
    }

    @Test
    void testCriarUsuarioJuridico() {
        UsuarioJuridicoDTO usuarioJuridico = new UsuarioJuridicoDTO(
                "havan",
                "64252123000105",
                24242);

        given()
                .contentType(ContentType.JSON)
                .body(usuarioJuridico)
                .when().post("/usuariojuridico")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("nome", is("havan"))
                .body("cnpj", is("64252123000105"))
                .body("numeroParceria", is(24242));
    }

    @Test
    void testBuscarPorIdUsuarioJuridico() {

        UsuarioJuridicoDTO usuarioJuridico = new UsuarioJuridicoDTO(
                "havan",
                "64252123000105",
                24242);

        Long id = usuarioJuridicoService.create(usuarioJuridico).id();

        given()
                .when()
                .get("/usuariojuridico/id/" + id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id.intValue()))
                .body("nome", is("havan"))
                .body("cnpj", is("64252123000105"))
                .body("numeroParceria", is(24242));
    }

    @Test
    void testBuscarPorCnpjUsuarioJuridico() {
        UsuarioJuridicoDTO usuarioJuridico = new UsuarioJuridicoDTO(
                "havan",
                "64252123000105",
                24242);

        String cnpj = usuarioJuridicoService.create(usuarioJuridico).cnpj();
        given()
                .when()
                .get("usuariojuridico/cnpj/" + cnpj)
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("nome", is("havan"))
                .body("cnpj", equalTo(cnpj))
                .body("numeroParceria", is(24242));
    }

        @Test
        void testBuscarPorNomeUsuarioJuridico() {
                UsuarioJuridicoDTO UsuarioJuridico = new UsuarioJuridicoDTO(
                                "havan",
                                "64252123000105",
                                24242);

                String nome = usuarioJuridicoService.create(UsuarioJuridico).nome();

                given()
                                .when()
                                .get("/usuariojuridico/nome/" + nome)
                                .then()
                                .statusCode(200)
                                .body("size()", greaterThan(0))
                                .body("[0].id", notNullValue())
                                .body("[0].nome", equalTo(nome))
                                .body("[0].cnpj", is("64252123000105"))
                                .body("[0].numeroParceria", is(24242));
        }

    @Test
    void testAtualizarUsuarioJuridico() {

        UsuarioJuridicoDTO usuarioJuridico = new UsuarioJuridicoDTO(
                "havan",
                "64252123000105",
                24242);

        Long id = usuarioJuridicoService.create(usuarioJuridico).id();

        UsuarioJuridicoDTO usuarioJuridicoAlterado = new UsuarioJuridicoDTO(
                "havan - Alterado",
                "64252123000105",
                24242);
        given()
                .contentType(ContentType.JSON)
                .body(usuarioJuridicoAlterado)
                .when().put("/usuariojuridico/" + id)
                .then()
                .statusCode(204);

        UsuarioJuridicoResponseDTO response = usuarioJuridicoService.findById(id);
        assertThat(response.nome(), is("havan - Alterado"));
        assertThat(response.cnpj(), is("64252123000105"));
        assertThat(response.numeroParceria(), is(24242));
    }
    
    @Test
    void testDeletarUsuarioJuridico77() {
        UsuarioJuridicoDTO usuarioJuridico = new UsuarioJuridicoDTO(
                "havan",
                "64252123000105",
                24242);

        Long id = usuarioJuridicoService.create(usuarioJuridico).id();

        given()
                .when()
                .delete("usuariojuridico/" + id)
                .then()
                .statusCode(204);
    }
}
