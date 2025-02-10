package org.example;

import java.util.ArrayList;
import java.util.List;

// Abstract Class for Job Roles
abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public abstract void evaluateResume();
}

// Software Engineer Role
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Screening Resume for Software Engineer: " + getCandidateName() +
                " with " + getExperienceYears() + " years of experience.");
    }
}

// Data Scientist Role
class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Screening Resume for Data Scientist: " + getCandidateName() +
                " with " + getExperienceYears() + " years of experience.");
    }
}

// Product Manager Role
class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Screening Resume for Product Manager: " + getCandidateName() +
                " with " + getExperienceYears() + " years of experience.");
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void processResume() {
        jobRole.evaluateResume();
    }
}

// Resume Screening System
class ResumeScreening {
    private List<JobRole> resumes = new ArrayList<>();

    // Generic Method to Add Resume
    public <T extends JobRole> void addResume(Resume<T> resume) {
        resumes.add(resume.getJobRole());
    }

    // Display All Resumes
    public void displayResumes() {
        System.out.println("\nProcessing Resumes:");
        for (JobRole role : resumes) {
            role.evaluateResume();
        }
    }

    // Wildcard Method to Process Any Job Role
    public static void processAllResumes(List<? extends JobRole> jobRoles) {
        System.out.println("\nBatch Resume Processing:");
        for (JobRole role : jobRoles) {
            role.evaluateResume();
        }
    }
}

// Main Class
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        ResumeScreening screeningSystem = new ResumeScreening();

        // Creating Job Role Resumes
        SoftwareEngineer se = new SoftwareEngineer("Alice", 5);
        DataScientist ds = new DataScientist("Bob", 3);
        ProductManager pm = new ProductManager("Charlie", 7);

        // Wrapping Resumes in Generic Class
        Resume<SoftwareEngineer> seResume = new Resume<>(se);
        Resume<DataScientist> dsResume = new Resume<>(ds);
        Resume<ProductManager> pmResume = new Resume<>(pm);

        // Adding Resumes to the Screening System
        screeningSystem.addResume(seResume);
        screeningSystem.addResume(dsResume);
        screeningSystem.addResume(pmResume);

        // Display All Resumes
        screeningSystem.displayResumes();

        // Wildcard Method to Process Any Job Role
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(se);
        jobRoles.add(ds);
        jobRoles.add(pm);

        ResumeScreening.processAllResumes(jobRoles);
    }
}
