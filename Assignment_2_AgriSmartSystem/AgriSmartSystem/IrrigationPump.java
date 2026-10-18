/** Derived Class 3 for Hierarchical Inheritance. */
public class IrrigationPump extends AgriculturalMachinery {
    public double waterFlowRate;

    public IrrigationPump(String machineId, String lastServiceDate, double fuelLevel, double waterFlowRate) {
        super(machineId, lastServiceDate, fuelLevel);
        this.waterFlowRate = waterFlowRate;
    }

    /** Toggles the irrigation pump state. */
    public void togglePump() {
        System.out.println("Toggling Irrigation Pump " + machineId + " (Flow Rate: " + waterFlowRate + " L/min).");
    }
}