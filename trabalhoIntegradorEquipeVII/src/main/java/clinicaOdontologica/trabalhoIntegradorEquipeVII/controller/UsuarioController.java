package clinicaOdontologica.trabalhoIntegradorEquipeVII.controller;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.security.AuthenticationResponse;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.security.JwtUtil;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UsuarioDTO usuarioDTO) {
        Boolean create = usuarioService.create(usuarioDTO);

        if(create)
            return new ResponseEntity<>("Usuario salvo com sucesso!", HttpStatus.CREATED);

        return new ResponseEntity<>("Usuario nao pode ser criado!", HttpStatus.CONFLICT);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioDTO.getUserName(), usuarioDTO.getSenha()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect", e);
        }
        final UserDetails userDetails = usuarioService.loadUserByUsername(usuarioDTO.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
