/** Base class for Hybrid Inheritance. */
public class FarmWorker {
    public String workerId;
    public String shiftTiming;

    public FarmWorker(String workerId, String shiftTiming) {
        this.workerId = workerId;
        this.shiftTiming = shiftTiming;
    }

    /** Logs worker attendance. */
    public void logAttendance() {
        System.out.println("Attendance logged for Worker " + workerId + " (Shift: " + shiftTiming + ").");
    }
}