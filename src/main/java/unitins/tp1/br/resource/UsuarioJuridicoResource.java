package unitins.tp1.br.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import unitins.tp1.br.dto.UsuarioJuridicoDTO;
import unitins.tp1.br.dto.UsuarioJuridicoResponseDTO;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorNome(@PathParam("nome") String nome) {
        List<UsuarioJuridicoResponseDTO> dto = service.findByNome(nome);
        if (dto == null || dto.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(dto).build();
    }

    @GET
    @Path("/cnpj/{cnpj}")
    public Response buscarPorCpf(@PathParam("cnpj") String cnpj) {
        return Response.ok().entity(service.findByCnpj(cnpj)).build();
    }

    @GET
    @Path("/numeroParceria/{numeroParceria}")
    public Response buscarPorNumeroParceria(int numeroParceria) {
        return Response.ok().entity(service.findByNumeroParceria(numeroParceria)).build();
    }

    @GET
    @Path("/id/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
       var dto = service.findById(id);
        if (dto == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(dto, MediaType.APPLICATION_JSON).build();
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
