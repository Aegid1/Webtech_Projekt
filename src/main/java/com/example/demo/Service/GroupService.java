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

import jakarta.transaction.Transactional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repo;

    @Autowired
    UserRepository userRepo;

    @Transactional
    public GroupEntity createGroup(GroupEntity group, String id) { 

        repo.save(group);
        userRepo.changeGroupId(group.getGroupId(), Long.parseLong(id));
        return group;

    }
    
    public void deleteGroup(GroupEntity group){ repo.delete(group); }

    @Transactional
    public List<UserEntity> findGroupId(Long userId) {
        Long groupId = findGroupIdByUserId(userId);
        return userRepo.findUsersByGroupId(groupId);
    }

    /*
     * gets all scores of all users from a group in a json-format
     * @Param Long -> id of the user that sends the request
     * @return List<Map<String, Object>> -> List of maps, where a map represents a user containing the id, firstname and score as its keys
     */
    @Transactional
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

    public GroupEntity saveGroup (GroupEntity group){ return repo.save(group); }

    public GroupEntity findGroupById(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }

}
