package sn.ept.git.dic2.projet1jeeservlet;

import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("addStudentMBean")
@ViewScoped // the object will be deleted if the page is changed.
public class AddStudentMBean implements Serializable {

    private String message;
    @EJB
    private StudentFacade studentFacade;
    private Student student = new Student("200", "Ass", "NIANG", 70.0);

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void save() {
        System.out.println("Saving the student : " + student);
        this.studentFacade.create(student);

        this.message = "Student " + student.getFirstname() + ' ' + student.getLastname() + " saved successfully...";
        this.student = new Student();
    }

}
