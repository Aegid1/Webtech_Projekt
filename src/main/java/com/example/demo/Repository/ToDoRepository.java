package com.example.demo.Repository;

import com.example.demo.Entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {
}
