package br.com.jessicamarques.todolist.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity(name = "tb_users")
public class UserModel {
	
	@Id
	@GeneratedValue(generator = "UUID")
//	@Size(max = 10)
	@Column(length = 20)
	private UUID id;
	
//	@Column(unique = true)
	private String username;
	private String name;
	private String password;
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
