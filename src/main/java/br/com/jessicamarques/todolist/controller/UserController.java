package br.com.jessicamarques.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jessicamarques.todolist.model.UserModel;
import br.com.jessicamarques.todolist.repository.IUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserRepository userRepository;
	
	@PostMapping
	@RequestMapping("/create")
	public ResponseEntity createUser(@RequestBody UserModel userModel) {
		UserModel findByUsername = userRepository.findByUsername(userModel.getUsername());
		
		if (findByUsername != null) {
//			System.out.println("Usuário já existe na base.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe na base.");
		}
		
		userRepository.save(userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
	}
	
	

}
