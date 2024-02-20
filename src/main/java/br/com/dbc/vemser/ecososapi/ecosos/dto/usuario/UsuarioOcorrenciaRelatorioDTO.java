package br.com.dbc.vemser.ecososapi.ecosos.dto.usuario;

import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaRelatorioDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioOcorrenciaRelatorioDTO {
    private Integer idUsuario;
    private String nomeUsuario;
    private String email;
    private List<OcorrenciaRelatorioDTO> ocorrenciasDoUsuario = new ArrayList<>();

    public UsuarioOcorrenciaRelatorioDTO(Integer idUsuario, String nomeUsuario, String email){
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
    }
}
