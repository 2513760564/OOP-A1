public class Pediatrician extends HealthProfessional {
    private String ageRangeSpecialization;

    public Pediatrician() {
        super();
        this.ageRangeSpecialization = "0-18 years";
    }

    public Pediatrician(int id, String name, String professionalTitle, String ageRangeSpecialization) {
        super(id, name, professionalTitle);
        if (ageRangeSpecialization == null || ageRangeSpecialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Age range specialization cannot be empty.");
        }
        this.ageRangeSpecialization = ageRangeSpecialization.trim();
    }

    @Override
    public void printDetails() {
        System.out.println("==================================");
        System.out.println("Professional Type: Pediatrician");
        super.printDetails();
        System.out.println("Age Range Specialization: " + ageRangeSpecialization);
        System.out.println("==================================");
    }

    public String getAgeRangeSpecialization() {
        return ageRangeSpecialization;
    }

    public void setAgeRangeSpecialization(String ageRangeSpecialization) {
        if (ageRangeSpecialization == null || ageRangeSpecialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Age range specialization cannot be empty.");
        }
        this.ageRangeSpecialization = ageRangeSpecialization.trim();
    }
}