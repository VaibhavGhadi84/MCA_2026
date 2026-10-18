/**
 * Derived class for Single Inheritance.
 * FarmManager extends SystemUser, inheriting its properties and adding specific privileges.
 */
public class FarmManager extends SystemUser {
    public String assignedFarmId;
    public double approvalLimits;

    public FarmManager(String userId, String name, String contactDetails, String assignedFarmId, double approvalLimits) {
        super(userId, name, contactDetails);
        this.assignedFarmId = assignedFarmId;
        this.approvalLimits = approvalLimits;
    }

    /** Approves farm requisitions based on limits. */
    public void approveRequisition(double amount) {
        if (amount <= approvalLimits) {
            System.out.println("Requisition of $" + amount + " approved by Manager " + name);
        } else {
            System.out.println("Requisition denied. Amount exceeds limit of $" + approvalLimits);
        }
    }

    /** Schedules harvest operations. */
    public void scheduleHarvest() {
        System.out.println("Harvest scheduled for farm: " + assignedFarmId);
    }
}