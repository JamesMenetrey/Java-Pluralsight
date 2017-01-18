package com.pluralsight.controllers;

import com.pluralsight.models.Attendee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AttendeeController {
    @RequestMapping(value = "/attendee", method = RequestMethod.GET)
    public String displayAttendee(Model model) {
        Attendee attendee = new Attendee();

        model.addAttribute("attendee", attendee);

        return "attendee/displayAttendee";
    }

    @RequestMapping(value = "/attendee", method = RequestMethod.POST)
    public String processAttendee(@ModelAttribute("attendee") Attendee attendee) {
        System.out.println("Attendee name: " + attendee.getName());

        return "redirect:/";
    }
}
