package com.example.Assignment.Controller;

import com.example.Assignment.Model.Calendar;
import com.example.Assignment.Model.CalendarInput;
import com.example.Assignment.Model.CalendarOutput;
import com.example.Assignment.Service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/calendarList")
    public List<Calendar> getsCalendarlist() throws ParseException {
        return calendarService.getCalendarList();
    }
    @PostMapping("/findStoreAvailability")
    public CalendarOutput getStaus(@RequestBody CalendarInput calendarInput) throws ParseException {
        calendarService.getCalendarList();
        System.out.println(calendarInput);
        return calendarService.getCalendarOutput(calendarInput);
    }
}
