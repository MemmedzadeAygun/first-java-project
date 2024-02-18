package az.developia.springjava13.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy=EqualityValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Equality {

	public String value() default "student";
	public String message() default "Daxil olan deyer student ile eyni olmalidir";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	
}
