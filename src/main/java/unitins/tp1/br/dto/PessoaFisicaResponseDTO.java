package unitins.tp1.br.dto;


import unitins.tp1.br.model.PessoaFisica;


public record PessoaFisicaResponseDTO(
    Long id,
    String nome,
    String cpf) {
    
        public static PessoaFisicaResponseDTO valueOf(PessoaFisica pessoaFisica){
            if(pessoaFisica == null)
                return null;
            return new PessoaFisicaResponseDTO(pessoaFisica.getId(), 
            pessoaFisica.getNome(), 
            pessoaFisica.getCpf());
        }
}
