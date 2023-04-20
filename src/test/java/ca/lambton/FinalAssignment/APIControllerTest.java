package ca.lambton.FinalAssignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

class APIControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getCurrentCountTest() throws Exception {
		this.mockMvc.perform(get("/hitCount"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void incrementHitTest() throws Exception {
		this.mockMvc.perform(get("/incrementHit"))
		.andExpect(status().isOk());
	}
}
