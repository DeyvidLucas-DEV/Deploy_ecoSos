package br.com.dbc.vemser.ecososapi.ecosos.service;

import br.com.dbc.vemser.ecososapi.ecosos.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Endereco;
import br.com.dbc.vemser.ecososapi.ecosos.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.ecososapi.ecosos.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;


    public EnderecoDTO adicionar(EnderecoCreateDTO enderecoCreateDTO) throws Exception {

        Endereco endereco = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);

        if (verificaSeCepExiste(enderecoCreateDTO.getCep())) {
            return objectMapper.convertValue(enderecoRepository.findAllByCepEquals(enderecoCreateDTO.getCep()), EnderecoDTO.class);
        }
        endereco = enderecoRepository.save(endereco);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);

        return enderecoDTO;
    }

    public List<EnderecoDTO> listar() throws Exception{
        List<Endereco> enderecoList = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOList = new ArrayList<>();

        for(Endereco endereco : enderecoList){
            EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
            enderecoDTOList.add(enderecoDTO);
        }
        return enderecoDTOList;
    }

    private boolean verificaSeCepExiste(String cep) throws Exception {
        return enderecoRepository.findAll().stream()
                .anyMatch(e -> e.getCep().equals(cep));
    }

    public Endereco getEndereco(Integer idEndereco) throws Exception {
        return enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Nenhuma endereço encontrado com o id " + idEndereco));
    }
}


