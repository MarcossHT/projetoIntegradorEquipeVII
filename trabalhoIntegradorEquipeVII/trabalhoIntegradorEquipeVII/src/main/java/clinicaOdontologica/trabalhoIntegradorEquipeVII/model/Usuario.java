package clinicaOdontologica.trabalhoIntegradorEquipeVII.model;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.enums.UserRoles;
import clinicaOdontologica.trabalhoIntegradorEquipeVII.model.dto.UsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;;import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "userName", nullable = false, unique = true)
    private String userName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles userRoles;

    public Usuario() {
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.userName = usuarioDTO.getUserName();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.userRoles = usuarioDTO.getUserRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRoles.name());
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }
}
