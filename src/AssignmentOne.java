import java.util.ArrayList;
import java.util.Iterator;

/**
 * Integrates health professional classes and appointment management system
 */
public class AssignmentOne {
    // Part 5: Static ArrayList to store Appointment objects (shared across methods)
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // ------------------------------ Part 1: HealthProfessional Base Class Test
        System.out.println("=== Testing Part 1: HealthProfessional Base Class ===");
        HealthProfessional defaultPro = new HealthProfessional();
        System.out.println("Default Health Professional:");
        defaultPro.printDetails();

        try {
            HealthProfessional pro = new HealthProfessional(1001, "Dr. Smith", "MBBS");
            System.out.println("\nValid Health Professional:");
            pro.printDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            new HealthProfessional(-1, "", ""); // Omit unused variable to avoid warning
        } catch (IllegalArgumentException e) {
            System.out.println("\nValidation Test: " + e.getMessage());
        }

        // ------------------------------ Part 2: Subclass Test
        System.out.println("\n=== Testing Part 2: Subclasses ===");
        GeneralPractitioner gpTest = new GeneralPractitioner(2001, "Dr. Lee", "MD", 25);
        gpTest.printDetails();
        Pediatrician pedTest = new Pediatrician(3001, "Dr. Wong", "Pediatrics Specialist", "0-12 years");
        pedTest.printDetails();

        // ------------------------------ Part 3: Health Professional Objects
        System.out.println("\n=== Part 3: Health Professional Objects Demonstration ===");
        // Create 3 General Practitioners
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Emma Davis", "MBBS", 20);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Liam Wilson", "MD", 18);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Olivia Taylor", "GP Specialist", 22);
        // Create 2 Pediatricians
        Pediatrician ped1 = new Pediatrician(201, "Dr. Noah Brown", "Pediatrics MD", "0-5 years");
        Pediatrician ped2 = new Pediatrician(202, "Dr. Ava Miller", "Child Health Specialist", "6-12 years");
        // Print all professionals
        System.out.println("\n--- General Practitioners ---");
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        System.out.println("\n--- Pediatricians ---");
        ped1.printDetails();
        ped2.printDetails();
        System.out.println("\n------------------------------");

        // ------------------------------ Part 5: Collection of Appointments (Mandatory)
        // Add required comment (per assignment brief)
        // Part 5 – Collection of appointments
        System.out.println("=== Part 5: Appointment Management System ===");
        
        // Step 1: Create 4 appointments (2 GP + 2 Pediatrician, per Part 5 requirement)
        System.out.println("\n1. Creating Appointments...");
        try {
            // 2 Appointments with General Practitioners (gp1 and gp2)
            createAppointment("Alice Johnson", "0412345678", "10:30", gp1);
            createAppointment("Bob Smith", "0423456789", "14:00", gp2);
            // 2 Appointments with Pediatricians (ped1 and ped2)
            createAppointment("Charlie Green", "0434567890", "09:00", ped1);
            createAppointment("Diana White", "0445678901", "15:30", ped2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating appointments: " + e.getMessage());
        }

        // Step 2: Print existing appointments
        System.out.println("\n2. Existing Appointments After Creation:");
        printExistingAppointments();

        // Step 3: Cancel one appointment (use Bob's mobile: 0423456789)
        System.out.println("\n3. Canceling Appointment (Mobile: 0423456789)...");
        cancelBooking("0423456789");

        // Step 4: Print updated appointments
        System.out.println("\n4. Existing Appointments After Cancellation:");
        printExistingAppointments();

        // Add required separator (per Part 5 formatting rule)
        System.out.println("\n------------------------------");
    }

    /**
     * Part 5 Required Method: Creates a new appointment and adds it to the ArrayList
     * Polymorphic support: Accepts any HealthProfessional subclass (GP/Pediatrician)
     * Validates that no required info is null/empty before creation
     * @param patientName Patient's full name (non-empty)
     * @param patientMobile Patient's 10-digit mobile number
     * @param timeSlot Preferred time (HH:MM, 08:00-18:00, 30-min intervals)
     * @param selectedDoctor HealthProfessional subclass object (GP/Pediatrician)
     */
    private static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional selectedDoctor) {
        // Pre-validation (redundant but adds safety; Appointment constructor will re-validate)
        if (patientName == null || patientMobile == null || timeSlot == null || selectedDoctor == null) {
            throw new IllegalArgumentException("All appointment fields (name, mobile, time, doctor) are required.");
        }
        // Create Appointment object (triggers constructor validation)
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, selectedDoctor);
        appointmentList.add(newAppointment);
        System.out.println("✓ Appointment created for " + patientName + " (Doctor: " + selectedDoctor.getName() + ")");
    }

    /**
     * Part 5 Required Method: Prints all appointments in the ArrayList
     * Shows a message if no appointments exist (per Part 5 requirement)
     */
    private static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments in the system.");
            return;
        }
        // Iterate through the list and print each appointment's details
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("\n--- Appointment " + (i + 1) + " ---");
            appointmentList.get(i).printAppointmentDetails();
        }
    }

    /**
     * Part 5 Required Method: Cancels an appointment by patient's mobile number
     * Uses Iterator to avoid ConcurrentModificationException (safe removal)
     * Shows an error message if the mobile number is not found
     * @param patientMobile 10-digit mobile number of the patient
     */
    private static void cancelBooking(String patientMobile) {
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean isCancelled = false;

        while (iterator.hasNext()) {
            Appointment currentAppt = iterator.next();
            // Match mobile number (case-insensitive, though mobile is numeric here)
            if (currentAppt.getPatientMobile().equals(patientMobile)) {
                iterator.remove(); // Safe removal (avoids exception vs. for-each loop)
                System.out.println("✓ Appointment canceled for mobile number: " + patientMobile);
                isCancelled = true;
                break; // Cancel only one appointment (per typical real-world logic)
            }
        }

        // Show error if no matching appointment
        if (!isCancelled) {
            System.out.println("Error: No appointment found for mobile number: " + patientMobile);
        }
    }
}