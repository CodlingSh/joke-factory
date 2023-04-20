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

@WebMvcTest()
class MainControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JokesRepository jokesDb;
	
	@Test
	public void getIndexTest() throws Exception {
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("Welcome"))
		.andExpect((model().attribute("hitCount", 10)));
	}
	
	@Test
	public void getJokesTest() throws Exception {
		this.mockMvc.perform(get("/showJokes"))
		.andExpect(status().isOk())
		.andExpect(view().name("jokeList"))
		.andExpect((model().attribute("allJokes", jokesDb.findAll())));			
	}
	
	@Test
	public void createJokeTest() throws Exception {
		this.mockMvc.perform(post("/createJoke").param("setUp", "Why did the chicken cross the road?").param("punchLine",  "To get to the other side").param("author", "Sheldon"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("jokeList"));
	}
	
	

}
