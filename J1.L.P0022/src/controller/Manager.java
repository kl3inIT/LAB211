package controller;

import model.Fresher;
import model.Experience;
import model.Internship;
import model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import util.Validation;

public class Manager {

    private final ArrayList<Candidate> candidateList = new ArrayList<>();

    public void createCandidate(int type) {
        String id;
        do {
            while (true) {
                id = Validation.getValidString("Input Candidate ID(CXXX): ",
                        "The format of id is CXXX(X stands for digit) ",
                        "^[C|c]\\d{3}$");
                Candidate candidate = findCandidateObjectbyId(id);

                if (candidate != null) {
                    System.out.println("The candidate ID is already exist. Input"
                            + " another one.");
                } else {
                    break;
                }
            }

            String firstName = Validation.getValidString("Input First Name: ",
                    "Please input valid name.", "[A-Za-z\\s]+");
            String lastName = Validation.getValidString("Input Last Name: ",
                    "Please input valid name.", "[A-Za-z\\s]+");
            int birthDate = Validation.getAnInteger("Input Birth Date: ",
                    "Please input Birth Date in range 1900 to curent year.",
                    1900, Calendar.getInstance().get(Calendar.YEAR));
            String address = Validation.getString("Input address: ",
                    "Address is required");
            String phone = Validation.getValidString("Input phone number: ",
                    "Phone is number with minumum 10 characters",
                    "^\\d{10}\\d*$");
            String email = Validation.getValidString("Input email: ",
                    "Format of email is <account name>@<domain>.",
                    "^[A-Za-z0-9+._-]+@[A-Za-z.-]+\\.[A-Za-z]{2,}$");

            switch (type) {
                case 0:
                    int experienceYear = Validation.getAnInteger("Input Year "
                            + "of Experience: ", "Year of Experience in "
                            + "range 1 to 100.", 1, 100);
                    String proSkill = Validation.getString("Input Professional Skill: ",
                            "Professional Skill is required");
                    candidateList.add(new Experience(experienceYear, proSkill,
                            id, firstName, lastName, birthDate, address, phone, email, type));
                    break;
                case 1:
                    String graduationDate = Validation.getString("Input Graduation Date: ",
                            "Graduation Date is required.");
                    String graduationRank = Validation.getGraduationRank();
                    String education = Validation.getValidString("Input University where"
                            + " student graduated: ", "University of student is required.",
                            "^[A-Za-z\\s]+$");
                    candidateList.add(new Fresher(graduationDate, graduationRank,
                            education, id, firstName, lastName, birthDate, address,
                            phone, email, type));
                    break;
                case 2:
                    String majors = Validation.getValidString("Input majors"
                            + "of student: ", "Majors of student is required.",
                            "^[A-Za-z\\s]+$");
                    String semester = Validation.getString("Input Semester: ",
                            "Semester is required");
                    String universityName = Validation.getValidString("Input University name: ",
                            "University name is required.", "^[A-Za-z\\s]+$");
                    candidateList.add(new Internship(majors, semester, universityName,
                            id, firstName, lastName, birthDate, address, phone, email, type));

                    break;
            }

            System.out.println("------------------------------------");

            if (!Validation.getChoice("Do you want to continue (Y/N)?: ",
                    "Please input y/Y or n/N", "Y", "N")) {
                printListNameCandidate();
                break;
            }

        } while (true);
    }

    private Candidate findCandidateObjectbyId(String id) {
        if (candidateList.isEmpty()) {
            return null;
        }

        for (Candidate candidate : candidateList) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                return candidate;
            }
        }

        return null;
    }

    public void searchCandidate() {
        printListNameCandidate();
        String name = Validation.getValidString("Input Candidate name "
                + "(First name or Last name): ", "Please input first"
                + " name or last name to search.", "[A-Za-z\\s]+");
        int type = Validation.getAnInteger("Input type of Candidate: ",
                "Type of Candidate is from 0 to 2", 0, 2);
        System.out.println("The candidates found: ");
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateType() == type
                    && (candidate.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || candidate.getLastName().toUpperCase().contains(name.toUpperCase()))) {
                System.out.println(candidate.toString());
            }
        }
    }

    public void printListNameCandidate() {
        if (candidateList.isEmpty()) {
            return;
        }

        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

}
