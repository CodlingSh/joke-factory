package ca.lambton.FinalAssignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Joke {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank
	@Size(min=5, max=150)
	private String setUp;
	
	@NotBlank
	@Size(min=5, max=100)
	private String punchLine;
	
	@NotBlank
	@Size(min=2, max=40)
	private String author;
}
