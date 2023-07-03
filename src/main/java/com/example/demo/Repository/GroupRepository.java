package com.example.demo.Repository;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity,Long> {

    @Query(value = "SELECT * FROM USER_ENTITY WHERE USER_ENTITY.GROUP_ID = :groupId", nativeQuery = true)
    List<UserEntity> findByGroupId(@Param("groupId")Long groupId); 
}
