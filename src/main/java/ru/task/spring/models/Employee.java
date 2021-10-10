package ru.task.spring.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    public Employee() {

    }

    public Employee(Integer id, String surname, String name, String middleName, String position, Division division) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.division = division;
    }



    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
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
}