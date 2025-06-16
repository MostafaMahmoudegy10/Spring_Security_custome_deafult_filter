package Spring_Security.L4.security.filters;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import Spring_Security.L4.security.authentication.ApiKeyAuthentication;
import Spring_Security.L4.security.managers.ApiKeyManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

	private String key;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println(request.getMethod()); 
		//API key
		if(request.getRequestURI().startsWith("/user"))
		{ 
			filterChain.doFilter(request, response);
			return;
		}
		String header = request.getHeader("x-api-key"); 
		ApiKeyAuthentication  authentication=new ApiKeyAuthentication(false,header);
		ApiKeyManager manager =new ApiKeyManager(key);
		Authentication authenticate = manager.authenticate(authentication);
		if(authenticate.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			filterChain.doFilter(request, response);
		}
	}

}
