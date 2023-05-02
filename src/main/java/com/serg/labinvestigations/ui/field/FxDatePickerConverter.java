package com.serg.labinvestigations.ui.field;

import javafx.util.StringConverter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class FxDatePickerConverter extends StringConverter
{
    // Default Date Pattern
    private String pattern = "dd.MM.yyyy";
    // The Date Time Converter
    private DateTimeFormatter dtFormatter;

    public FxDatePickerConverter()
    {
        dtFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    public FxDatePickerConverter(String pattern)
    {
        this.pattern = pattern;
        dtFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    // Change String to LocalDate
    public LocalDate fromString(String text)
    {
        LocalDate date = null;

        if (text != null && !text.trim().isEmpty())
        {
            date = LocalDate.parse(text, dtFormatter);
        }

        return date;
    }

    // Change LocalDate to String
    @Override
    public String toString(Object date)
    {
        String text = null;

        if (date != null)
        {
            text = dtFormatter.format((LocalDate) date);
        }

        return text;
    }
}