package ru.task.spring.models;

import javax.persistence.*;

@Table(name = "assigment")
@Entity
public class Assigment {
    @Id
    @Column(name = "assigment_id", nullable = false)
    private int id;


    @Column(name = "subject_of_assigment")
    private String subjectOfAssigment;


    @Column(name = "executorsOfAssigment_id")
    private int executorsOfAssigment;


    @Column(name = "date_of_execution")
    private String dateOfExecution;


    @Column(name = "sing_of_control")
    private String singOfControl;


    @Column(name = "sing_of_execution")
    private String singOfExecution;

    @Column(name = "text_of_assigment")
    private String textOfAssigment;

    public Assigment(){

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