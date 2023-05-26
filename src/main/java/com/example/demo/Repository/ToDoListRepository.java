package com.example.demo.Repository;

import com.example.demo.Entity.ToDoListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoListEntity, Long> {

}
