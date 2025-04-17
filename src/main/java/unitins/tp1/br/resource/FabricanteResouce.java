package unitins.tp1.br.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
import unitins.tp1.br.dto.FabricanteDTO;
import unitins.tp1.br.service.FabricanteService;

@Path("fabricantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FabricanteResouce {

    @Inject
    FabricanteService service;

    @GET
    public Response buscarTodosF() {
        return Response.status(Status.OK).entity(service.findAll()).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response buscarPorNomeF(String nome) {
        return Response.ok().entity(service.findByNome(nome)).build();
    }

    @POST
    public Response incluir(FabricanteDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, FabricanteDTO dto) {
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
