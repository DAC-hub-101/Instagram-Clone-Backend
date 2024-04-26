// package com.technicalinterview.instagramclone.controller;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.technicalinterview.instagramclone.dto.StatusDTO;
// import com.technicalinterview.instagramclone.service.StatusService;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;

// import java.sql.Timestamp;
// import java.util.ArrayList;

// @ExtendWith(SpringExtension.class)
// @WebMvcTest(StatusController.class)
// public class StatusControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private StatusService statusService;

//     private ObjectMapper objectMapper = new ObjectMapper();

//     @Test
//     public void testSubmitStatus() throws Exception {
//         StatusDTO statusDTO = new StatusDTO(1, "status1", "user1", "path/to/image", "User Name", new Timestamp(System.currentTimeMillis()));
//         when(statusService.submitDataIntoDB(any(StatusDTO.class))).thenReturn(statusDTO);

//         mockMvc.perform(post("/status")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(statusDTO)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.statusId").value(statusDTO.getStatusId()));

//         verify(statusService, times(1)).submitDataIntoDB(any(StatusDTO.class));
//     }

//     @Test
//     public void testGetAllStatus() throws Exception {
//         ArrayList<StatusDTO> statusDTOs = new ArrayList<>();
//         statusDTOs.add(new StatusDTO(1, "status1", "user1", "path/to/image", "User Name", new Timestamp(System.currentTimeMillis())));
//         when(statusService.retrieveStatus()).thenReturn(statusDTOs);

//         mockMvc.perform(get("/status"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$[0].statusId").value("status1"));

//         verify(statusService, times(1)).retrieveStatus();
//     }
// }
