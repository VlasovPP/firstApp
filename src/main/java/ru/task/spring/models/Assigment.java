package ru.task.spring.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Table(name = "assigment")
@Entity
public class Assigment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assigment_id", nullable = false)
    private int id;

    @NotEmpty(message = "subject of assigment should not be empty")
    @Size(min = 5, max = 50, message = "subject of assigment should be between 5 and 50 characters")
    @Column(name = "subject_of_assigment")
    private String subjectOfAssigment;

    @NotEmpty(message = "executor of assigment id should not be empty")
    @Size(min = 1, max = 30, message = "subject of assigment should be between 1 and 30 characters")
    @Column(name = "executor_of_assigment_id")
    private int executorsOfAssigment;

    @NotEmpty(message = "date of execution should not be empty")
    @Size(min = 5, max = 12, message = "date of execution should be between 5 and 12 characters")
    @Column(name = "date_of_execution")
    private String dateOfExecution;

    @NotEmpty(message = "sing of control should not be empty")
    @Size(min = 2, max = 50, message = "sing of execution should be between 2 and 50 characters")
    @Column(name = "sing_of_control")
    private String singOfControl;

    @NotEmpty(message = "sing of execution should not be empty")
    @Size(min = 2, max = 50, message = "sing of execution should be between 2 and 50 characters")
    @Column(name = "sing_of_execution")
    private String singOfExecution;

    @NotEmpty(message = "text Of assigment should not be empty")
    @Size(min = 5, max = 500, message = "text Of assigment should be between 5 and 500 characters")
    @Column(name = "text_of_assigment")
    private String textOfAssigment;

    public Assigment() {

    }

    public String getTextOfAssigment() {
        return textOfAssigment;
    }

    public void setTextOfAssigment(String textOfAssigment) {
        this.textOfAssigment = textOfAssigment;
    }

    public String getSingOfExecution() {
        return singOfExecution;
    }

    public void setSingOfExecution(String singOfExecution) {
        this.singOfExecution = singOfExecution;
    }

    public String getSingOfControl() {
        return singOfControl;
    }

    public void setSingOfControl(String singOfControl) {
        this.singOfControl = singOfControl;
    }

    public String getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(String dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public int getExecutorsOfAssigment() {
        return executorsOfAssigment;
    }

    public void setExecutorsOfAssigment(int executorsOfAssigment) {
        this.executorsOfAssigment = executorsOfAssigment;
    }

    public String getSubjectOfAssigment() {
        return subjectOfAssigment;
    }

    public void setSubjectOfAssigment(String subjectOfAssigment) {
        this.subjectOfAssigment = subjectOfAssigment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}