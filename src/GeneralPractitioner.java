/**
 * Subclass of HealthProfessional (Part 2 requirement: General Practitioner)
 * Adds unique attribute: maximum daily consultations (specific to GPs)
 */
public class GeneralPractitioner extends HealthProfessional {
    // Unique attribute: max daily consultations (GPs have daily patient limits)
    private int maxDailyConsultations;

    // 1. Default constructor (Part 2 required)
    public GeneralPractitioner() {
        super(); // Call parent's default constructor
        this.maxDailyConsultations = 20; // Default value for GPs
    }

    // 2. Parameterized constructor (initializes parent + child attributes)
    public GeneralPractitioner(int id, String name, String professionalTitle, int maxDailyConsultations) {
        super(id, name, professionalTitle); // Initialize parent attributes first
        // Validate unique attribute: max cannot be negative
        if (maxDailyConsultations < 0) {
            throw new IllegalArgumentException("Max daily consultations cannot be negative.");
        }
        this.maxDailyConsultations = maxDailyConsultations;
    }

    // 3. Override print method (includes professional type, Part 2 required)
    @Override
    public void printDetails() {
        System.out.println("==================================");
        System.out.println("Professional Type: General Practitioner");
        super.printDetails(); // Reuse parent's print logic (avoid duplication)
        System.out.println("Max Daily Consultations: " + maxDailyConsultations);
        System.out.println("==================================");
    }

    // Getter and Setter for unique attribute (encapsulation)
    public int getMaxDailyConsultations() {
        return maxDailyConsultations;
    }

    public void setMaxDailyConsultations(int maxDailyConsultations) {
        if (maxDailyConsultations < 0) {
            throw new IllegalArgumentException("Max daily consultations cannot be negative.");
        }
        this.maxDailyConsultations = maxDailyConsultations;
    }
}
