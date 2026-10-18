package org.unigoa.gbs.dcst;

public class AcademicActivity extends Activity {
    private static final long serialVersionUID = 1L;
    private Enums.AcademicEventType eventType;

    public AcademicActivity(String activityName, int academicYear, 
                            Coordinator coordinator, Enums.AcademicEventType eventType) {
        super(activityName, academicYear, coordinator);
        this.eventType = eventType;
    }

    @Override
    public String generateNIRFSummary() {
        return String.format("Academic Event    : %-25s | Year: %d | Type: %-15s | Lead: %s",
                activityName, academicYear, eventType, coordinator.coordinatorName);
    }
}