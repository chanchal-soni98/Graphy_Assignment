package com.graphy.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(EmailException.class)
//	public ResponseEntity<MyErrorDetails> myIllegalHandler(EmailException ie,WebRequest req){	
//		
//		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
//
//		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
//	}	
//	@ExceptionHandler(EmailException.class)
//	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e,WebRequest req) {
//		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
//
//		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
//	}
}
