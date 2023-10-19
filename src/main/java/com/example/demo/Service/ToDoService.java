package com.example.demo.Service;

import com.example.demo.Repository.ToDoRepository;
import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.ToDoEntity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository repo;

    /*
     * gets all todos by the todolistid and converts the format of the date into YYYY-MM-DD
     * @param Long -> the id of the todolist
     * @return List<ToDoEntity> -> a list containing all todos 
     */
    public List<ToDoEntity> getTodosByGroupId(Long groupId) {

        List<ToDoEntity> todos = repo.findByToDoListId(groupId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (ToDoEntity todo : todos) {

            Date date = todo.getDeadline();
            String formattedDate = formatter.format(date);
            todo.setDate(formattedDate);
        }

        return todos;
    }

    public void deleteToDo(Long id) { repo.deleteById(id); }

    public ToDoEntity findTodoById(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }

    /*
     * gets the todo, that is stored in the database and updates it with the new information of the new todo
     * @param ToDoEntity -> the new todo with the new information
     * @return ToDoEntity -> the updated todo
     */
    public ToDoEntity updateTodoById(ToDoEntity todo) {

        ToDoEntity existingTodo = findTodoById(todo.getId());

        if (existingTodo != null) {
            
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDeadline(todo.getDeadline());
            return repo.save(existingTodo);
            
        } else {
            throw new IllegalArgumentException("ToDoEntity mit ID " + todo.getId() + " existiert nicht.");
        }

    }

    public ToDoEntity create(String title, Date deadline, GroupEntity group) {

        ToDoEntity newToDo = new ToDoEntity();
        newToDo.setTitle(title);
        newToDo.setDeadline(deadline);
        newToDo.setGroup(group);
        newToDo.setEditMode(false);
        
        return repo.save(newToDo);
    }

}
