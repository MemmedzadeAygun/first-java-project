package az.developia.libraryproject.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.libraryproject.exception.MyRuntimeException;
import az.developia.libraryproject.model.DataWrapper;
import az.developia.libraryproject.model.ErrorResponse;

@RestControllerAdvice
public class ValidationException {

	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public String handleRuntimeException(RuntimeException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public DataWrapper handleMyRuntimeException(MyRuntimeException exception) {
		DataWrapper dataWrapper=new DataWrapper();
		List<ErrorResponse> errors=new ArrayList<>();
		
		BindingResult result=exception.getResult();
		for (FieldError error : result.getFieldErrors()) {
			ErrorResponse errorResponse=new ErrorResponse();
			errorResponse.setField(error.getField());
			errorResponse.setMessage(error.getDefaultMessage());
			errors.add(errorResponse);
		}
		dataWrapper.setValidation(errors);
		
		return dataWrapper;
	}
}
