/**
 * Base class for all health professionals (Part 1 requirement)
 * Encapsulates common attributes and behaviors of health workers.
 */
public class HealthProfessional {
    // Required attributes: ID (numeric only), name, and 1 common attribute (professional title)
    private int id; // Numeric ID enforced by int type + validation
    private String name;
    private String professionalTitle; // Common attribute (e.g., "MBBS", "MD")

    // 1. Default constructor (Part 1 required)
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unnamed";
        this.professionalTitle = "Undefined";
    }

    // 2. Parameterized constructor with validation (Part 1 required)
    public HealthProfessional(int id, String name, String professionalTitle) {
        // Validate ID (must be positive)
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        this.id = id;

        // Validate name (non-empty)
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();

        // Validate professional title (non-empty)
        if (professionalTitle == null || professionalTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Professional title cannot be empty.");
        }
        this.professionalTitle = professionalTitle.trim();
    }

    // 3. Method to print all attributes (Part 1 required)
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Professional Title: " + professionalTitle);
    }

    // Getters and Setters (encapsulation: control access to private fields)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        if (professionalTitle == null || professionalTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Professional title cannot be empty.");
        }
        this.professionalTitle = professionalTitle.trim();
    }
}
