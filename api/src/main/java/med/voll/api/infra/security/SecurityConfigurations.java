package med.voll.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    //SecurityFilterChain: Objeto spring para configuraçôes de autenticação e tb autorização
    // @Bean: expoe o retorno do metodo, retornando o objeto para o spring.
    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        /*
        http.csrf().disable(): Desabilita o csrf
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS): Desabilita processo de autenticação padrão
        * */
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().build();
    };

    @Bean
    public AuthenticationManager authenticationManager ( AuthenticationConfiguration configuration ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
