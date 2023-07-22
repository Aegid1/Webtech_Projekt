package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Map<String, Object>> getUserAndScores(Long id){

        List<Map<String, Object>> nameAndScore = new ArrayList<>();
        List<UserEntity> group = findGroupId(id);

        for(UserEntity user : group){ 

            HashMap<String, Object> userData = new HashMap<>();
            userData.put("id", user.getId());
            userData.put("firstname", user.getFirstname());
            userData.put("score", Integer.parseInt(user.getScore()));
            nameAndScore.add(userData);
        }

        return nameAndScore;

    }

    public Long findGroupIdByUserId(Long userId){ return userRepo.findGroupIdByUserId(userId); }

}
