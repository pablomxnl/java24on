package org.thedude;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;
import java.time.Instant;


@Path("/api")
public class RuntimeResource {

    @GET
    @Path("/runtime")
    @Produces(MediaType.APPLICATION_JSON)
    public RuntimeInfo runtimeInfo() {
        Instant now = Instant.now();
        Duration elapsed = Duration.between(Startup.startedAt, now);
        String upTime = String.format("%d days %02d h : %02d m :%02d s",
                elapsed.toDays(),
                elapsed.toHoursPart(),
                elapsed.toMinutesPart(),
                elapsed.toSecondsPart());

        return new RuntimeInfo(System.getProperty("java.vm.name"),
                System.getProperty("java.version"),
                upTime, "Hello from Quarkus!");
    }

    public record RuntimeInfo(String jdk, String version, String upTime, String message) {
    }
}
