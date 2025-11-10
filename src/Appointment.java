import java.util.regex.Pattern;

/**
 * Appointment class (Part 4 requirement)
 * Stores patient information, preferred time slot, and selected health professional.
 * Implements encapsulation, validation, and required constructors/methods.
 */
public class Appointment {
    // Required instance variables (Part 4 mandatory requirements)
    private String patientName;
    private String patientMobile;
    private String timeSlot;
    private HealthProfessional selectedDoctor; // Polymorphic reference (accepts subclasses)

    // 1. Default constructor (Part 4 required)
    public Appointment() {
        this.patientName = "Unknown Patient";
        this.patientMobile = "Unknown";
        this.timeSlot = "Unknown";
        this.selectedDoctor = new HealthProfessional(); // Default doctor object
    }

    // 2. Parameterized constructor (initializes all variables + strict validation)
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional selectedDoctor) {
        // Validate patient name (non-empty)
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty or blank.");
        }
        this.patientName = patientName.trim();

        // Validate mobile number (10-digit Australian format: e.g., 0412345678)
        String mobileRegex = "^\\d{10}$";
        if (!Pattern.matches(mobileRegex, patientMobile)) {
            throw new IllegalArgumentException("Invalid mobile number. Must be 10 digits (Australian format).");
        }
        this.patientMobile = patientMobile;

        // Validate time slot (HH:MM, 08:00-18:00, 30-minute intervals)
        String timeRegex = "^(08|09|10|11|12|13|14|15|16|17|18):(00|30)$";
        if (!Pattern.matches(timeRegex, timeSlot)) {
            throw new IllegalArgumentException("Invalid time slot. Use HH:MM (08:00-18:00, 30-minute intervals).");
        }
        this.timeSlot = timeSlot;

        // Validate selected doctor (cannot be null)
        if (selectedDoctor == null) {
            throw new IllegalArgumentException("Selected doctor cannot be null.");
        }
        this.selectedDoctor = selectedDoctor;
    }

    // 3. Method to print all instance variables (Part 4 required)
    public void printAppointmentDetails() {
        System.out.println("==================================");
        System.out.println("Appointment Details:");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Preferred Time Slot: " + timeSlot);
        System.out.println("\nAssigned Doctor Details:");
        selectedDoctor.printDetails(); // Polymorphic call (triggers subclass print method)
        System.out.println("==================================");
    }

    // Getters (critical for Part 5: cancel booking by mobile number)
    public String getPatientMobile() {
        return patientMobile;
    }

    public HealthProfessional getSelectedDoctor() {
        return selectedDoctor;
    }

    // Optional Setters (for flexibility, not mandatory but improves reusability)
    public void setPatientName(String patientName) {
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty or blank.");
        }
        this.patientName = patientName.trim();
    }

    public void setPatientMobile(String patientMobile) {
        String mobileRegex = "^\\d{10}$";
        if (!Pattern.matches(mobileRegex, patientMobile)) {
            throw new IllegalArgumentException("Invalid mobile number. Must be 10 digits.");
        }
        this.patientMobile = patientMobile;
    }

    public void setTimeSlot(String timeSlot) {
        String timeRegex = "^(08|09|10|11|12|13|14|15|16|17|18):(00|30)$";
        if (!Pattern.matches(timeRegex, timeSlot)) {
            throw new IllegalArgumentException("Invalid time slot. Use HH:MM (08:00-18:00, 30-minute intervals).");
        }
        this.timeSlot = timeSlot;
    }

    public void setSelectedDoctor(HealthProfessional selectedDoctor) {
        if (selectedDoctor == null) {
            throw new IllegalArgumentException("Selected doctor cannot be null.");
        }
        this.selectedDoctor = selectedDoctor;
    }
}