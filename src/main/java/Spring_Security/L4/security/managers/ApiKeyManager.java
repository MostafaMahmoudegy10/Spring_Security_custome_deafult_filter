package Spring_Security.L4.security.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import Spring_Security.L4.security.authentication.ApiKeyAuthentication;
import Spring_Security.L4.security.providers.ApiKeyProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiKeyManager implements AuthenticationManager{
	
	private String key;
	@Override 
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		ApiKeyProvider provider=new ApiKeyProvider(key); 
		if(provider.supports(authentication.getClass())) {
			return provider.authenticate(authentication);
		}
		throw new BadCredentialsException("bad");
	}

}
