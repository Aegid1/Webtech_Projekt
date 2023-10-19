package com.example.demo.Repository;

import com.example.demo.Entity.GroupEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity,Long> {

    @Query(value = "SELECT group_entity.* FROM user_entity " + 
                    "INNER JOIN group_entity ON user_entity.group_id = group_entity.group_id " + 
                    "WHERE user_entity.user_entity_id = :userId", nativeQuery = true) 
    GroupEntity findGroupByUserId(@Param("userId")Long userId);
    
}
