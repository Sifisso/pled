package mz.pled.mgr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementsUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        //Controlo de acesso aos menus
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/apresentar/preocupacao").permitAll()
                .antMatchers("/precadastrar/ocorrencia").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/concurso").permitAll()
                .antMatchers("/preCadastrar").permitAll()
                .antMatchers("/registar/usuarios").permitAll()
                .antMatchers("/cadastrar/usuarios").permitAll()
                .antMatchers("/buscar/preocupacao").permitAll()
                .antMatchers("/estatistica").permitAll()
                .antMatchers("/publico/apresentarPreocupacao").permitAll()
                .antMatchers("/apresentar/preocupacao").permitAll()
                .antMatchers("/buscar/preocupacao").permitAll()
                .antMatchers("/estatistica").permitAll()
                .antMatchers("/relatorio").permitAll()
                .antMatchers("/pesquisar/ocorrencia").permitAll()
                .antMatchers("/ver/detalhe/{id}").permitAll()
                .antMatchers("/filter").permitAll()
                .antMatchers("/filter1").permitAll()
                .antMatchers("/distrito/{id}").permitAll()
                .antMatchers("/posto/{id}").permitAll()
                .antMatchers("/recuperar/senha").permitAll()
                .antMatchers("/recuperar/password").permitAll()

                //Links que podem ser acessados pelos Admins
                .antMatchers("/home").hasAnyAuthority("ROLE_ADMIN")
                //.antMatchers("/listar/ocorrencia").hasAnyAuthority("ROLE_ADMIN","OPERADOR","OBSERVADOR")
                .antMatchers("/user").hasAnyRole("OPERADOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()

                //Criacao de uma pagina custumizada de login
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/login")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(userDetailsService)
               .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        //Ignorar as pastas de css e js na seguranca
        web.ignoring().antMatchers("/css/**","/templates/publico/**","/assets/**","/static/**","/js/**","/image/**","/img/**","/font-awesomw/**","/img/**","/fonts/**");

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
