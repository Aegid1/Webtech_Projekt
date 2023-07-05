package com.example.demo.Repository;
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
    
    @Query(value = "SELECT * FROM USER_ENTITY WHERE USER_ENTITY.GROUP_ID = :groupId", nativeQuery = true)
    List<UserEntity> findUsersByGroupId(@Param("groupId")Long groupId); 
}



