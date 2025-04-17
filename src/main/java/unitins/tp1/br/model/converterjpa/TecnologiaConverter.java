package unitins.tp1.br.model.converterjpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import unitins.tp1.br.model.Tecnologia;

@Converter(autoApply = true)
public class TecnologiaConverter implements AttributeConverter<Tecnologia, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Tecnologia tecnologia) {
        return tecnologia == null ? null : tecnologia.getId();
    }

    @Override
    public Tecnologia convertToEntityAttribute(Integer id){
        return Tecnologia.valueOf(id);
    }


}
