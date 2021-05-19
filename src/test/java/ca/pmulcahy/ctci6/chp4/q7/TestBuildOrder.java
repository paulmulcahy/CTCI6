package ca.pmulcahy.ctci6.chp4.q7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class TestBuildOrder {

	@Test
	public void zeroNodes() {
		
		List<Character> expected = new ArrayList<Character>();
		
		List<Character> projects = new ArrayList<Character>();
		List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		List<Character> order = KahnsAlgorithm.getBuildOrder(projects, dependencies);
		assertEquals(expected, order);
	}
	
	@Test
	public void bookExample() {
		
		List<Character> expected = new ArrayList<Character>(List.of('e', 'f', 'b', 'a', 'd', 'c'));
		
		List<Character> projects = new ArrayList<Character>(List.of('a', 'b', 'c', 'd', 'e', 'f'));
		List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		dependencies.add(new SimpleEntry<Character,Character>('a', 'd'));
		dependencies.add(new SimpleEntry<Character,Character>('f', 'b'));
		dependencies.add(new SimpleEntry<Character,Character>('b', 'd'));
		dependencies.add(new SimpleEntry<Character,Character>('f', 'a'));
		dependencies.add(new SimpleEntry<Character,Character>('d', 'c'));
		List<Character> order = KahnsAlgorithm.getBuildOrder(projects, dependencies);
		assertEquals(expected, order);
	}
	
	@Test
	public void incompleteProjectList() {
		List<Character> projects = new ArrayList<Character>(List.of('a', 'b'));
		List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		dependencies.add(new SimpleEntry<Character,Character>('a', 'c'));
		dependencies.add(new SimpleEntry<Character,Character>('b', 'c'));
		assertThrows(IncompleteProjectListException.class, () -> KahnsAlgorithm.getBuildOrder(projects, dependencies));		
	}
	
	@Test
	public void impossible() {		
		List<Character> projects = new ArrayList<Character>(List.of('a', 'b'));
		List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		dependencies.add(new SimpleEntry<Character,Character>('a', 'b'));
		dependencies.add(new SimpleEntry<Character,Character>('b', 'a'));
		assertThrows(CyclicalDependencyException.class, () -> KahnsAlgorithm.getBuildOrder(projects, dependencies));
	}
	
}
