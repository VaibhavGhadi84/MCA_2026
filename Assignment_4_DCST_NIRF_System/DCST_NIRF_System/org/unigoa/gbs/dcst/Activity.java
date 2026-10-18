package org.unigoa.gbs.dcst;

import java.io.Serializable;

public abstract class Activity implements NIRFReportable, Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    protected String activityName;
    protected int academicYear;
    protected Coordinator coordinator;

    public Activity(String activityName, int academicYear, Coordinator coordinator) {
        this.activityName = activityName;
        this.academicYear = academicYear;
        this.coordinator = coordinator;
    }

    public String getActivityName() { return activityName; }
    public Coordinator getCoordinator() { return coordinator; }

    // Feature 7: Method Overloading (Signature 1)
    public void schedule(String date) {
        System.out.println("Activity [" + activityName + "] scheduled on date: " + date);
    }

    // Feature 7: Method Overloading (Signature 2)
    public void schedule(String startDate, String endDate, String venue) {
        System.out.println("Activity [" + activityName + "] scheduled from " + startDate 
                + " to " + endDate + " at " + venue);
    }

    // Feature 10: Shallow Cloning (copies primitive/string references directly)
    public Activity shallowClone() throws CloneNotSupportedException {
        return (Activity) super.clone();
    }

    // Feature 10: Deep Cloning (creates a new instance of child reference types)
    public Activity deepClone() throws CloneNotSupportedException {
        Activity cloned = (Activity) super.clone();
        cloned.coordinator = new Coordinator(this.coordinator.coordinatorName);
        return cloned;
    }
}