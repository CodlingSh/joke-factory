package ca.lambton.FinalAssignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokesRepository extends CrudRepository<Joke, Integer> {
	
	public Joke findBySetUp(String setUp);
}
