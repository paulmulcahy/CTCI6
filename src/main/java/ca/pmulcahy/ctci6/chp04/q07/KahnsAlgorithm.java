package ca.pmulcahy.ctci6.chp04.q07;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects where the second project
 *  is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build order
 *  that will allow the projects to be built. If there is no valid build order, return an error.
 */
public class KahnsAlgorithm {
  public static <T> List<T> getBuildOrder(
      final List<T> projectsInput, final List<SimpleEntry<T, T>> dependencyList) {

    final Set<T> projects = new HashSet<T>(projectsInput);
    final int numProjects = projects.size();
    final Set<T> dependencyProjects = getProjectListFromDependencies(dependencyList);
    if (!projects.containsAll(dependencyProjects)) {
      throw new IncompleteProjectListException(projectsInput, dependencyList);
    }
    final Map<T, Set<T>> dependencyMap = getDependencyMap(dependencyList);
    final Deque<T> projectsWithoutDependencies =
        getProjectsWithoutDependencies(projects, dependencyMap);
    final List<T> buildOrder = getOrder(projectsWithoutDependencies, dependencyMap, numProjects);

    return buildOrder;
  }

  private static <T> List<T> getOrder(
      final Deque<T> projectsWithoutDependencies,
      final Map<T, Set<T>> dependencyMap,
      final int numProjects) {
    final List<T> buildOrder = new ArrayList<T>();

    while (!projectsWithoutDependencies.isEmpty()) {
      final T projectWithoutDependencies = projectsWithoutDependencies.pop();
      for (T project : dependencyMap.keySet()) {
        final Set<T> dependencies = dependencyMap.get(project);
        if (dependencies.remove(projectWithoutDependencies) && dependencies.isEmpty()) {
          projectsWithoutDependencies.push(project);
        }
      }
      buildOrder.add(projectWithoutDependencies);
    }
    if (buildOrder.size() != numProjects) {
      throw new CyclicalDependencyException(dependencyMap);
    }

    return buildOrder;
  }

  private static <T> Set<T> getProjectListFromDependencies(
      final List<SimpleEntry<T, T>> dependencies) {
    final Set<T> projects = new HashSet<T>();
    for (SimpleEntry<T, T> dependency : dependencies) {
      projects.add(dependency.getKey());
      projects.add(dependency.getValue());
    }
    return projects;
  }

  /*
   * Build the Graph in the form of a Map of Sets (Map<T,Set<T>>) where the Set<T> value is a list of
   * dependencies on T key.
   */
  private static <T> Map<T, Set<T>> getDependencyMap(final List<SimpleEntry<T, T>> dependencyList) {
    final Map<T, Set<T>> dependencyMap =
        dependencyList.stream()
            .collect(
                Collectors.groupingBy(
                    SimpleEntry::getValue,
                    Collectors.mapping(SimpleEntry::getKey, Collectors.toSet())));
    return dependencyMap;
  }

  private static <T> Deque<T> getProjectsWithoutDependencies(
      final Set<T> projects, final Map<T, Set<T>> dependencyMap) {
    final Deque<T> projectsWithoutDependencies =
        projects.stream()
            .filter(t -> dependencyMap.get(t) == null || dependencyMap.get(t).isEmpty())
            .collect(Collectors.toCollection(() -> new ArrayDeque<T>()));
    return projectsWithoutDependencies;
  }

  static class IncompleteProjectListException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public <T> IncompleteProjectListException(
        List<T> projects, List<SimpleEntry<T, T>> dependencyList) {
      super(
          "Projects List: "
              + projects
              + " does not contain all projects listed in Dependencies List:"
              + dependencyList);
    }
  }

  static class CyclicalDependencyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public <T> CyclicalDependencyException(final Map<T, Set<T>> dependencyMap) {
      super("Dependencies: " + dependencyMap + " contains at least one cyclical dependency.");
    }
  }
}
