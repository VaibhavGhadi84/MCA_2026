/**
 * Level 1 (Base) for Multilevel Inheritance.
 * Represents a basic plantation.
 */
public class Plantation {
    public String speciesName;
    public String plantingDate;

    public Plantation(String speciesName, String plantingDate) {
        this.speciesName = speciesName;
        this.plantingDate = plantingDate;
    }

    /** Calculates the age of the plantation. */
    public void calculateAge() {
        System.out.println("Calculating age for " + speciesName + " planted on " + plantingDate + "...");
    }
}