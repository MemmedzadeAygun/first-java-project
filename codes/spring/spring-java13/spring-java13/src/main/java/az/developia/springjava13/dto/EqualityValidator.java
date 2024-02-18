package az.developia.springjava13.dto;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualityValidator implements ConstraintValidator<Equality, String>{

	private String otherData;
	
	@Override
	 public void initialize(Equality data) {
		otherData=data.value();
   }
	
	@Override
	public boolean isValid(String data, ConstraintValidatorContext context) {
		boolean result;
		if(data!=null)
		{
			result=data.equals(otherData);
		}
		else
		{
			result=true;
		}
		return result;
	}

}
