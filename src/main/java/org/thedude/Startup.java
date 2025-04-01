package org.thedude;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.time.Instant;

@ApplicationScoped
public class Startup {

    static Instant startedAt;

    public void start(@Observes StartupEvent event){
        startedAt = Instant.now();
    }

}
