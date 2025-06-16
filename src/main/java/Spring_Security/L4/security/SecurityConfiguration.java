package Spring_Security.L4.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import Spring_Security.L4.security.filters.ApiKeyFilter;
import lombok.AllArgsConstructor;

@Configuration
public class SecurityConfiguration {

	@Value("${api.key}")
	private String key;	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		
		
		return http.httpBasic().and().csrf().disable()
				.addFilterBefore(new ApiKeyFilter(key), UsernamePasswordAuthenticationFilter.class)
				.authorizeHttpRequests().anyRequest().authenticated().and()
				.build();
	}
	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
