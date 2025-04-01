package org.thedude;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class IndexResource {

    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance index();
    }

    @GET
    public TemplateInstance index() {
        return Templates.index();
    }

    @GET
    @Path("travelAdjective")
    @Produces(MediaType.TEXT_PLAIN)
    public String travelAdjective(@QueryParam("countries_visited") int code) {
        return switch(code) {
            case int i when i <=0 -> "QA Tester Traveller";
            case int i when i <=5 ->
                    """
                    Explorer
                        A person who's just starting to explore the world, visiting a few countries.
                    """;
            case int i when i<=10 ->
                    """
                    Traveler
                        Someone who enjoys traveling but hasn't ventured far beyond a handful of destinations.
                    """;
            case int i when i<=20 ->
                    """
                    Adventurer
                        A person who actively seeks out new places and experiences,
                        with a solid amount of travel under their belt.
                    """;
            case int i when i<=30 ->
                    """
                    Wanderer
                        Someone with a keen sense of curiosity, visiting a variety of places across different regions.
                    """;
            case int i when i<=40 ->
                    """
                    Nomad
                        A person who's traveled extensively, and may even travel long-term,
                        hopping between countries frequently.
                    """;
            case int i when i<=50 ->
                    """
                    Jetsetter
                        Someone who is constantly on the move,
                        frequently traveling to diverse and sometimes exotic locations.
                    """;
            case int i when i<=75 ->
                    """
                    Globetrotter
                        An individual who has visited a large portion of the world's countries,
                        embodying the spirit of global travel.
                    """;
            case int i when i<255 ->
                    """
                    World Traveler
                        A true global citizen, having seen a vast majority of the world’s countries,
                        and potentially a well-seasoned expert in travel and cultures.
                    """;
            default -> "Travel freak";
        };
    }
}
