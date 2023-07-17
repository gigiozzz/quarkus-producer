package tiz.biz;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/multipart")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public MultipartDto getMultipart() throws IOException {
        File file = File.createTempFile("abc", "txt");

        var writer = new FileWriter(file);
        writer.write("Test ABC");
        writer.close();

        return new MultipartDto("test text", file);
    }

    @POST
    @Path("/multipart-post")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Consumes(MediaType.APPLICATION_JSON)
    public MultipartDto getMultipartPost(String myName) throws IOException {
        File file = File.createTempFile("abc", "txt");

        var writer = new FileWriter(file);
        writer.write("Test ABC");
        writer.close();

        return new MultipartDto("hello "+myName, file);
    }

}


