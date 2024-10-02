package model;

public class Internship extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Internship() {
        super();
    }

    public Internship(String majors, String semester, String universityName, 
            String id, String firstName, String lastName, int birthDate, 
            String address, String phone, String email, int candidateType) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }    

}
