package Spring_Security.L4.security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Spring_Security.L4.entites.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomeUserDetils implements UserDetails {

	private User user;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->"read");
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

}
