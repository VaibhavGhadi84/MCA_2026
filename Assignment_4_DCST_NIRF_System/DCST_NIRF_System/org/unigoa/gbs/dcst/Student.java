package org.unigoa.gbs.dcst;

public class Student extends DepartmentMember implements NIRFReportable {
    private static final long serialVersionUID = 1L;

    private Enums.ProgramType program;
    private int batchYear;
    private double cgpa;

    public Student(String nationalID, String memberId, String fullName, 
                   Enums.ProgramType program, int batchYear, double cgpa) {
        super(nationalID, memberId, fullName);
        this.program = program;
        this.batchYear = batchYear;
        this.cgpa = cgpa;
    }

    public Enums.ProgramType getProgram() { return program; }
    public double getCgpa() { return cgpa; }

    // Feature 7: Method Overriding (overrides DepartmentMember.getRoleDescription)
    @Override
    public String getRoleDescription() {
        // Direct access to protected memberId
        return "Student [" + memberId + "] enrolled in " + program + ", Batch: " + batchYear;
    }

    // Feature 6: Implementation of NIRFReportable
    @Override
    public String generateNIRFSummary() {
        return String.format("Student: %-22s | PRN: %-10s | Program: %-16s | CGPA: %.2f",
                fullName, memberId, program, cgpa);
    }
}