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
import unitins.tp1.br.dto.CabosDTO;
import unitins.tp1.br.service.CabosService;

@Path("cabos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CabosResource {

    @Inject
    CabosService service;

    @GET
    public Response buscarTodosC() {
        return Response.ok().entity(service.findAll()).build();
    }

    @POST
    public Response incluirC(@Valid CabosDTO dto) {

        return Response.status(Status.CREATED).entity(service.create(dto)).build();

    }

    @GET
    @Path("/id/{id}")
    public Response buscarPorId(int id) {
        return Response.ok().entity(service.findById(id)).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response buscarPorNome(String nome) {
        return Response.ok().entity(service.findByNome(nome)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(long id, CabosDTO dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response apagar(long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
