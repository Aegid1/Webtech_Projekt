package com.example.demo;

import com.example.demo.Controller.ToDoController;
import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Service.ToDoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ToDoControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ToDoService toDoService;

    @InjectMocks
    private ToDoController toDoController;

    @BeforeEach
    public void setup() {
        // Initialisierung der Mock-Umgebung und des MockMvc
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(toDoController).build();
    }

    @Test
    public void testGetToDos() throws Exception {
        // Mock-Daten für den Service
        List<ToDoEntity> todos = new ArrayList<>();
        ToDoEntity todo1 = new ToDoEntity();
        todo1.setId(1L);
        todo1.setTitle("ToDo 1");
        todo1.setDeadline(Date.valueOf("2023-07-04"));
        todos.add(todo1);

        // Mock-Verhalten für den Service: Rückgabe der To-Dos basierend auf einer List-ID
        when(toDoService.getTodosByListId(anyLong())).thenReturn(todos);

        // Test der Controller-Methode: Abrufen der To-Dos
        mockMvc.perform(get("/alltodos/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("ToDo 1"))
                .andExpect(jsonPath("$[0].date").value("2023-07-04"));
    }

    @Test
    public void testGetTodo() throws Exception {
        // Mock-Daten für den Service
        ToDoEntity todo = new ToDoEntity();
        todo.setId(1L);
        todo.setTitle("ToDo 1");
        todo.setDate("2023-07-04");

        // Mock-Verhalten für den Service: Rückgabe eines einzelnen To-Dos basierend auf einer ID
        when(toDoService.findToDoByID(anyLong())).thenReturn(todo);

        // Test der Controller-Methode: Abrufen eines einzelnen To-Dos
        mockMvc.perform(get("/todo/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("ToDo 1"))
                .andExpect(jsonPath("$.date").value("2023-07-04"));
    }

    // Test der Controller-Methode: Löschen eines To-Dos
    @Test
    public void testDeleteTodo() throws Exception {
        mockMvc.perform(delete("/delete/{id}", "1"))
                .andExpect(status().isOk());
    }
}
