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

import unitins.tp1.br.dto.UsuarioFisicoDTO;

import unitins.tp1.br.service.UsuarioFisicoService;

@Path("pessoafisica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UsuarioFisicoResource {

    @Inject
    UsuarioFisicoService service;

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
    @Path("/cpf/{cpf}")
    public Response buscarPorCpf(String cpf) {
        return Response.ok().entity(service.findByCpf(cpf)).build();
    }

    @GET
    @Path("/userAdm/{userAdm}")
    public Response buscarPorUserAdm(Boolean userAdm) {
        return Response.ok().entity(service.findByUserAdm(userAdm)).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(Long id) {
        return Response.ok().entity(service.findById(id)).build();
    }

    @POST
    public Response incluir(@Valid UsuarioFisicoDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, UsuarioFisicoDTO dto) {
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
