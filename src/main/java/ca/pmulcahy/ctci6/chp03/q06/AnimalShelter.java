package ca.pmulcahy.ctci6.chp03.q06;

import java.util.LinkedList;

/*
 * An animal shelter, which holds only dogs and cats, operates on a stricts "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, dequeueCat. You may use the built-in LinkedList data structure.
 */
public class AnimalShelter {
	
	LinkedList<Animal> animals = new LinkedList<>();
	
	public void enqueue(final Animal animal) {
		animals.add(animal);
	}
	
	public Animal dequeue() {
		Animal animal = animals.poll();
		return animal;
	}

	public Animal dequeue(final Species species) {
		for(Animal animal : animals) {
			if(animal.getSpecies() == species) {
				animals.remove(animal);
				return animal;
			}
		}
		return null;
	}
}
