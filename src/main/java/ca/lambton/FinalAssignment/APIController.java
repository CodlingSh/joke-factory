package ca.lambton.FinalAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
	
	@Autowired
	private HitCount hitCounter;
	
	@GetMapping(value = "/hitCount")
	public int currentCount() {
		return hitCounter.getHits();
	}
	
	@GetMapping(value="/incrementHit")
	public int incrementHit() {
		hitCounter.addHits();
		return hitCounter.getHits();
	}
		
}
