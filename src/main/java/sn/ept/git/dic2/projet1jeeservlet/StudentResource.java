package sn.ept.git.dic2.projet1jeeservlet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Delete a student",
            description = "Delete the student whose id match the given one as parameter",
            responses = {
                    @ApiResponse(
                            responseCode = "404",
                            description = "The student with the specified id is not found",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON,
                                            examples = {
                                                    @ExampleObject(
                                                            name = "Student not found",
                                                            value = "{msg: The student whose id is dic2_44 is not found.}"
                                                    )
                                            }
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "200",
                            description = "The student with the specified id is successfully deleted"
                    )
            }
    )
//    @ApiResponses({
//            @ApiResponse(
//                    responseCode = "404",
//                    description = "The student with the specified id is not found"
//            ),
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "The student with the specified id is successfully deleted"
//            )
//    })
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
