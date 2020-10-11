package ca.pmulcahy.ctci6.chp3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestQ6_AnimalShelter {
	
	@Test
	public void pollEmpty() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		assertNull(animalShelter.dequeue());
	}

	@Test
	public void pollEmptyDog() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal cat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(cat);
		assertNull(animalShelter.dequeue(Species.DOG));
	}
	
	@Test
	public void pollEmptyCat() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal dog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(dog);
		assertNull(animalShelter.dequeue(Species.CAT));
	}
	
	@Test
	public void fifoAny() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal cat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(cat);
		Animal dog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(dog);
		assertEquals(cat, animalShelter.dequeue());
	}

	@Test
	public void fifoCat() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(plutoTheDog);
		Animal felixTheCat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(felixTheCat);
		Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
		animalShelter.enqueue(snoopyTheDog);
		Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
		animalShelter.enqueue(fritzTheCat);		
		assertEquals(felixTheCat, animalShelter.dequeue(Species.CAT));
	}
	
	@Test
	public void fifoDog() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal felixTheCat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(felixTheCat);
		Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(plutoTheDog);
		Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
		animalShelter.enqueue(snoopyTheDog);
		Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
		animalShelter.enqueue(fritzTheCat);		
		assertEquals(plutoTheDog, animalShelter.dequeue(Species.DOG));
	}
	
	@Test
	public void removeAny() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal felixTheCat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(felixTheCat);
		Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(plutoTheDog);
		Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
		animalShelter.enqueue(snoopyTheDog);
		Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
		animalShelter.enqueue(fritzTheCat);		
		animalShelter.dequeue();
		assertEquals(plutoTheDog, animalShelter.dequeue(Species.DOG));
	}
	
	@Test
	public void removeCat() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal felixTheCat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(felixTheCat);
		Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(plutoTheDog);
		Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
		animalShelter.enqueue(snoopyTheDog);
		Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
		animalShelter.enqueue(fritzTheCat);		
		animalShelter.dequeue(Species.CAT);
		assertEquals(plutoTheDog, animalShelter.dequeue(Species.DOG));
	}
	
	@Test
	public void removeDog() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(plutoTheDog);
		Animal felixTheCat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(felixTheCat);
		Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
		animalShelter.enqueue(snoopyTheDog);
		Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
		animalShelter.enqueue(fritzTheCat);		
		animalShelter.dequeue(Species.DOG);
		assertEquals(felixTheCat, animalShelter.dequeue(Species.CAT));
	}	
	
	@Test
	public void removeMany() {
		final Q6_AnimalShelter animalShelter = new Q6_AnimalShelter();
		Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(plutoTheDog);
		Animal felixTheCat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(felixTheCat);
		Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
		animalShelter.enqueue(snoopyTheDog);
		Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
		animalShelter.enqueue(fritzTheCat);		
		animalShelter.dequeue(Species.DOG);
		animalShelter.dequeue(Species.CAT);
		animalShelter.dequeue();
		assertEquals(fritzTheCat, animalShelter.dequeue());
	}	
}
