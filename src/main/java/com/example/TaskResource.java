package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("exec")
public class TaskResource {

    private static final Logger LOGGER = Logger.getLogger(TaskResource.class.getName());

    @Inject
    private TaskService service;

    @POST
    public Response enqueue() {
        LOGGER.log(Level.INFO, "### Received.");
        if(service.add()){
            return Response.ok().build();
        }
        return Response.status(Status.SERVICE_UNAVAILABLE).build();
    }

}
