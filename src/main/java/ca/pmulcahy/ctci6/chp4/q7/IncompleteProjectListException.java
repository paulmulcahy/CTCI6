package ca.pmulcahy.ctci6.chp4.q7;

import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class IncompleteProjectListException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public <T> IncompleteProjectListException(List<T> projects, List<SimpleEntry<T,T>> dependencyList) {
		super("Projects List: " + projects + " does not contain all projects listed in Dependencies List:" + dependencyList);
	}
}
