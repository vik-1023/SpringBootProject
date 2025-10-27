package com.employee.management.system.Exception;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	  private String getCurrentISTTime() {
	        // Convert current time to IST and format it
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
	        return LocalDateTime.now(ZoneId.of("Asia/Kolkata"))
	                .atZone(ZoneId.of("Asia/Kolkata"))
	                .format(formatter);
	    }
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>>handelResourceNotFound(ResourceNotFoundException ex){
		
		HashMap<String, Object>response=new HashMap<>();
		response.put("error :", "Not found");
		response.put("Message :",ex.getMessage());
		response.put("status :", HttpStatus.NOT_FOUND.value());
		response.put("timestamp :", getCurrentISTTime());
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
    // Handle all other exceptions (generic)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error :", "Internal Server Error");
        response.put("message :", ex.getMessage());
        response.put("status :", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("timestamp :",getCurrentISTTime());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
