package com.example.employee_ms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithMockUser
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateEmployeeDetails() throws Exception {
        String empJson = "{\"employeeId\":\"1\",\"employeeName\":\"John\",\"employeePosition\":\"Tester\"}";

        ResultActions result = mockMvc.perform(post("/employee/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(empJson));

        result.andExpect(status().isOk());
    }

    @Test
    public void testGetEmployeeDetails() throws Exception {
        ResultActions result = mockMvc.perform(get("/employee"));

        result.andExpect(status().isOk());
    }

    @Test
    public void testDeleteEmployeeDetails() throws Exception {
        String empJson = "{\"employeeId\":\"1\",\"employeeName\":\"John\",\"employeePosition\":\"Tester\"}";

        mockMvc.perform(post("/employee/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(empJson));

        ResultActions result = mockMvc.perform(delete("/employee/delete/1"));

        result.andExpect(status().isOk());
    }

    @Test
    public void testUpdateEmployeeDetails() throws Exception {
        String empJson = "{\"employeeId\":\"1\",\"employeeName\":\"John\",\"employeePosition\":\"Tester\"}";

        mockMvc.perform(post("/employee/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(empJson));

        String newEmpJson = "{\"employeeId\":\"1\",\"employeeName\":\"Ali\",\"employeePosition\":\"Support\"}";

        ResultActions result = mockMvc.perform(put("/employee/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newEmpJson));

        result.andExpect(status().isOk());
    }
}
