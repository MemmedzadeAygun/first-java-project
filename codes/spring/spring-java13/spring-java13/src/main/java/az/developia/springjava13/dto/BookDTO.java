package az.developia.springjava13.dto;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

	private Integer id;

	@Size(min = 2, max = 40, message = "ad min 2 max 40 simvol ola biler")
	private String name;

	@Size(min = 2, max = 40, message = "ad min 2 max 40 simvol ola biler")
	private Integer price;

	@Size(min = 2, max = 40, message = "ad min 2 max 40 simvol ola biler")
	private String author;

	private Integer pageCount;

}
