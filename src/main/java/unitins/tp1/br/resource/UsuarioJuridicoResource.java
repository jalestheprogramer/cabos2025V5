package unitins.tp1.br.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import unitins.tp1.br.dto.UsuarioJuridicoDTO;
import unitins.tp1.br.service.UsuarioJuridicoService;

@Path("usuariojuridico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UsuarioJuridicoResource {

    @Inject
    UsuarioJuridicoService service;

    @GET
    public Response buscarTodos() {
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response buscarPorNome(String nome) {
        return Response.ok().entity(service.findByNome(nome)).build();
    }

    @GET
    @Path("/cnpj/{cnpj}")
    public Response buscarPorCpf(String cnpj) {
        return Response.ok().entity(service.findByCnpj(cnpj)).build();
    }

    @GET
    @Path("/numeroParceria/{numeroParceria}")
    public Response buscarPorNumeroParceria(int numeroParceria) {
        return Response.ok().entity(service.findByNumeroParceria(numeroParceria)).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(Long id) {
        return Response.ok().entity(service.findById(id)).build();
    }

    @POST
    public Response incluir(@Valid UsuarioJuridicoDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, UsuarioJuridicoDTO dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response apagar(Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
