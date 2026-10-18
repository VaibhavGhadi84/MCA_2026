package org.unigoa.gbs.dcst;

import java.io.*;
import java.lang.reflect.*;

public class DCSTNIRFMain {

    // Feature 6: Function accepting any object implementing the interface and dispatching method
    public static void submitToNIRFPortal(NIRFReportable reportableItem) {
        System.out.println("[PORTAL DISPATCH] -> " + reportableItem.generateNIRFSummary());
    }

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("   DCST, GOA BUSINESS SCHOOL (GBS) - NIRF OOP VALIDATION DRIVER");
        System.out.println("================================================================================\n");

        // --------------------------------------------------------------------
        // Feature 1: Object Referencing & Side Effects
        // --------------------------------------------------------------------
        System.out.println("--- 1. Object Referencing & Reference Side Effect ---");
        Student refA = new Student("GOA-IND-1001", "20240901", "Rohan Naik", Enums.ProgramType.MCA, 2024, 8.75);
        Student refB = refA; // Two reference variables pointing to the same object on heap

        System.out.println("Original Student Name via refA: " + refA.fullName);
        refB.fullName = "Rohan V. Naik"; // Mutating state through refB
        System.out.println("Name seen through refA after refB mutation: " + refA.fullName);

        // --------------------------------------------------------------------
        // Feature 2: Static Members & Methods
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Static Members & Counter Tracking ---");
        Faculty fac1 = new Faculty("GOA-FAC-101", "F001", "Dr. Jyoti Pawar", "Professor", "Machine Learning");
        Faculty fac2 = new Faculty("GOA-FAC-102", "F002", "Mr. Ramrao Wagh", "Assoc. Professor", "Software Engineering");
        Student stu2 = new Student("GOA-IND-1002", "20240902", "Neha Sharma", Enums.ProgramType.MSC_DATA_SCIENCE, 2024, 9.20);

        System.out.println("Active Department Members (Tracked via static counter): " + DepartmentMember.getTotalMemberCount());

        // --------------------------------------------------------------------
        // Feature 3: Multiple Interface Inheritance
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Multiple Interface Inheritance Execution ---");
        ComplianceRecord complianceDoc = new ComplianceRecord() {
            @Override
            public boolean isCompliant() { return true; }
            @Override
            public String generateNIRFSummary() { return "DCST 3-Year Curricular Report: 100% Verified"; }
        };
        System.out.println(complianceDoc.generateNIRFSummary());
        System.out.println(complianceDoc.getAuditMetadata());
        System.out.println(complianceDoc.getArchiveStatus());

        // --------------------------------------------------------------------
        // Feature 4: Access Modifiers Demonstration
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Access Modifier Scopes ---");
        System.out.println("Public Field       : " + refA.fullName);
        System.out.println("Protected Field    : " + refA.memberId);
        System.out.println("Private Field (via getter): " + refA.getNationalID());
        // System.out.println(refA.nationalID); // Won't compile: private access in DepartmentMember

        // --------------------------------------------------------------------
        // Feature 5, 6 & 7: Polymorphism, Method Overriding, Overloading, Message Passing
        // --------------------------------------------------------------------
        System.out.println("\n--- 5, 6, 7. Polymorphism, Dynamic Dispatch & Overloading ---");
        Coordinator examCoord = new Coordinator("DCST Exam Cell");
        Activity isaActivity = new AcademicActivity("Semester I ISA Exams", 2024, examCoord, Enums.AcademicEventType.ISA);
        Activity infoFest = new NonAcademicActivity("InfoFest Tech Fiesta", 2025, new Coordinator("Student Council"), Enums.NonAcademicEventType.INFOFEST);

        // Method Overloading
        isaActivity.schedule("2024-09-12");
        infoFest.schedule("2025-01-20", "2025-01-22", "Silver Jubilee Hall, Goa University");

        // Message Passing
        submitToNIRFPortal(refA);
        submitToNIRFPortal(fac1);
        submitToNIRFPortal(isaActivity);
        submitToNIRFPortal(infoFest);

