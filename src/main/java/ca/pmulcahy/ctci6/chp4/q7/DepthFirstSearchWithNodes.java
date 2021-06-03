package ca.pmulcahy.ctci6.chp4.q7;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;

/*
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects where the second project
 *  is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build order
 *  that will allow the projects to be built. If there is no valid build order, return an error.
 */
public class DepthFirstSearchWithNodes {

	private enum Mark {UNMARKED, PERMANENT, TEMPORARY};
	private static class Node<T> {
		private Set<T> dependentProjects;
		private Mark mark;
		
		public Node() {
			this.mark = Mark.UNMARKED;
			this.dependentProjects = new HashSet<T>();
		}
		
		public Mark getMark() {
			return mark;
		}
		public void setMark(final Mark mark) {
			this.mark = mark;
		}
		public Set<T> getDependentProjects() {
			return dependentProjects;
		}
		public void addDependentProject(final T project) {
			this.dependentProjects.add(project);
		}		
	}
	
	public static <T> List<T> getBuildOrder(final List<T> projectsInput, final List<SimpleEntry<T,T>> dependencyList) {
		final Set<T> projects = new HashSet<T>(projectsInput);
		final Set<T> dependencyProjects = getProjectListFromDependencies(dependencyList);
		if(!projects.containsAll(dependencyProjects)) {
			throw new IncompleteProjectListException(projectsInput, dependencyList);
		}
		final Map<T, Node<T>> dependencyNodeMap = getNodes(projectsInput, dependencyList);
		final List<T> buildOrder = getOrder(dependencyNodeMap);
		
		return buildOrder;
	}
	
	private static <T> List<T> getOrder(final Map<T, Node<T>> dependencyNodeMap) {
		final Deque<T> buildOrder = new ArrayDeque<>();
		for(T project : dependencyNodeMap.keySet()) {
			final Node<T> node = dependencyNodeMap.get(project);
			final Mark mark = node.getMark();
			if(mark==Mark.UNMARKED) {
				visit(buildOrder, project, dependencyNodeMap);
			}
		}
		return new ArrayList<T>(buildOrder);
	}

	private static <T> void visit(final Deque<T> buildOrder, final T project, final Map<T, Node<T>> dependencyNodeMap) {
		final Node<T> node = dependencyNodeMap.get(project);
		final Mark mark = node.getMark();
		if(mark==Mark.PERMANENT) {
			return;
		}
		if(mark==Mark.TEMPORARY) {
			throw new CyclicalDependencyException(dependencyNodeMap);
		}
		node.setMark(Mark.TEMPORARY);
		
		final Set<T> dependentProjects = node.getDependentProjects();
		if(dependentProjects!=null) {
			for(T dependentProject : dependentProjects) {
				visit(buildOrder, dependentProject, dependencyNodeMap);
			}
		}
		node.setMark(Mark.PERMANENT);
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
	 * Build the Graph in the form of a Map of Nodes (Map<T,Node<T>>) where the Node<T> contains a list of
	 * projects dependent on the T key AND a mark.
	 */
	private static <T> Map<T, Node<T>> getNodes(final List<T> projectsInput, final List<SimpleEntry<T,T>> dependencyList) {
		final Map<T, Node<T>> projectNodes = new HashMap<>();
		for(T project : projectsInput) {
			projectNodes.put(project, new Node<T>());
		}
		for(SimpleEntry<T,T> dependency : dependencyList) {
			final Node<T> node = projectNodes.get(dependency.getKey());
			node.addDependentProject(dependency.getValue());
		}
		return projectNodes;
	}

	static class IncompleteProjectListException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public <T> IncompleteProjectListException(List<T> projects, List<SimpleEntry<T,T>> dependencyList) {
			super("Projects List: " + projects + " does not contain all projects listed in Dependencies List:" + dependencyList);
		}
	}
	
	static class CyclicalDependencyException extends RuntimeException {
		private static final long serialVersionUID = 1L;		
		public <T> CyclicalDependencyException(final Map<T, Node<T>> dependencyNodeMap) {
			super("Dependencies: " + dependencyNodeMap + " contains at least one cyclical dependency.");
		}	
	}
}
