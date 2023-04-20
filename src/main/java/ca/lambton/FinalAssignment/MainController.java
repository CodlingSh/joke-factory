package ca.lambton.FinalAssignment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {
	
	@Autowired
	private JokesRepository jokesDb;
	
	@Autowired
	private HitCount hitCounter;
	
	@GetMapping(value="/")
	String getIndex(Model model) {
		hitCounter.addHits();
		model.addAttribute("hitCount", hitCounter.getHits());
		return "Welcome";
	}
	
	@GetMapping(value="/showJokes")
	String getJokes(Model model) {
		hitCounter.addHits();
		model.addAttribute("AllJokes", jokesDb.findAll());
		return "jokeList";
	}

	@GetMapping(value="/createJoke")
	public String createStudent(Model model) {
		hitCounter.addHits();
		model.addAttribute("hitCount", hitCounter.getHits());
		model.addAttribute("theJoke", new Joke());
		return "create";
	}

	// Create Joke
	@PostMapping(value="/createJoke")
	public String createJoke(@Valid Joke toSave, BindingResult bindingResult, Model model) {
		hitCounter.addHits();
		if (bindingResult.hasErrors()) {
			return "create";
		}
		
		jokesDb.save(toSave);
		model.addAttribute("AllJokes", jokesDb.findAll());
		return "jokeList";
	}
	
	
	// Extra stuff that wasn't required for assignment
	
	// Update Joke
	@PutMapping(value="update/{id}")
	public Joke updateJoke(@PathVariable int id, @RequestBody Joke joke) {
		Joke updatedJoke = jokesDb.findById(id).get();
		updatedJoke.setSetUp(joke.getSetUp());
		updatedJoke.setPunchLine(joke.getPunchLine());
		updatedJoke.setAuthor(joke.getAuthor());
		
		return updatedJoke;
	}

	// Delete Joke
	@DeleteMapping(value = "/delete/{id}")
	public String deleteJoke(@PathVariable int id) {
		Joke deleteJoke = jokesDb.findById(id).get();
		jokesDb.delete(deleteJoke);
		
		return "Joke with id: " + id + "has been deleted";
	}


}
