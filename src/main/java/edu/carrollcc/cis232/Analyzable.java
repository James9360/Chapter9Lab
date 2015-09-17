package edu.carrollcc.cis232;

public interface Analyzable {
	
	/**
	 * Compares GradedActivity objects based on percentage score and returns the lowest object.
	 * If there is a tie, return the one worth the most points.
	 *   
	 * @return the GradedActivity object with the lowest percentage
	 */
	GradedActivity getLowestGrade();
	
	/**
	 * Compares GradedActivity objects based on percentage score and returns the highest object.
	 * If there is a tie, return the one worth the most points.
	 *   
	 * @return the GradedActivity object with the highest percentage
	 */
	GradedActivity getHighestGrade();
	
	/**
	 * Calculates the percentage for all GradedActivity objects by adding the earned points and dividing by
	 * the cumulative max points.
	 * 
	 * @return the percentage for all GradedActivity objects, returns 1.0 to mean 100%
	 */
	double getPercentage();
	
}
