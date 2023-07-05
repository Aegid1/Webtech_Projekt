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

}
