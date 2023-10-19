package com.example.demo.Controller;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Service.GroupService;
import com.example.demo.Service.ToDoService;
import com.example.demo.Service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @Autowired
    UserService uService;

    @Autowired
    GroupService groupService;

    /*
     * endpoint to get all todos by the userid of a user
     * @Param String -> the userid
     * @return ResponseEntity<List<ToDoEntity>> -> a list containing all todos of a user
     */
    @GetMapping("/alltodos/{userId}")
    public ResponseEntity<List<ToDoEntity>> getToDos(@PathVariable String userId) {

        Long groupId = groupService.findGroupIdByUserId(Long.parseLong(userId));
        List<ToDoEntity> todos = toDoService.getTodosByGroupId(groupId);
        return ResponseEntity.ok(todos);
    }


    @GetMapping("todo/{id}")
    public ToDoEntity getTodo(@PathVariable String id) {

        return toDoService.findTodoById(Long.parseLong(id));
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id){

        toDoService.deleteToDo(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

    /*
     * endpoint to create a new todo by using the userid of the user
     * @Param ToDoEntity -> the data of the todo that will be created
     * @Param String -> the userid of the user
     * @return ResponseEntity<ToDoEntity> -> the created todo
     */
    @PostMapping("/todo/{userId}")
    public ResponseEntity<ToDoEntity> createTodo(@RequestBody ToDoEntity todo, @PathVariable String userId) {

        GroupEntity group = uService.findToDoListIdByUserId(userId);
        return ResponseEntity.ok(toDoService.create(todo.getTitle(), todo.getDeadline(), group));
    }

    /*
     * endpoint to finish a task, so the score of a user gets updated and the todo gets deleted
     * @Param String -> the userid of the user
     * @Param String -> the todoid of the todo which the user finished
     * @return ResponseEntity<Void> -> an empty response, that contains the status code of the action
     */
    @DeleteMapping("/updateScore/{userId}/{todoId}")
    public ResponseEntity<Void> updateUserScoreAndDeleteTodo(@PathVariable String userId, @PathVariable String todoId){

        toDoService.deleteToDo(Long.parseLong(todoId));
        uService.updateScore(Long.parseLong(userId));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<ToDoEntity> updateTodo(@RequestBody ToDoEntity todo) {

        return ResponseEntity.ok(toDoService.updateTodoById(todo));
    }
}
