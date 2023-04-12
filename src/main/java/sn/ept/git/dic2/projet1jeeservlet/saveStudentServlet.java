package sn.ept.git.dic2.projet1jeeservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "saveStudentServlet", value = "/saveStudentServlet")
public class saveStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Form processing...");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String weight=request.getParameter("weight");

//        System.out.println("firstname=" + firstname);
//        System.out.println("lastname=" + lastname);
//        System.out.println("weight=" + weight);

        Student student = new Student();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setWeight(Double.parseDouble(weight));

        System.out.println(student);

        request.getRequestDispatcher("/WEB-INF/ok.html").forward(request,response);
        //request.getRequestDispatcher("/WEB-INF/ok.html").include(request,response);


    }
}
