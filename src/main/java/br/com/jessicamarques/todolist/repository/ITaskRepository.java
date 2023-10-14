package br.com.jessicamarques.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jessicamarques.todolist.model.TaskModel;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID>{

}
