package ca.pmulcahy.ctci6.chp3;

import java.util.LinkedList;

/*
 * An animal shelter, which holds only dogs and cats, operates on a stricts "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, dequeueCat. You may use the built-in LinkedList data structure.
 */
public class Q6_AnimalShelter {
	
	LinkedList<Animal> animals = new LinkedList<>();
	
	public void enqueue(Animal animal) {
		animals.add(animal);
	}
	
	public Animal dequeue() {
		Animal animal = animals.poll();
		return animal;
	}

	public Animal dequeue(Species species) {
		for(Animal animal : animals) {
			if(animal.getSpecies() == species) {
				animals.remove(animal);
				return animal;
			}
		}
		return null;
	}
}

enum Species {DOG, CAT}

class Animal{
	private Species species;
	private String name;
	Animal(Species species, String name) {
		this.species = species;
		this.name = name;
	}
	public Species getSpecies() {
		return species;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name + " the " + species.toString();
	}
}



