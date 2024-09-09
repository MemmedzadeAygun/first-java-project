package az.developia.testapp.exception;

import org.springframework.validation.BindingResult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private BindingResult result;
	
	public MyRuntimeException(BindingResult br,String m) {
		super(m);
		this.result=br;
	}
}
