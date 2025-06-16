package Spring_Security.L4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring_Security.L4.entites.User;
import Spring_Security.L4.security.service.CustomeUserDetilsService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	private CustomeUserDetilsService service;
	
	@GetMapping()
	public List<User> findAll() {
		return this.service.findAll();
	}
	@GetMapping("{id}")
	public User getUser(@PathVariable("id")int id) {
		return this.service.findById(id);
	}
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody User user){
		User save = this.service.save(user);
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?>delete(@PathVariable("id")int id)
	{
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
