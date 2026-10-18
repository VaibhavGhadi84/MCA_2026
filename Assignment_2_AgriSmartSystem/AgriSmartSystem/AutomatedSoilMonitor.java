/**
 * Implementing class for Multiple Inheritance.
 * Combines distinct hardware capabilities into one monitor.
 */
public class AutomatedSoilMonitor implements MoistureSensor, TemperatureSensor {
    
    @Override
    public double getSoilMoistureLevel() {
        return 22.5; // Dummy moisture percentage
    }

    @Override
    public double getAmbientTemperature() {
        return 34.0; // Dummy temperature in Celsius
    }

    /** Checks readings and triggers alerts if necessary. */
    public void runDiagnostics() {
        double moisture = getSoilMoistureLevel();
        double temp = getAmbientTemperature();
        System.out.println("Soil Moisture: " + moisture + "% | Ambient Temp: " + temp + "°C");
        if (moisture < 30.0 && temp > 30.0) {
            System.out.println("ALERT: Soil is dry and hot! Initiating emergency irrigation.");
        }
    }
}