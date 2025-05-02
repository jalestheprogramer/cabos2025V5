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
import unitins.tp1.br.dto.PessoaFisicaResponseDTO;
import unitins.tp1.br.dto.PessoaFisicaDTO;
import unitins.tp1.br.service.PessoaFisicaService;

@Path("pessoafisica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PessoaFisicaResource {
    
    @Inject
    PessoaFisicaService service;

    @GET
    public Response buscarTodos() { 
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorNome(@PathParam("nome") String nome) {
        List<PessoaFisicaResponseDTO> dto = service.findByNome(nome);
        return Response.ok(dto).build();
    }

    @GET
    @Path("cpf/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCpf(@PathParam("cpf") String cpf) {
        PessoaFisicaResponseDTO pessoaFisica = service.findByCpf(cpf);
        return Response.ok(pessoaFisica).build();
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
    public Response incluir(@Valid PessoaFisicaDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, PessoaFisicaDTO dto) {
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
