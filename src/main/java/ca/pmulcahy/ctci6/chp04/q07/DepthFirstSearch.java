package ca.pmulcahy.ctci6.chp04.q07;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Collectors;

/*
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects where the second project
 *  is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build order
 *  that will allow the projects to be built. If there is no valid build order, return an error.
 */
public class DepthFirstSearch {

	private enum Mark {UNMARKED, PERMANENT, TEMPORARY};
	
	public static <T> List<T> getBuildOrder(final List<T> projectsInput, final List<SimpleEntry<T,T>> dependencyList) {
		final Set<T> projects = new HashSet<T>(projectsInput);
		//final int numProjects = projects.size();
		final Set<T> dependencyProjects = getProjectListFromDependencies(dependencyList);
		if(!projects.containsAll(dependencyProjects)) {
			throw new IncompleteProjectListException(projectsInput, dependencyList);
		}
		final Map<T,Set<T>> dependencyMap = getDependencyMap(dependencyList);
		final List<T> buildOrder = getOrder(projects, dependencyMap);
		
		return buildOrder;
	}
	
	private static <T> List<T> getOrder(final Set<T> projects, final Map<T, Set<T>> dependencyMap) {
		//final List<T> projectList = new ArrayList<>(projects);
		final Map<T,Mark> projectMarks = new HashMap<>();
		for(T project : projects) {
			projectMarks.put(project, Mark.UNMARKED);
		}
		final Deque<T> buildOrder = new ArrayDeque<>();
		for(T project : projects) {
			Mark mark = projectMarks.get(project);
			if(mark==Mark.UNMARKED) {
				visit(buildOrder, project, dependencyMap, projectMarks);
			}
		}
		// TODO Auto-generated method stub
		return new ArrayList<T>(buildOrder);
	}

	private static <T> void visit(final Deque<T> buildOrder, final T project, final Map<T, Set<T>> dependencyMap, final Map<T, Mark> projectMarks) {
		Mark mark = projectMarks.get(project);
		if(mark==Mark.PERMANENT) {
			return;
		}
		if(mark==Mark.TEMPORARY) {
			throw new CyclicalDependencyException(dependencyMap);
		}
		projectMarks.put(project, Mark.TEMPORARY);
		
		final Set<T> dependentProjects = dependencyMap.get(project);
		if(dependentProjects!=null) {
			for(T dependentProject : dependentProjects) {
				visit(buildOrder, dependentProject, dependencyMap, projectMarks);
			}
		}
		projectMarks.put(project, Mark.PERMANENT);
		buildOrder.push(project);
	}

	private static <T> Set<T> getProjectListFromDependencies(final List<SimpleEntry<T, T>> dependencies) {
		final Set<T> projects = new HashSet<T>();
		for(SimpleEntry<T,T> dependency: dependencies) {
			projects.add(dependency.getKey());
			projects.add(dependency.getValue());
		}
		return projects;
	}
	
	/* 
	 * Build the Graph in the form of a Map of Sets (Map<T,Set<T>>) where the Set<T> value is a list of
	 * projects dependent on T key.
	 */
	private static <T> Map<T,Set<T>> getDependencyMap(final List<SimpleEntry<T,T>> dependencyList) {
		final Map<T,Set<T>> dependencyMap = dependencyList.stream()
														  .collect(Collectors.groupingBy(SimpleEntry::getKey,
																   Collectors.mapping(SimpleEntry::getValue,
																   Collectors.toSet())));		
		return dependencyMap;
	}

	static class IncompleteProjectListException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public <T> IncompleteProjectListException(List<T> projects, List<SimpleEntry<T,T>> dependencyList) {
			super("Projects List: " + projects + " does not contain all projects listed in Dependencies List:" + dependencyList);
		}
	}
	
	static class CyclicalDependencyException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public <T> CyclicalDependencyException(final Map<T, Set<T>> dependencyMap) {
			super("Dependencies: " + dependencyMap + " contains at least one cyclical dependency.");
		}	
	}
}
