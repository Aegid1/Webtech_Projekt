package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Repository.GroupRepository;

public class GroupService {

    @Autowired
    GroupRepository repo;

    public GroupEntity createGroup(GroupEntity group){ return repo.save(group); }

    public void deleteGroup(GroupEntity group){ repo.delete(group); }

    public GroupEntity findUserByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }       

}
