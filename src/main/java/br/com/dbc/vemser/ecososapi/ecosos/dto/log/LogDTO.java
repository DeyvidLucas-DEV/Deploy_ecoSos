package br.com.dbc.vemser.ecososapi.ecosos.dto.log;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoUserLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {

    private String id;
    @Enumerated(EnumType.STRING)
    @Field("tipolog")
    private TipoUserLog tipoLog;
    private String descricao;
    private String data;
}