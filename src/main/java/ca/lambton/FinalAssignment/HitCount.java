package ca.lambton.FinalAssignment;

public class HitCount {
	private int hits;
	
	// Constructor
	public HitCount() {
		this.hits = 0;
	}
	
	// Increment the hits
	public void addHits() {
		this.hits++;
	}
	
	// Getter for hits
	public int getHits() {
		return this.hits;
	}
}
