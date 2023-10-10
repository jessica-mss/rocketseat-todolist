package br.com.jessicamarques.todolist.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jessicamarques.todolist.DTO.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@PostMapping
	@RequestMapping("/create")
	public void createUser(@RequestBody UserDTO userDTO) {
		
	}
	
	

}
