package br.com.dbc.vemser.ecososapi.ecosos.repository;

import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioRelatorioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaRelatorioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioComentarioRelatorioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioOcorrenciaRelatorioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String login);


    Usuario findByTelefoneEquals(String telefone);

    Usuario findByEmailEquals(String email);

    List<Usuario> findByStatus(String status);

    @Query(
            """
                    SELECT new br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioComentarioRelatorioDTO(
                        u.idUsuario,  u.nome,  u.email)  
                    FROM USUARIO u
                    WHERE (:idUsuario IS NULL OR u.idUsuario = :idUsuario)
                    """
    )
    List<UsuarioComentarioRelatorioDTO> procurarPessoaComentarios(@Param("idUsuario") Integer idUsuario);

    @Query("""
            SELECT new br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioRelatorioDTO(
              c.conteudo) 
            FROM USUARIO u 
            JOIN u.comentarios c 
            WHERE u.idUsuario = :idUsuario """)
    List<ComentarioRelatorioDTO> procurarComentarios(@Param("idUsuario") Integer idUsuario);

    @Query(
            """
                    SELECT new br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioOcorrenciaRelatorioDTO(
                        u.idUsuario,  u.nome,  u.email)  
                    FROM USUARIO u
                    WHERE (:idUsuario IS NULL OR u.idUsuario = :idUsuario)
                    """
    )
    List<UsuarioOcorrenciaRelatorioDTO> procurarPessoaOcorrencias(@Param("idUsuario") Integer idUsuario);

    @Query("""
            SELECT new br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaRelatorioDTO(
              o.nome, o.tipo, o.gravidade) 
            FROM USUARIO u 
            JOIN u.ocorrencias o 
            WHERE u.idUsuario = :idUsuario """)
    List<OcorrenciaRelatorioDTO> procurarOcorrencias(@Param("idUsuario") Integer idUsuario);

    Page<Usuario> findAll(Pageable pageable);
}