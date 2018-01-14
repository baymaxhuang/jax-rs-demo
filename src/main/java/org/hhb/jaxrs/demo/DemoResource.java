package org.hhb.jaxrs.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path("/rest")
public class DemoResource {

  @GET
  @Path("get")
  @Produces(MediaType.TEXT_PLAIN)
  public String getString() {
    return "hello jersey and jetty!";
  }

  @POST
  @Path("post")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response postJson(InputStream input) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode cfg = mapper.readTree(input);
    System.out.println(cfg.toString());
    return Response.ok(cfg.toString()).build();
  }

}
