package org.unigoa.gbs.dcst;

public class NonAcademicActivity extends Activity {
    private static final long serialVersionUID = 1L;
    private Enums.NonAcademicEventType eventType;

    public NonAcademicActivity(String activityName, int academicYear, 
                               Coordinator coordinator, Enums.NonAcademicEventType eventType) {
        super(activityName, academicYear, coordinator);
        this.eventType = eventType;
    }

    @Override
    public String generateNIRFSummary() {
        return String.format("Non-Academic Event: %-25s | Year: %d | Type: %-15s | Lead: %s",
                activityName, academicYear, eventType, coordinator.coordinatorName);
    }
}