package unitins.tp1.br.dto;

import unitins.tp1.br.model.Cabos;
import unitins.tp1.br.model.Tamanho;
import unitins.tp1.br.model.Tecnologia;

public record CabosResponseDTO(
    Long id,
    String nome,
    Tecnologia tecnologia,
    Tamanho tamanho,
    FabricanteResponseDTO fabricante
    ) {
    
        public static CabosResponseDTO valueOf(Cabos cabos){
            if(cabos == null)
                return null;
            return new CabosResponseDTO(cabos.getId(), cabos.getNome(), cabos.getTecnologia(), cabos.getTamanho(), FabricanteResponseDTO.valueOf(cabos.getFabricante()));
        }
}
