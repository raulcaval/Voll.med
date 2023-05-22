package med.voll.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // params: Entidade e tipo da chave primária
    UserDetails findByLogin(String login); //metodo faz consulta do user na tabela de users

}
