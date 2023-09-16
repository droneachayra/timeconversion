package com.timeconversion.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.timeconversion.service.TimeConversionService;



@RestController
public class TimeConversionController {
	
	 private final TimeConversionService timeConversionService;

	    @Autowired
	    public TimeConversionController(TimeConversionService timeConversionService) {
	        this.timeConversionService = timeConversionService;
	    }

	    @GetMapping("/convertTime")
	    public String convertTimeToWords(@RequestParam String time) {
	        return timeConversionService.convertTimeToWords(time);
	    }

}
