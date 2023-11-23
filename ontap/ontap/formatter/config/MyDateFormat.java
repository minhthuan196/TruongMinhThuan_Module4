package com.example.demo_spring_jpa_c05.config;

import org.springframework.format.Formatter;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyDateFormat implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        // chuyển từ string sang LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(text, formatter);
        return date;
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        // chuyển localdate => string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = object.format(formatter);
        return dateString;
    }
}
