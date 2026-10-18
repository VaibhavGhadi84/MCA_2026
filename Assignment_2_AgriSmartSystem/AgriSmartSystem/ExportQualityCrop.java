/**
 * Level 3 (Derived) for Multilevel Inheritance.
 * Adds export-specific data to a food crop.
 */
public class ExportQualityCrop extends FoodCrop {
    public String exportGrade;
    public String certificationCode;

    public ExportQualityCrop(String speciesName, String plantingDate, String harvestSeason, double expectedYield, String exportGrade, String certificationCode) {
        super(speciesName, plantingDate, harvestSeason, expectedYield);
        this.exportGrade = exportGrade;
        this.certificationCode = certificationCode;
    }

    /** Generates an export compliance report. */
    public void generateExportComplianceReport() {
        System.out.println("Generating Export Report for " + speciesName);
        System.out.println("Grade: " + exportGrade + " | Cert Code: " + certificationCode);
        System.out.println("Status: Approved for International Export.");
    }
}