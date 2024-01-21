package az.developia.springjava13.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava13.exception.OurRuntimeException;

@RestControllerAdvice
public class ExceptionHandler2 {

	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public String handle(OurRuntimeException e) {
		
		BindingResult br=e.getBr();
		if(br==null) {
			
		}else {
			
		}
		
		//return e.getBr().getFieldErrors().get(0).getField();
		return e.getMessage();
	}
	
}
