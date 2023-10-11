package br.com.jessicamarques.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jessicamarques.todolist.model.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, UUID>{
	
	public UserModel findByUsername(String username);

}
