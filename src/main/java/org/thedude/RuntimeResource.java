package org.thedude;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/api")
public class RuntimeResource {

    @GET
    @Path("/runtime")
    @Produces(MediaType.APPLICATION_JSON)
    public RuntimeInfo runtimeInfo() {
        return new RuntimeInfo(System.getProperty("java.vm.name"),System.getProperty("java.version"),
                "0", "Hello from Quarkus!");
    }

    public record RuntimeInfo(String jdk, String version, String upTime, String message) {
    }
}
