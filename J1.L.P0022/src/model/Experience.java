package model;

public class Experience extends Candidate {

    private int experienceYear;
    private String professionalSkil;

    public Experience() {
        super();
    }

    public Experience(int experienceYear, String professionalSkil, String id,
            String firstName, String lastName, int birthDate, String address,
            String phone, String email, int candidateType) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.experienceYear = experienceYear;
        this.professionalSkil = professionalSkil;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getProfessionalSkil() {
        return professionalSkil;
    }

    public void setProfessionalSkil(String professionalSkil) {
        this.professionalSkil = professionalSkil;
    }

}
