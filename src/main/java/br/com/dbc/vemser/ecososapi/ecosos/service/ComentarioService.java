package br.com.dbc.vemser.ecososapi.ecosos.service;

import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Comentario;

import br.com.dbc.vemser.ecososapi.ecosos.entity.Usuario;
import br.com.dbc.vemser.ecososapi.ecosos.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.ecososapi.ecosos.exceptions.PermissaoNegadaException;
import br.com.dbc.vemser.ecososapi.ecosos.repository.ComentarioRepository;
import br.com.dbc.vemser.ecososapi.ecosos.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    private final ObjectMapper objectMapper;
    private final OcorrenciaService ocorrenciaService;
    private final UsuarioComumService usuarioComumService;
    private final UsuarioRepository usuarioRepository;

    public ComentarioDTO adicionar(Integer idOcorrencia, Integer idUsuario, ComentarioCreateDTO comentarioCreateDTO) throws Exception {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            throw new IllegalArgumentException("O ID do usuário fornecido não existe.");
        }
        Comentario comentario = converterDTO(comentarioCreateDTO);

        comentario.setOcorrencia(ocorrenciaService.getOcorrencia(idOcorrencia));
        comentario.setUsuario(usuarioComumService.returnUsuario(idUsuario));
        comentario.setCriadoEm(Timestamp.valueOf(LocalDateTime.now()));

        return retornarDTO(comentarioRepository.save(comentario));
    }

    public ComentarioDTO atualizarParaAdmin(Integer idComentario, ComentarioUpdateDTO comentarioUpdateDTO) throws Exception{
        Comentario comentarioRecuperado = returnComentario(idComentario);

        comentarioRecuperado.setConteudo(comentarioUpdateDTO.getConteudo());
        comentarioRecuperado.setAtualizadoEm(Timestamp.valueOf(LocalDateTime.now()));
        return  retornarDTO(comentarioRepository.save(comentarioRecuperado));
    }

    public ComentarioDTO atualizarParaComum(Integer idComentario, ComentarioUpdateDTO comentarioUpdateDTO) throws Exception{
        Comentario comentarioRecuperado = returnComentario(idComentario);

        if(comentarioRecuperado.getIdUsuario().equals(usuarioComumService.getIdLoggedUser())) {

            comentarioRecuperado.setConteudo(comentarioUpdateDTO.getConteudo());
            comentarioRecuperado.setAtualizadoEm(Timestamp.valueOf(LocalDateTime.now()));
            return  retornarDTO(comentarioRepository.save(comentarioRecuperado));
        } else {
            throw new PermissaoNegadaException("Você não pode editar um comentário que não foi escrito por você");
        }

    }

    public Page<Comentario> listar(Pageable pageable){
        return comentarioRepository.findAll(pageable);
    }

    public List<ComentarioDTO> listarPorComentario(Integer idOcorrencia) throws Exception{
       return comentarioRepository.findByIdOcorrencia(idOcorrencia).stream()
               .map(this::retornarDTO)
               .collect(Collectors.toList());
    }

    public void removerParaAdmin(Integer idComentario) throws Exception{
        Comentario comentarioADeletar = returnComentario(idComentario);

        comentarioRepository.delete(comentarioADeletar);
    }

    public void removerParaComum(Integer idComentario) throws Exception{
        Comentario comentarioDeletado = returnComentario(idComentario);

        if(!comentarioDeletado.getIdUsuario().equals(usuarioComumService.getIdLoggedUser())){
            throw new PermissaoNegadaException("Comentário não foi feito por você");
        }
        comentarioRepository.delete(comentarioDeletado);
    }

    public Comentario returnComentario(Integer idComentario) throws Exception{
        return comentarioRepository.findById(idComentario)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Nenhum comentário encontrado com o id " + idComentario));
    }

    public Comentario converterDTO(ComentarioCreateDTO dto) {
        return objectMapper.convertValue(dto, Comentario.class);
    }


    public ComentarioDTO retornarDTO(Comentario comentario){
        return objectMapper.convertValue(comentario, ComentarioDTO.class);
    }

    public ComentarioUpdateDTO retornarUpdateDTO(Comentario comentario){
        return objectMapper.convertValue(comentario, ComentarioUpdateDTO.class);
    }
}
