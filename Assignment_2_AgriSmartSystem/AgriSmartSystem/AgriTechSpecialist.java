/**
 * Derived class for Hybrid Inheritance.
 * Extends FarmWorker and implements DroneOperator and PesticideHandler.
 */
public class AgriTechSpecialist extends FarmWorker implements DroneOperator, PesticideHandler {
    
    public AgriTechSpecialist(String workerId, String shiftTiming) {
        super(workerId, shiftTiming);
    }

    @Override
    public void launchSurveyDrone() {
        System.out.println("AgriTech Specialist " + workerId + " is launching the survey drone.");
    }

    @Override
    public void downloadTopographyData() {
        System.out.println("Topography data downloaded successfully.");
    }

    @Override
    public void mixChemicals() {
        System.out.println("AgriTech Specialist " + workerId + " is safely mixing pesticides.");
    }

    @Override
    public void logUsage() {
        System.out.println("Pesticide usage logged in the central database.");
    }
}