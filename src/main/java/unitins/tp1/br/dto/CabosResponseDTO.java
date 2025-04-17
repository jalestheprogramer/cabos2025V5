package unitins.tp1.br.dto;

import unitins.tp1.br.model.Cabos;
import unitins.tp1.br.model.Tecnologia;

public record CabosResponseDTO(
    Long id,
    String nome,
    Tecnologia tecnologia,
    FabricanteResponseDTO fabricante) {
    
        public static CabosResponseDTO valueOf(Cabos cabos){
            if(cabos == null)
                return null;
            return new CabosResponseDTO(cabos.getId(), cabos.getNome(), cabos.getTecnologia(), FabricanteResponseDTO.valueOf(cabos.getFabricante()));
        }
}
