package br.com.dbc.vemser.ecososapi.ecosos.entity;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoContador {

    @Id
    private TipoRisco tiporisco;

    private Integer quantidade;
}
