package unitins.tp1.br.dto;


import unitins.tp1.br.model.Fabricante;

public record FabricanteResponseDTO(
    Long id,
    String cadastroF,
    String nome,
    String cnpj
) {

    public static FabricanteResponseDTO valueOf(Fabricante fabricante) {
        if (fabricante == null)
        return null;
    return new FabricanteResponseDTO(fabricante.getId(), fabricante.getCadastroF(), fabricante.getNome(), fabricante.getCnpj());
    }
}
