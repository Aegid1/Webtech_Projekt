package com.example.demo.Repository;

import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.ToDoListEntity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoListEntity, Long> {
    
    @Query(value = "SELECT to_do_list_id FROM user_entity "+
                    "INNER JOIN group_entity ON user_entity.group_id = group_entity.group_id "+
                    "WHERE user_entity.user_entity_id = :userId", nativeQuery = true)
    Long findByToDoListId(@Param("userId")Long userId); 

}
