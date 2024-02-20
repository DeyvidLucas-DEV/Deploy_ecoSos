package br.com.dbc.vemser.ecososapi.ecosos.service;

import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.*;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Comentario;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Usuario;
import br.com.dbc.vemser.ecososapi.ecosos.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.ecososapi.ecosos.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.ecososapi.ecosos.repository.ComentarioRepository;
import br.com.dbc.vemser.ecososapi.ecosos.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioAdminService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public List<UsuarioDTO> listar() throws Exception{
        return usuarioRepository.findAll().stream()
                .map(this::retornarDTO)
                .toList();
    }

    public List<UsuarioDTO> listarUsuariosAtivos() {
        return usuarioRepository.findByStatus("A").stream()
                .map(this::retornarDTO)
                .toList();
    }

public Page<UsuarioDTO> listarTodos(Pageable pageable) {
    Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
    return usuarios.map(this::retornarDTO);
}

    public List<UsuarioComentarioRelatorioDTO> listPessoaComentarios(Integer id) {
        return usuarioRepository.procurarPessoaComentarios(id)
                .stream().map(usuario -> {
                    usuario.setComentarioUsuario(usuarioRepository.procurarComentarios(usuario.getIdUsuario()));
                    return usuario;
                }).toList();

    }

    public List<UsuarioOcorrenciaRelatorioDTO> listPessoaOcorrencias(Integer id) {
        return usuarioRepository.procurarPessoaOcorrencias(id)
                .stream().map(usuario -> {
                    usuario.setOcorrenciasDoUsuario(usuarioRepository.procurarOcorrencias(usuario.getIdUsuario()));
                    return usuario;
                }).toList();

    }

    public UsuarioDTO atualizar(Integer id, UsuarioUpdateDTO usuarioUpdateDTO) throws Exception {
        Usuario usuarioAtualizar = returnUsuario(id);

        if(usuarioAtualizar.getStatus() == "D") {
            throw new RegraDeNegocioException("Usuário não existe no sistema"); //TODO: Verificar se é a melhor exceção
        }

        if (usuarioUpdateDTO.getNome() != null){
            usuarioAtualizar.setNome(usuarioUpdateDTO.getNome());
        } if(usuarioUpdateDTO.getTelefone() != null){
            usuarioAtualizar.setTelefone(usuarioUpdateDTO.getTelefone());
        } if(usuarioUpdateDTO.getEmail() != null) {
            usuarioAtualizar.setEmail(usuarioUpdateDTO.getEmail());
        }
        usuarioAtualizar.setAtualizadoEm(Timestamp.valueOf(LocalDateTime.now()));

        return retornarDTO(usuarioRepository.save(usuarioAtualizar));
    }

    public void deletar(Integer idUsuario) throws Exception {
        Usuario usuarioDeletado = returnUsuario(idUsuario);
        usuarioDeletado.setStatus("D");
        usuarioRepository.save(usuarioDeletado);
    }


    public Integer getIdLoggedUser() {
        Integer findUserId = Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return findUserId;
    }

    public String getLoggedUser() throws Exception {
        Usuario usuario = returnUsuario(getIdLoggedUser());
        return usuario.getEmail();
    }

    public Usuario returnUsuario(Integer idUsuario) throws Exception{
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Nenhum usuário encontrado com o id " + idUsuario));
    }


    public UsuarioDTO retornarDTO(Usuario usuario) {
        return objectMapper.convertValue(usuario, UsuarioDTO.class);
    }



}