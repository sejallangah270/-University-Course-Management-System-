public class Instructor {

    private int instructorId;
    private String name;
    private String specialization;

    public Instructor(int instructorId, String name, String specialization) {
        this.instructorId = instructorId;
        this.name = name;
        this.specialization = specialization;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void displayInstructor() {
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}