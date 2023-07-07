package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.GroupRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repo;

    @Autowired
    UserRepository userRepo;

    public GroupEntity createGroup(GroupEntity group) { return repo.save(group); }
    
    public void deleteGroup(GroupEntity group){ repo.delete(group); }

    public List<UserEntity> findGroupId(Long userId) {
        Long groupId = findGroupIdByUserId(userId);
        return userRepo.findUsersByGroupId(groupId);
    }

    public Long findGroupIdByUserId(Long userId){ return userRepo.findGroupIdByUserId(userId); }

}
