package sn.ept.git.dic2.projet1jeeservlet;

import java.io.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello/*","/good-morning","/good-night"})
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }
    //private String message = "Hello DIC2";

    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String jpqlRequest = "SELECT e FROM Student E";
        Query q = entityManager.createQuery(jpqlRequest);
        List<Student> students = q.getResultList();

        // Hello
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");

        writer.println("<h1>" + message + "</h1>");

        writer.print("request.getPathInfo() = ");
        writer.print(request.getPathInfo());
        writer.print("<br>");

        writer.print("request.getServletPath() = ");
        writer.print(request.getServletPath());
        writer.print("<br>");

        writer.print("request.getContextPath() = ");
        writer.print(request.getContextPath());
        writer.print("<br>");

        writer.print("request.getRemoteHost() = ");
        writer.print(request.getRemoteHost());
        writer.print("<br>");

        writer.print("request.getRemoteAddr() = ");
        writer.print(request.getRemoteAddr());
        writer.print("<br>");

        writer.print("request.getRemoteUser() = ");
        writer.print(request.getRemoteUser());
        writer.print("<br>");

        writer.print("request.getRemotePort() = ");
        writer.print(request.getRemotePort());
        writer.print("<br>");

        writer.print("request.getParameter() 'firstname' = ");
        writer.print(request.getParameter("firstname"));
        writer.print("<br>");

        writer.println("</body></html>");
    }
/*
    public void destroy() {
    }
*/
}