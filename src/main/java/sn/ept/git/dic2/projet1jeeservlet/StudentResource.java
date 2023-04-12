package sn.ept.git.dic2.projet1jeeservlet;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students")
public class StudentResource {

    @EJB
    private StudentFacade studentFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> getStudentList () {
        return studentFacade.findAll();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student addStudent(Student s){
        Student tmp_s = studentFacade.find(s.getNumber());

        if(tmp_s != null){
            studentFacade.remove(tmp_s);
        }
        studentFacade.create(s);

        return s;
    }

    @GET
    @Path("{number}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response find(@PathParam("number") String number) {
        Student s = studentFacade.find(number);
        if(s == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.FOUND).entity(s).build();
    }

    @DELETE
    @Path("{number}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response delete(@PathParam("number") String number) {
        Student s = studentFacade.find(number);
        if(s == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        studentFacade.remove(s);
        MyResponse myResponse = new MyResponse("The student " + s.getFirstname() + " was deleted successfully.");
        return Response.status(Response.Status.OK).entity(myResponse).build();
    }
}
