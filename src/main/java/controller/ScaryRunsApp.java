package controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/") //You may want to add a value here so that all traffic isn't routed to the class below.

public class ScaryRunsApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(Game.class);
        h.add(Video.class);
        h.add(Profile.class);

        return h;
    }
}