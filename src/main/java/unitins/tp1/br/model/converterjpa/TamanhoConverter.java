package unitins.tp1.br.model.converterjpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import unitins.tp1.br.model.Tamanho;

@Converter(autoApply = true)
public class TamanhoConverter implements AttributeConverter<Tamanho, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Tamanho tamanho) {
        return tamanho == null ? null : tamanho.getId();
    }

    @Override
    public Tamanho convertToEntityAttribute(Integer id){
        return Tamanho.valueOf(id);
    }


}
