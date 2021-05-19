package ca.pmulcahy.ctci6.chp4.q7;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects where the second project
 *  is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build order
 *  that will allow the projects to be built. If there is no valid build order, return an error.
 */
public class KahnsAlgorithm {
	public static <T> List<T> getBuildOrder(List<T> projectsInput, List<SimpleEntry<T,T>> dependencyList) {	
	
		Set<T> projects = new HashSet<T>(projectsInput);
		int numProjects = projects.size();
		Set<T> dependencyProjects = getProjectListFromDependencies(dependencyList);
		if(!projects.containsAll(dependencyProjects)) {
			throw new IncompleteProjectListException(projectsInput, dependencyList);//"Dependent projects missing from projects list. Add them!");
		}
		Map<T,Set<T>> dependencyMap = getDependencyMap(dependencyList);
		Deque<T> projectsWithoutDependencies = getProjectsWithoutDependencies(projects, dependencyMap);
		List<T> buildOrder = getOrder(projectsWithoutDependencies, dependencyMap, numProjects);

		return buildOrder;
	}
	
	private static <T> List<T> getOrder(Deque<T> projectsWithoutDependencies, Map<T, Set<T>> dependencyMap, int numProjects) {
		List<T> buildOrder = new ArrayList<T>();

		while(!projectsWithoutDependencies.isEmpty()) {
			T projectWithoutDependencies = projectsWithoutDependencies.pop();
			for(T project : dependencyMap.keySet()) {
				Set<T> dependencies = dependencyMap.get(project);
				if(dependencies.remove(projectWithoutDependencies) && dependencies.isEmpty()) {
					projectsWithoutDependencies.push(project);
				}
			}
			buildOrder.add(projectWithoutDependencies);
		}
		if(buildOrder.size() != numProjects) {
			throw new CyclicalDependencyException(dependencyMap);
		}
		
		return buildOrder;
	}

	private static <T> Set<T> getProjectListFromDependencies(List<SimpleEntry<T, T>> dependencies) {
		Set<T> projects = new HashSet<T>();
		for(SimpleEntry<T,T> dependency: dependencies) {
			projects.add(dependency.getKey());
			projects.add(dependency.getValue());
		}
		return projects;
	}

	private static <T> Map<T,Set<T>> getDependencyMap(List<SimpleEntry<T,T>> dependencyList) {
		Map<T,Set<T>> dependencyMap = dependencyList.stream()
													.collect(Collectors.groupingBy(SimpleEntry::getValue,
															 Collectors.mapping(SimpleEntry::getKey,
															 Collectors.toSet())));
		
		return dependencyMap;
	}
	
	private static <T> Deque<T> getProjectsWithoutDependencies(Set<T> projects, Map<T, Set<T>> dependencyMap) {
		Deque<T> projectsWithoutDependencies = projects.stream()
			       .filter(t -> dependencyMap.get(t) == null || dependencyMap.get(t).isEmpty())
			       .collect(Collectors.toCollection(()-> new ArrayDeque<T>()));
		return projectsWithoutDependencies;
	}
}