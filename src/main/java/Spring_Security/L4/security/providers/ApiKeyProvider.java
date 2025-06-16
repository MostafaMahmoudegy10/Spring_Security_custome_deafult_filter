package Spring_Security.L4.security.providers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import Spring_Security.L4.security.authentication.ApiKeyAuthentication;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ApiKeyProvider implements  AuthenticationProvider{

	private String key;

	@Override 
	public Authentication authenticate(Authentication authentication) {
		ApiKeyAuthentication nonAuthanicated=(ApiKeyAuthentication)authentication;
		if(nonAuthanicated.getKey().equals(key)) {
			nonAuthanicated.setAuthenticated(true);
			return nonAuthanicated;
		}
		 throw new BadCredentialsException("this is bad") ;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(ApiKeyAuthentication.class);
	}
	

}
