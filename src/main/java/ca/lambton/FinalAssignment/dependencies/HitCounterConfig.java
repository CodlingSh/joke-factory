package ca.lambton.FinalAssignment.dependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.lambton.FinalAssignment.HitCount;

@Configuration
public class HitCounterConfig {
	
	@Bean
	public HitCount getHitCounter() {
		return new HitCount();
	}
}
