package ca.pmulcahy.ctci6.chp04.q07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class TestKahnsAlgorithm {

	@Test
	public void zeroNodes() {
		final List<Character> expected = new ArrayList<Character>();
		final List<Character> projects = new ArrayList<Character>();
		final List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		final List<Character> order = KahnsAlgorithm.getBuildOrder(projects, dependencies);
		assertEquals(expected, order);
	}
	
	@Test
	public void bookExample() {
		final List<Character> expected = new ArrayList<Character>(List.of('e', 'f', 'b', 'a', 'd', 'c'));
		final List<Character> projects = new ArrayList<Character>(List.of('a', 'b', 'c', 'd', 'e', 'f'));
		final List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		dependencies.add(new SimpleEntry<Character,Character>('a', 'd'));
		dependencies.add(new SimpleEntry<Character,Character>('f', 'b'));
		dependencies.add(new SimpleEntry<Character,Character>('b', 'd'));
		dependencies.add(new SimpleEntry<Character,Character>('f', 'a'));
		dependencies.add(new SimpleEntry<Character,Character>('d', 'c'));
		final List<Character> order = KahnsAlgorithm.getBuildOrder(projects, dependencies);
		assertEquals(expected, order);
	}
	
	@Test
	public void incompleteProjectList() {
		final List<Character> projects = new ArrayList<Character>(List.of('a', 'b'));
		final List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		dependencies.add(new SimpleEntry<Character,Character>('a', 'c'));
		dependencies.add(new SimpleEntry<Character,Character>('b', 'c'));
		assertThrows(KahnsAlgorithm.IncompleteProjectListException.class, () -> KahnsAlgorithm.getBuildOrder(projects, dependencies));		
	}
	
	@Test
	public void impossible() {		
		final List<Character> projects = new ArrayList<Character>(List.of('a', 'b'));
		final List<SimpleEntry<Character,Character>> dependencies = new ArrayList<SimpleEntry<Character,Character>>();
		dependencies.add(new SimpleEntry<Character,Character>('a', 'b'));
		dependencies.add(new SimpleEntry<Character,Character>('b', 'a'));
		assertThrows(KahnsAlgorithm.CyclicalDependencyException.class, () -> KahnsAlgorithm.getBuildOrder(projects, dependencies));
	}
	
}
