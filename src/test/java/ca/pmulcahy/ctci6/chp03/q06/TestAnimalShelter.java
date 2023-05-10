package ca.pmulcahy.ctci6.chp03.q06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class TestAnimalShelter {

  @Test
  public void pollEmpty() {
    final AnimalShelter animalShelter = new AnimalShelter();
    assertNull(animalShelter.dequeue());
  }

  @Test
  public void pollEmptyDog() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal cat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(cat);
    assertNull(animalShelter.dequeue(Species.DOG));
  }

  @Test
  public void pollEmptyCat() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal dog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(dog);
    assertNull(animalShelter.dequeue(Species.CAT));
  }

  @Test
  public void fifoAny() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal cat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(cat);
    final Animal dog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(dog);
    assertEquals(cat, animalShelter.dequeue());
  }

  @Test
  public void fifoCat() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(plutoTheDog);
    final Animal felixTheCat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(felixTheCat);
    final Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
    animalShelter.enqueue(snoopyTheDog);
    final Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
    animalShelter.enqueue(fritzTheCat);
    assertEquals(felixTheCat, animalShelter.dequeue(Species.CAT));
  }

  @Test
  public void fifoDog() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal felixTheCat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(felixTheCat);
    final Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(plutoTheDog);
    final Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
    animalShelter.enqueue(snoopyTheDog);
    final Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
    animalShelter.enqueue(fritzTheCat);
    assertEquals(plutoTheDog, animalShelter.dequeue(Species.DOG));
  }

  @Test
  public void removeAny() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal felixTheCat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(felixTheCat);
    final Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(plutoTheDog);
    final Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
    animalShelter.enqueue(snoopyTheDog);
    final Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
    animalShelter.enqueue(fritzTheCat);
    animalShelter.dequeue();
    assertEquals(plutoTheDog, animalShelter.dequeue(Species.DOG));
  }

  @Test
  public void removeCat() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal felixTheCat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(felixTheCat);
    final Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(plutoTheDog);
    final Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
    animalShelter.enqueue(snoopyTheDog);
    final Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
    animalShelter.enqueue(fritzTheCat);
    animalShelter.dequeue(Species.CAT);
    assertEquals(plutoTheDog, animalShelter.dequeue(Species.DOG));
  }

  @Test
  public void removeDog() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(plutoTheDog);
    final Animal felixTheCat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(felixTheCat);
    final Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
    animalShelter.enqueue(snoopyTheDog);
    final Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
    animalShelter.enqueue(fritzTheCat);
    animalShelter.dequeue(Species.DOG);
    assertEquals(felixTheCat, animalShelter.dequeue(Species.CAT));
  }

  @Test
  public void removeMany() {
    final AnimalShelter animalShelter = new AnimalShelter();
    final Animal plutoTheDog = new Animal(Species.DOG, "Pluto");
    animalShelter.enqueue(plutoTheDog);
    final Animal felixTheCat = new Animal(Species.CAT, "Felix");
    animalShelter.enqueue(felixTheCat);
    final Animal snoopyTheDog = new Animal(Species.DOG, "Snoopy");
    animalShelter.enqueue(snoopyTheDog);
    final Animal fritzTheCat = new Animal(Species.CAT, "Fritz");
    animalShelter.enqueue(fritzTheCat);
    animalShelter.dequeue(Species.DOG);
    animalShelter.dequeue(Species.CAT);
    animalShelter.dequeue();
    assertEquals(fritzTheCat, animalShelter.dequeue());
  }
}
