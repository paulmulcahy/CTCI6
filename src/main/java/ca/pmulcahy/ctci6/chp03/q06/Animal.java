package ca.pmulcahy.ctci6.chp03.q06;

public class Animal {
  private Species species;
  private String name;

  Animal(final Species species, final String name) {
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
