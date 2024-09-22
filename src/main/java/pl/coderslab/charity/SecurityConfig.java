package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import pl.coderslab.charity.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Wyłączenie CSRF
                .csrf().disable()

                // Konfiguracja autoryzacji żądań
                .authorizeRequests()
                .antMatchers("/register").permitAll()   // Dostęp do /register bez autoryzacji
                .antMatchers("/").permitAll()           // Dostęp do / bez autoryzacji
                .anyRequest().authenticated()           // Wszystkie inne żądania wymagają autoryzacji
                .and()

                // Konfiguracja logowania
                .formLogin()
                .loginPage("/login")                    // Własna strona logowania
                .loginProcessingUrl("/login")           // Ścieżka przetwarzania logowania
                .defaultSuccessUrl("/", true)       // Domyślna strona po pomyślnym logowaniu
                .permitAll()
                .and()

                // Konfiguracja wylogowania
                .logout()
                .invalidateHttpSession(true)            // Inwalidacja sesji
                .clearAuthentication(true)              // Wyczyszczenie autoryzacji
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  // Ścieżka wylogowania
                .logoutSuccessUrl("/login?logout")      // Strona po wylogowaniu
                .permitAll();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/vendor/**","/fonts/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

    }

}