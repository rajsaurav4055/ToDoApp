package com.createhabits.springboot.mytodoapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository to use JPA provided functions to talk with the database (MySQL) here.
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUsername(String username);
}
