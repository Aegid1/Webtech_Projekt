package com.example.demo;

import com.example.demo.Controller.GroupController;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GroupControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GroupService groupService;

    @InjectMocks
    private GroupController groupController;

    @BeforeEach
    public void setup() {
        // Initialisierung der Mock-Umgebung und des MockMvc
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
    }

    @Test
    public void testGetGroup() throws Exception {
        // Mock-Daten für den Service
        List<UserEntity> group = new ArrayList<>();
        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setFirstname("John");
        user1.setLastname("Doe");
        user1.setRole(Role.USER);
        group.add(user1);

        // Mock-Verhalten für den Service
        when(groupService.findGroupId(1L)).thenReturn(group); // Änderung hier

        // Test der Controller-Methode
        mockMvc.perform(get("/getGroup/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstname").value("John"))
                .andExpect(jsonPath("$[0].lastname").value("Doe"));
    }
}
