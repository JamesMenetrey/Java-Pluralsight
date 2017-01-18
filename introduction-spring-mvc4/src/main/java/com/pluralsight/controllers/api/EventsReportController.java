package com.pluralsight.controllers.api;

import com.pluralsight.models.Event;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventsReportController {
    @RequestMapping("/api/events")
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();

        Event event1 = new Event();
        event1.setName("Java User Group");
        events.add(event1);

        Event event2 = new Event();
        event2.setName(".NET User Group");
        events.add(event2);

        return events;
    }
}
