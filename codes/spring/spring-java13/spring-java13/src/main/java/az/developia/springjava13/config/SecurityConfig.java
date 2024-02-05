package az.developia.springjava13.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true) //preauthorize'ni activ etmek uchun olan bir annotasiyadir
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(datasource);
	}  //Override etmekde meqsed onun bazadaki melumatlarla isleye bilmesi uchundur
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/users/teacher").permitAll()
		
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll() //uzaqdan api'ye baxmaga icaze verir
		
		.anyRequest().authenticated().and().httpBasic().and().sessionManagement()
		
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	//http.csrf().disable().- bu method her kese giris icazesi verir
	//authorizeRequests() - Sorgulari yoxlayir. Filtrasiyani baslatmaq uchundur
	//antMatchers(HttpMethod.POST,"/users/teacher").permitAll()- Bu linkde olan POST api'ye gelen sorgulari her kese icaze vermesi uchundur,yeni usename ve parolsuz daxil ola bilmek uchun
	//.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()- Bu method Front'dan back'e gelen delete,post ve diger emeliyyatlari yerine  yetirmesi uchun huquqlarin olub olmamasini yoxlayir
}
