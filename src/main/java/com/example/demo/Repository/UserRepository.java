package com.example.demo.Repository;
import com.example.demo.Entity.ToDoListEntity;
import com.example.demo.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    
    @Query(value = "SELECT * FROM user_entity WHERE USER_ENTITY.GROUP_ID = :groupId", nativeQuery = true)
    List<UserEntity> findUsersByGroupId(@Param("groupId")Long groupId); 

    @Query(value = "SELECT user_entity_id FROM user_entity WHERE user_entity.email = :email", nativeQuery = true)
    Long findIdByEmail(@Param("email")String email);
    
    @Query(value = "SELECT user_entity.group_Id FROM user_entity WHERE user_entity.user_entity_id = :userId", nativeQuery = true)
    Long findGroupIdByUserId(@Param("userId")Long userId);
    
    @Query(value = "SELECT to_do_list_entity.* FROM user_entity " + 
                    "INNER JOIN group_entity ON user_entity.group_id = group_entity.group_id " + 
                    "INNER JOIN to_do_list_entity ON to_do_list_entity.group_id = group_entity.to_do_list_id " +
                    "WHERE user_entity.user_entity_id = :userId", nativeQuery = true)
    ToDoListEntity findToDoListIdByUserId(@Param("userId")Long userId);
    
}



