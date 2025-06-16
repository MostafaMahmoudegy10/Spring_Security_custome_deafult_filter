package Spring_Security.L4.repoistry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Spring_Security.L4.entites.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.userName=:userName")
	Optional<User>findUserByUserName(String userName);
}
