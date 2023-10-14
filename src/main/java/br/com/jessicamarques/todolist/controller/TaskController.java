package br.com.jessicamarques.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jessicamarques.todolist.model.TaskModel;
import br.com.jessicamarques.todolist.repository.ITaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private ITaskRepository taskRepository;
	
	@PostMapping("/create")
	public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel taskModel) {
		TaskModel task = taskRepository.save(taskModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}
}
