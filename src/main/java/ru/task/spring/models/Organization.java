package ru.task.spring.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Table(name = "organization")
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private int organizationId;

    @NotEmpty(message = "name_of_organization should not be empty")
    @Size(min = 2, max = 30, message = "name_of_organization should be between 2 and 30 characters")
    @Column(name = "name_of_organization")
    private String nameOfOrganization;

    @NotEmpty(message = "physical_address should not be empty")
    @Size(min = 2, max = 30, message = "physical_address should be between 2 and 30 characters")
    @Column(name = "physical_address")
    private String physicalAddress;

    @NotEmpty(message = "legal_address should not be empty")
    @Size(min = 2, max = 30, message = "legal_address should be between 2 and 30 characters")
    @Column(name = "legal_address")
    private String legalAddress;

    @NotEmpty(message = "legal_address should not be empty")
    @Size(min = 2, max = 30, message = "legal_address should be between 2 and 30 characters")
    @Column(name = "name_of_director")
    private String nameOfDirector;

    public Organization() {

    }

    public Organization(int organizationId, String nameOfOrganization, String physicalAddredd, String legalAddress, String nameOfDirector) {
        this.organizationId = organizationId;
        this.nameOfOrganization = nameOfOrganization;
        this.physicalAddress = physicalAddredd;
        this.legalAddress = legalAddress;
        this.nameOfDirector = nameOfDirector;
    }

    public int getId() {
        return organizationId;
    }

    public void setId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getNameOfDirector() {
        return nameOfDirector;
    }

    public void setNameOfDirector(String nameOfDirector) {
        this.nameOfDirector = nameOfDirector;
    }
}