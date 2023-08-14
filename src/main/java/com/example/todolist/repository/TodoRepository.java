package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todolist.entity.Todo;

@Repository // ①
public interface TodoRepository extends JpaRepository<Todo, Integer> { // ②
}
