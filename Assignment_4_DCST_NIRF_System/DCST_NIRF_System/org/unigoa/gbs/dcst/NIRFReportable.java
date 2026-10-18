package org.unigoa.gbs.dcst;

// Base interface establishing polymorphic type contract
public interface NIRFReportable {
    String generateNIRFSummary();
}

// Behavioral interface with default method
interface Auditable {
    default String getAuditMetadata() {
        return "Audit Status: Verified by GBS Quality Assurance Cell [NIRF Cycle 2024-2026]";
    }
}

// Archival contract interface
interface Archivable {
    default String getArchiveStatus() {
        return "Archival Status: Preserved in Goa University Central Academic Repository.";
    }
}

// Multiple Interface Inheritance: Combines multiple contracts into one
interface ComplianceRecord extends NIRFReportable, Auditable, Archivable {
    boolean isCompliant();
}