package com.example.demo.Repository;

import com.example.demo.Entity.ToDoEntity;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {

    @Query(value = "SELECT * FROM TO_DO_ENTITY WHERE TO_DO_ENTITY.GROUP_ID = :groupId", nativeQuery = true)
    List<ToDoEntity> findByGroupId(@Param("groupId")Long groupId); 

}
