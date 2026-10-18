package org.unigoa.gbs.dcst;

public class Faculty extends DepartmentMember implements NIRFReportable {
    private static final long serialVersionUID = 1L;

    private String designation;
    private String specialization;

    public Faculty(String nationalID, String memberId, String fullName, 
                   String designation, String specialization) {
        super(nationalID, memberId, fullName);
        this.designation = designation;
        this.specialization = specialization;
    }

    @Override
    public String getRoleDescription() {
        return "Faculty [" + memberId + "]: " + designation + " (" + specialization + ")";
    }

    @Override
    public String generateNIRFSummary() {
        return String.format("Faculty: %-22s | ID: %-10s | Designation: %-12s | Area: %s",
                fullName, memberId, designation, specialization);
    }
}