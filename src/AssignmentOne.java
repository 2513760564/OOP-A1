/**
 * Main class to demonstrate Part 1 and Part 2 implementations
 * Tests HealthProfessional base class and its subclasses
 */
public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("=== Testing Part 1: HealthProfessional Base Class ===");
        // Test default constructor
        HealthProfessional defaultPro = new HealthProfessional();
        System.out.println("Default Health Professional:");
        defaultPro.printDetails();

        // Test parameterized constructor (valid data)
        try {
            HealthProfessional pro = new HealthProfessional(1001, "Dr. Smith", "MBBS");
            System.out.println("\nValid Health Professional:");
            pro.printDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test invalid data (demonstrates validation)
        try {
            HealthProfessional invalidPro = new HealthProfessional(-1, "", ""); // Invalid ID and name
        } catch (IllegalArgumentException e) {
            System.out.println("\nValidation Test: " + e.getMessage()); // Expected error
        }

        System.out.println("\n=== Testing Part 2: Subclasses ===");
        // Test GeneralPractitioner
        GeneralPractitioner gp = new GeneralPractitioner(2001, "Dr. Lee", "MD", 25);
        gp.printDetails();

        // Test Pediatrician
        Pediatrician ped = new Pediatrician(3001, "Dr. Wong", "Pediatrics Specialist", "0-12 years");
        ped.printDetails();
    }
}