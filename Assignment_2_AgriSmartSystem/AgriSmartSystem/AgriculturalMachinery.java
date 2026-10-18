/**
 * Base class for Hierarchical Inheritance.
 * Common umbrella for different agricultural equipment.
 */
public class AgriculturalMachinery {
    public String machineId;
    public String lastServiceDate;
    public double fuelLevel;

    public AgriculturalMachinery(String machineId, String lastServiceDate, double fuelLevel) {
        this.machineId = machineId;
        this.lastServiceDate = lastServiceDate;
        this.fuelLevel = fuelLevel;
    }

    /** Logs maintenance activities. */
    public void logMaintenance() {
        System.out.println("Machine " + machineId + " last serviced on: " + lastServiceDate);
    }

    /** Checks current fuel level. */
    public void checkFuel() {
        System.out.println("Machine " + machineId + " fuel level: " + fuelLevel + "%");
    }
}