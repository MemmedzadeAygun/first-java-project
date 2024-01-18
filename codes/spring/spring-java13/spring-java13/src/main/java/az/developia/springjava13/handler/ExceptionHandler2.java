package az.developia.springjava13.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava13.exception.OurRuntimeException;

@RestControllerAdvice
public class ExceptionHandler2 {

	@ExceptionHandler
	public String handle(OurRuntimeException e) {
		
		return e.getBr().getFieldErrors().get(0).getField();
	}
	
}
