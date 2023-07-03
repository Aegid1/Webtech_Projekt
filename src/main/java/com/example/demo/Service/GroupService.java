package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.GroupRepository;

@Service
public class GroupService {

    @Autowired
    GroupRepository repo;

    public GroupEntity createGroup(GroupEntity group){ return repo.save(group); }

    public void deleteGroup(GroupEntity group){ repo.delete(group); }

    public List<UserEntity> findGroupId(Long id){ return repo.findByGroupId(id); }       

}
