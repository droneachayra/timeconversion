package com.timeconversion.serviceimpl;

import org.springframework.stereotype.Service;

import com.timeconversion.service.TimeConversionService;

import java.time.LocalTime;
import java.util.Locale;

@Service
public class TimeConversionServiceImpl implements TimeConversionService {

    @Override
    public String convertTimeToWords(String time) {
        try {
            LocalTime localTime = LocalTime.parse(time);
            String timeInWords = convertToWords(localTime);
            return "It's " + timeInWords;
        } catch (Exception e) {
            return "Invalid time format. Please use HH:mm.";
        }
    }

    private String convertToWords(LocalTime time) {
    	  int hour = time.getHour();
        int minute = time.getMinute();
        
        String[] hours = {
            "Midnight", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Noon"
        };

        String[] minutes = {
            "", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty"
        };

        String timeInWords = "";
        
        if (hour == 12 && minute == 0) {
            return "Noon";
        } else if (hour == 0 && minute == 0) {
            return "Midnight";
        }

        if (hour >= 1 && hour <= 12) {
            timeInWords = hours[hour];
        }

        if (minute >= 1 && minute <= 19) {
            timeInWords += " " + minutes[minute];
        } else if (minute >= 20 && minute <= 59) {
            int tensDigit = minute / 10;
            int onesDigit = minute % 10;
            timeInWords += " " + tens[tensDigit];
            if (onesDigit > 0) {
                timeInWords += " " + minutes[onesDigit];
            }
        }

        return timeInWords.toLowerCase(Locale.ROOT);
    }
}

