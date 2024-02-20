package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces.IAuthController;
import br.com.dbc.vemser.ecososapi.ecosos.dto.auth.AlteraSenhaDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.auth.LoginDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Usuario;
import br.com.dbc.vemser.ecososapi.ecosos.security.TokenService;
import br.com.dbc.vemser.ecososapi.ecosos.service.UsuarioAdminService;
import br.com.dbc.vemser.ecososapi.ecosos.service.UsuarioComumService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@Tag(name = "Auth")
@RequiredArgsConstructor
public class AuthController implements IAuthController {

    private final TokenService tokenService;
    public final AuthenticationManager authenticationManager;
    public final UsuarioAdminService usuarioAdminService;
    public final UsuarioComumService usuarioComumService;

    @PostMapping("/login")
    public String auth(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getSenha()
                );

        Authentication authentication =
                authenticationManager.authenticate(
                        usernamePasswordAuthenticationToken);

        Usuario usuarioValidado = (Usuario) authentication.getPrincipal();

        return tokenService.generateToken(usuarioValidado);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> adicionar(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO) throws Exception {
        usuarioComumService.adicionar(usuarioCreateDTO);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @PutMapping("/alterar-senha")
    public ResponseEntity<UsuarioDTO> alterarSenha(@RequestBody @Valid AlteraSenhaDTO alteraSenhaDTO) throws Exception {
        return ResponseEntity.ok(usuarioComumService.alterarSenha(alteraSenhaDTO));
    }

    @GetMapping("/usuario-logado")
    public String usuarioLogado() throws Exception{
        return usuarioAdminService.getLoggedUser();
    }
}
