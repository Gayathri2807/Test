package com.example.Assignment.Service;

import com.example.Assignment.Model.Calendar;
import com.example.Assignment.Model.CalendarInput;
import com.example.Assignment.Model.CalendarOutput;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalendarService {

    List<Calendar> calendarList = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");

    public List<Calendar> getCalendarList() throws ParseException {

        Date time1 = formatter.parse("13:30");
        Date time2 = formatter.parse("13:30");
        Date time3 = formatter.parse("13:30");

        calendarList.add(new Calendar("STORE001", "ALL", formatter.format(time1)));
        calendarList.add(new Calendar("STORE002", "SUNDAY", formatter.format(time2)));
        calendarList.add(new Calendar("STORE003", "MONDAY", formatter.format(time3)));

        return calendarList;
    }

    public CalendarOutput getCalendarOutput(CalendarInput calendarInput) throws ParseException {

        final List<Integer> BUSINESS_DAYS = Arrays.asList(
                Calendar.SAT,Calendar.SUN,Calendar.MON,Calendar.TUE,
                Calendar.WED,Calendar.THU,Calendar.FRI);

        CalendarOutput calendarOutput = null;
        if(calendarInput.getStoreID().equals("STORE001")) {
            calendarOutput = new CalendarOutput(calendarInput, "Available");
        }
        else
        {
            Date date = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss.SSS'Z'").parse(calendarInput.getRequestDate());
            System.out.println(date);
            //System.out.println(date.getDay());

            for(Integer b: BUSINESS_DAYS)
            {
                if(b.equals(date.toString(getDate()))){
                    //System.out.println(b);

                    if(b.equals(0) && calendarInput.getStoreID().equals("STORE002")){
                        calendarOutput = new CalendarOutput(calendarInput, "Available");
                    }
                    else if(b.equals(1) && calendarInput.getStoreID().equals("STORE003")){
                        calendarOutput = new CalendarOutput(calendarInput, "Available");
                    }
                    else {
                        calendarOutput = new CalendarOutput(calendarInput, "Not Available");
                    }
                }
            }
        }
        return calendarOutput;
    }
}
    /*
    public CalendarOutput findStoreAvailability(CalendarInput calendarInput) {
        final List<Integer> BUSINESS_DAYS = Arrays.asList(
                Calendar.SATURDAY, Calendar.SUNDAY, Calendar.MONDAY, Calendar.TUESDAY,
                Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY);

        CalendarOutput calendarOutput = null;
        for (Calendar c : calendarList) {
            if (c.getDay().equals(BUSINESS_DAYS)) {
                List<Calendar> calendersList = calendarList.stream().filter(cal -> cal.getLocationID().equals(calendarInput.getLocationID())).collect(Collectors.toList());
                if (calendersList != null) {
                    String calendars = calendersList.stream().filter(cal -> cal.getCutOffTime().compareTo(calendarInput.getRequestDate()) < 0)
                            .map();

                    //String calendars = calendarList.stream().filter(cal -> cal.getLocationID().equals(calendarInput.getStoreID()))
                    //   .map(cal -> cal.getCutOffTime()).findFirst().orElse(null);
                    System.out.println(calendars);
/*
                if(calenders)
                if (calendars.equals("STORE001")) {
                    calendarOutput = new CalendarOutput(calendarInput, "Available");
                }

                } else {
                    calendarOutput = new CalendarOutput(calendarInput, "NOt Available");
                }
            }

        }
        return calendarOutput;
    }
    */

