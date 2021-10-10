package ru.task.spring.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Table(name = "division")
@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private int id;

    @NotEmpty(message = "division_name should not be empty")
    @Size(min = 2, max = 30, message = "division_name should be between 2 and 30 characters")
    @Column(name = "division_name")
    private String divisionName;

    @NotEmpty(message = "contact_details should not be empty")
    @Size(min = 2, max = 30, message = "contact_details should be between 2 and 30 characters")
    @Column(name = "contact_details")
    private String contactDetails;

    @NotEmpty(message = "manager_of_division should not be empty")
    @Size(min = 2, max = 30, message = "manager_of_division should be between 2 and 30 characters")
    @Column(name = "manager_of_division")
    private String managerOfDivision;


    @Column(name = "organization_id")
    private int organizationId;

    public Division(int id, String divisionName, String contactDetails, String managerOgDivision, int organizationId) {
        this.id = id;
        this.divisionName = divisionName;
        this.contactDetails = contactDetails;
        this.managerOfDivision = managerOgDivision;
        this.organizationId = organizationId;
    }

    public Division() {
    }


    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getManagerOfDivision() {
        return managerOfDivision;
    }

    public void setManagerOfDivision(String managerOgDivision) {
        this.managerOfDivision = managerOgDivision;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}