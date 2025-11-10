/**
 * Main class to demonstrate Part 1, Part 2, and Part 3 implementations
 * Tests HealthProfessional base class, its subclasses, and Part 3 requirements
 */
public class AssignmentOne {
    public static void main(String[] args) {
        // Part 1: Test HealthProfessional base class
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

        // Part 2: Test subclasses
        System.out.println("\n=== Testing Part 2: Subclasses ===");
        // Test GeneralPractitioner
        GeneralPractitioner gp = new GeneralPractitioner(2001, "Dr. Lee", "MD", 25);
        gp.printDetails();

        // Test Pediatrician
        Pediatrician ped = new Pediatrician(3001, "Dr. Wong", "Pediatrics Specialist", "0-12 years");
        ped.printDetails();

        // Part 3: New requirements (added after Part 2)
        System.out.println("\n=== Part 3: Health Professional Objects Demonstration ===");
        
        // 1. Create 3 General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Emma Davis", "MBBS", 20);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Liam Wilson", "MD", 18);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Olivia Taylor", "GP Specialist", 22);
        
        // 2. Create 2 Pediatrician objects
        Pediatrician ped1 = new Pediatrician(201, "Dr. Noah Brown", "Pediatrics MD", "0-5 years");
        Pediatrician ped2 = new Pediatrician(202, "Dr. Ava Miller", "Child Health Specialist", "6-12 years");
        
        // 3. Print details for all objects with separators
        System.out.println("\n--- General Practitioners ---");
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        
        System.out.println("\n--- Pediatricians ---");
        ped1.printDetails();
        ped2.printDetails();
        
        // Required separator
        System.out.println("\n==================================");
    }
}