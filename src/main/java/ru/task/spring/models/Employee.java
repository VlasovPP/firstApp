package ru.task.spring.models;

import ru.task.spring.controllers.DivisionController;
import ru.task.spring.controllers.OrganizationController;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message = "surname should not be empty")
    @Size(min = 2, max = 30, message = "surname should be between 2 and 30 characters")
    @Column(name = "surname")
    private String surname;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 30, message = "name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "middleName should not be empty")
    @Size(min = 2, max = 30, message = "middleName should be between 2 and 30 characters")
    @Column(name = "middle_name")
    private String middleName;

    @NotEmpty(message = "position should not be empty")
    @Size(min = 2, max = 30, message = "position should be between 2 and 30 characters")
    @Column(name = "\"position\"")
    private String position;

    @Column(name = "division_id")
    private int divisionId;

    @Column(name = "organization_id")
    private int organizationId;

    public Employee() {

    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionName) {
        this.divisionId = divisionName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationName) {
        this.organizationId = organizationName;
    }

    public String nameOrgFromId(int myid) {
        return Objects.requireNonNull(OrganizationController.allOrganization().stream().filter(organization -> organization.getId() == (myid))
                .findFirst()
                .orElse(null)).getNameOfOrganization();
    }

    public String nameDivFromId(int myid) {
        return Objects.requireNonNull(DivisionController.allDivisions().stream().filter(organization -> organization.getId() == (myid))
                .findFirst()
                .orElse(null)).getDivisionName();
    }



}