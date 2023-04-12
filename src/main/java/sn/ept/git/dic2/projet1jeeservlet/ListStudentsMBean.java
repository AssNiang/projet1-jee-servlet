package sn.ept.git.dic2.projet1jeeservlet;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("listStudentsMbean")
@ViewScoped
public class ListStudentsMBean implements Serializable {
    @EJB
    private StudentFacade studentFacade;
    private Student selectedStudent;
    private List<Student> students;

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public List<Student> getStudents() {
        if(students == null){
            students = studentFacade.findAll();
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
