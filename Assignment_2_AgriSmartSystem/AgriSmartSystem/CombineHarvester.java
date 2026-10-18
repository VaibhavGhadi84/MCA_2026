/** Derived Class 2 for Hierarchical Inheritance. */
public class CombineHarvester extends AgriculturalMachinery {
    public double grainBinCapacity;

    public CombineHarvester(String machineId, String lastServiceDate, double fuelLevel, double grainBinCapacity) {
        super(machineId, lastServiceDate, fuelLevel);
        this.grainBinCapacity = grainBinCapacity;
    }

    /** Empties the harvested grain from the bin. */
    public void emptyGrainBin() {
        System.out.println("Emptying grain bin for Harvester " + machineId + " (Capacity: " + grainBinCapacity + " liters).");
    }
}