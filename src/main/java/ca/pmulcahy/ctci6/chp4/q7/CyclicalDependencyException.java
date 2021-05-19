package ca.pmulcahy.ctci6.chp4.q7;


import java.util.Map;
import java.util.Set;

public class CyclicalDependencyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public <T> CyclicalDependencyException(Map<T, Set<T>> dependencyMap) {
		super("Dependencies: " + dependencyMap + " contains at least one cyclical dependency.");
	}
}
