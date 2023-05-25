package com.sg.leo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ZblogExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public String globalExceptionHandler(Exception e) {
		return "<h1> 이런 예외발생 zblogexception hander </h1"
				+ "<br><h2>" + e.getMessage() + "</h2>";
	}

}
