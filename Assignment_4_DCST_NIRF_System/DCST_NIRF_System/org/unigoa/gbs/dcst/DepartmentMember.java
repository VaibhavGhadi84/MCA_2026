package org.unigoa.gbs.dcst;

import java.io.Serializable;

public abstract class DepartmentMember implements Serializable {
    private static final long serialVersionUID = 1L;

    // Feature 2: Static counter tracking total instances across all subtypes
    private static int totalMemberCount = 0;

    // Feature 4: Access Modifiers
    private String nationalID;           // Private: visible ONLY inside DepartmentMember
    protected String memberId;           // Protected: visible to package and derived subclasses
    public String fullName;              // Public: accessible anywhere
    String departmentName;               // Package-private: accessible within org.unigoa.gbs.dcst

    // Feature 1: Explicit constructor initializing all attributes
    public DepartmentMember(String nationalID, String memberId, String fullName) {
        this.nationalID = nationalID;
        this.memberId = memberId;
        this.fullName = fullName;
        this.departmentName = "DCST, Goa Business School";
        totalMemberCount++;
    }

    // Feature 2: Static method
    public static int getTotalMemberCount() {
        return totalMemberCount;
    }

    // Encapsulation getter for private variable
    public String getNationalID() {
        return this.nationalID;
    }

    // Feature 5: Abstract method enforcing custom implementation in subclasses
    public abstract String getRoleDescription();
}