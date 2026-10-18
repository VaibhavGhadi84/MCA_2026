/**
 * Level 2 (Intermediate) for Multilevel Inheritance.
 * Adds agricultural attributes to a basic plantation.
 */
public class FoodCrop extends Plantation {
    public String harvestSeason;
    public double expectedYield;

    public FoodCrop(String speciesName, String plantingDate, String harvestSeason, double expectedYield) {
        super(speciesName, plantingDate);
        this.harvestSeason = harvestSeason;
        this.expectedYield = expectedYield;
    }

    /** Estimates the optimal harvest date. */
    public void estimateHarvestDate() {
        System.out.println("Estimated harvest for " + speciesName + " is during " + harvestSeason + " with a yield of " + expectedYield + " tons.");
    }
}