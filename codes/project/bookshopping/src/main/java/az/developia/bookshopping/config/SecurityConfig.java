package az.developia.bookshopping.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled=true)
public class SecurityConfig  {

    @Autowired
    private DataSource dataSource;
    
    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
        jdbcDaoImpl.setDataSource(dataSource);
        return jdbcDaoImpl;
    }
    
    
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf().disable()
                .authorizeRequests()
                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/").permitAll()
                .requestMatchers(HttpMethod.GET,"/create-account").permitAll()
                .requestMatchers(HttpMethod.POST,"/create-account-process").permitAll()
                .requestMatchers(HttpMethod.GET,"/costumer").permitAll()
                .requestMatchers(HttpMethod.GET,"/rest/books").permitAll()
                .requestMatchers(HttpMethod.GET,"/styles/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/files/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/confirm-order").permitAll()
                .requestMatchers(HttpMethod.POST,"/rest/orders").permitAll()
                .requestMatchers(HttpMethod.POST,"/rest/books/search").permitAll()
                .requestMatchers(HttpMethod.POST,"/rest/books/search-find-partial").permitAll()
                .requestMatchers(HttpMethod.GET,"/order-confirmation-message").permitAll()
                .requestMatchers(HttpMethod.POST,"/rest/orders/save-basket-books").permitAll()
                .requestMatchers(HttpMethod.POST,"/confirm-order-process").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/show-login")
                .loginProcessingUrl("/authenticate-user").permitAll()
                .and().logout()
                .and()
                .httpBasic()
                .and()
                .build();
       
    }
    
}
