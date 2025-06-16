package Spring_Security.L4.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Spring_Security.L4.entites.User;
import Spring_Security.L4.repoistry.UserRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomeUserDetilsService implements UserDetailsService{
	
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userByUserName = this.repo.findUserByUserName(username);
		return userByUserName.map(CustomeUserDetils::new).orElseThrow(()->new UsernameNotFoundException("HELP"));
		
	}
	public User save(User user) {
		return this.repo.save(user);
	}
	
	public User findById(int id) {
		return this.repo.findById(id).get();
	}
	
	public List<User> findAll() {
		return this.repo.findAll();
	}
	public void delete(int id) {
		this.repo.deleteById(id);
	}

}
