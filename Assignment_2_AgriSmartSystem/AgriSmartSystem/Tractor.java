/** Derived Class 1 for Hierarchical Inheritance. */
public class Tractor extends AgriculturalMachinery {
    public double towingCapacity;

    public Tractor(String machineId, String lastServiceDate, double fuelLevel, double towingCapacity) {
        super(machineId, lastServiceDate, fuelLevel);
        this.towingCapacity = towingCapacity;
    }

    /** Attaches a plow to the tractor. */
    public void attachPlow() {
        System.out.println("Plow attached to Tractor " + machineId + " (Capacity: " + towingCapacity + "kg).");
    }
}