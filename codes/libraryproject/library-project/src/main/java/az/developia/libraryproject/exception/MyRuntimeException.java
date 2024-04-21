package az.developia.libraryproject.exception;

import org.springframework.validation.BindingResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MyRuntimeException extends RuntimeException{

	private BindingResult result;
}
