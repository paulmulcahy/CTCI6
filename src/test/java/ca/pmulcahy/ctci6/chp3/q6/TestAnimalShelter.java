package ca.pmulcahy.ctci6.chp3.q6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAnimalShelter {
	
	@Test
	public void pollEmpty() {
		final AnimalShelter animalShelter = new AnimalShelter();
		assertNull(animalShelter.dequeue());
	}

	@Test
	public void pollEmptyDog() {
		final AnimalShelter animalShelter = new AnimalShelter();
		Animal cat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(cat);
		assertNull(animalShelter.dequeue(Species.DOG));
	}
	
	@Test
	public void pollEmptyCat() {
		final AnimalShelter animalShelter = new AnimalShelter();
		Animal dog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(dog);
		assertNull(animalShelter.dequeue(Species.CAT));
	}
	
	@Test
	public void fifoAny() {
		final AnimalShelter animalShelter = new AnimalShelter();
		Animal cat = new Animal(Species.CAT, "Felix");
		animalShelter.enqueue(cat);
		Animal dog = new Animal(Species.DOG, "Pluto");
		animalShelter.enqueue(dog);
		assertEquals(cat, animalShelter.dequeue());
	}

	@Test
	public void fifoCat() {
		final AnimalShelter animalShelter = new AnimalShelter();
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
		final AnimalShelter animalShelter = new AnimalShelter();
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
		final AnimalShelter animalShelter = new AnimalShelter();
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
		final AnimalShelter animalShelter = new AnimalShelter();
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
		final AnimalShelter animalShelter = new AnimalShelter();
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
		final AnimalShelter animalShelter = new AnimalShelter();
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
