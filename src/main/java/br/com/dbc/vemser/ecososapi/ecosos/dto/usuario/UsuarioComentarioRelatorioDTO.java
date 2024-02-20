package br.com.dbc.vemser.ecososapi.ecosos.dto.usuario;

import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioRelatorioDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioComentarioRelatorioDTO {
    private Integer idUsuario;
    private String nome;
    private String email;
    private List<ComentarioRelatorioDTO> comentarioUsuario = new ArrayList<>();

    public UsuarioComentarioRelatorioDTO(Integer idUsuario, String nome, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
    }
}