        // --------------------------------------------------------------------
        // Feature 8: Generics & Collections Framework
        // --------------------------------------------------------------------
        System.out.println("\n--- 8. Generics & Collection Framework (List, Set, Queue, Map) ---");
        NIRFDataRepository<NIRFReportable> repository = new NIRFDataRepository<>();

        try {
            repository.addRecord("STU_1", refA);
            repository.addRecord("STU_2", stu2);
            repository.addRecord("FAC_1", fac1);
            repository.addRecord("FAC_2", fac2);
            repository.addRecord("ACT_1", isaActivity);
            repository.addRecord("ACT_2", infoFest);
            repository.addRecord("ACT_3", new AcademicActivity("Placement Drive", 2024, new Coordinator("Placement Cell"), Enums.AcademicEventType.PLACEMENT_DRIVE));
            repository.addRecord("ACT_4", new NonAcademicActivity("Plateaunia", 2025, new Coordinator("Cultural Cell"), Enums.NonAcademicEventType.PLATEAUNIA));

            System.out.println("Total records registered: " + repository.getAllRecords().size());
            System.out.println("Next Record in Processing Queue: " + repository.getProcessingQueue().peek().generateNIRFSummary());
        } catch (InvalidNIRFRecordException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        // --------------------------------------------------------------------
        // Feature 9: Exception Handling (try-catch-finally, custom throws)
        // --------------------------------------------------------------------
        System.out.println("\n--- 9. Exception Handling Suite ---");
        try {
            System.out.println("Submitting invalid null record to generic repository...");
            repository.addRecord("ERR_KEY", null);
        } catch (InvalidNIRFRecordException ex) {
            System.out.println("Caught Custom Checked Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Generic Fallback Exception: " + ex.getMessage());
        } finally {
            System.out.println("Finally block executed: Transaction logged to system audit trail.");
        }

        // --------------------------------------------------------------------
        // Feature 10: Reflection, Persistence, I/O & Cloning
        // --------------------------------------------------------------------
        System.out.println("\n--- 10. Reflection, Cloning, I/O & Persistence ---");

        // A. Shallow vs Deep Cloning
        try {
            AcademicActivity originalAct = new AcademicActivity("Industry Study Tour", 2025,
                    new Coordinator("Prof. Pravin"), Enums.AcademicEventType.STUDY_TOUR);

            AcademicActivity shallowClone = (AcademicActivity) originalAct.shallowClone();
            AcademicActivity deepClone = (AcademicActivity) originalAct.deepClone();

            // Mutate original coordinator reference
            originalAct.getCoordinator().coordinatorName = "Prof. Pravin (Modified)";

            System.out.println("Shallow Clone Lead Name (Affected by mutation): " + shallowClone.getCoordinator().coordinatorName);
            System.out.println("Deep Clone Lead Name (Independent copy)      : " + deepClone.getCoordinator().coordinatorName);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // B. Reflection (RTTI)
        System.out.println("\n[Reflection] Inspecting Student class dynamically at runtime:");
        Class<?> studentClass = refA.getClass();
        System.out.println("Canonical Name: " + studentClass.getCanonicalName());
        Method[] methods = studentClass.getDeclaredMethods();
        System.out.print("Declared Methods (" + methods.length + "): ");
        for (Method m : methods) {
            System.out.print(m.getName() + "() ");
        }
        System.out.println();

        // C. Persistence & File I/O
        String storageFile = "nirf_records.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storageFile))) {
            oos.writeObject(refA);
            oos.writeObject(fac1);
            System.out.println("\n[Persistence] Successfully serialized department objects to " + storageFile);
        } catch (IOException e) {
            System.err.println("Serialization Error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storageFile))) {
            Student deserializedStudent = (Student) ois.readObject();
            Faculty deserializedFaculty = (Faculty) ois.readObject();
            System.out.println("[Persistence] Deserialized Student: " + deserializedStudent.fullName + " | PRN: " + deserializedStudent.memberId);
            System.out.println("[Persistence] Deserialized Faculty: " + deserializedFaculty.fullName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization Error: " + e.getMessage());
        } finally {
            new File(storageFile).delete(); // Cleanup serialized test file
        }
    }
}