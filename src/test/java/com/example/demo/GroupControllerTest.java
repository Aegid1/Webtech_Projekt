package com.example.demo;

import com.example.demo.Controller.GroupController;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testGetUserScores() throws Exception {
        // Mock-Daten für den Service
        List<Map<String, Object>> userInformations = new ArrayList<>();
        Map<String, Object> userData = new HashMap<>();

        userData.put("id", 1L);
        userData.put("firstname", "John");
        userData.put("score", 5);

        userInformations.add(userData);

        // Mock-Verhalten für den Service
        when(groupService.getUserAndScores(1L)).thenReturn(userInformations);

        // Test der Controller-Methode
        mockMvc.perform(get("/getGroup/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].score").value(5))
                .andExpect(jsonPath("$[0].firstname").value("John"));
    }
}
