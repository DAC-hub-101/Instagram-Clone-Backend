package com.technicalinterview.instagramclone.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicalinterview.instagramclone.entity.Status;
import com.technicalinterview.instagramclone.service.StatusService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StatusController.class)
public class StatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatusService statusService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSubmitStatus() throws Exception {
        Status status = new Status(1, "status1", "user1", "path/to/image", new Timestamp(System.currentTimeMillis()));
        when(statusService.submitDataIntoDB(any(Status.class))).thenReturn(status);

        mockMvc.perform(post("/status")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(status)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusId").value(status.getStatusId()));

        verify(statusService, times(1)).submitDataIntoDB(any(Status.class));
    }

    @Test
    public void testGetAllStatus() throws Exception {
        ArrayList<Status> statuses = new ArrayList<>();
        statuses.add(new Status(1, "status1", "user1", "path/to/image", new Timestamp(System.currentTimeMillis())));
        when(statusService.retrieveStatus()).thenReturn(statuses);

        mockMvc.perform(get("/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].statusId").value("status1"));

        verify(statusService, times(1)).retrieveStatus();
    }
}
