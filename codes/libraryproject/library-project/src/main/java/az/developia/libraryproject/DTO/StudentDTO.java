package az.developia.libraryproject.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDTO {
	@Id
	private Integer id;
	@Size(min=2,message="Ad minimum 2 simvol olmalidir!")
	@Size(max=20,message="Ad maksimum 20 simvol olmalidir.")
	private String name;
	@Size(min=2,message="Ad minimum 2 simvol olmalidir!")
	@Size(max=40,message="Ad maksimum 40 simvol olmalidir.")
	private String surname;
	@Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
	private String phone;
	@Size(max=200,message="Unvan maksimum 200 simvol ola biler")
	private String addres;
	@Size(min=2,message="Ad minimum 2 simvol olmalidir!")
	@Size(max=20,message="Ad maksimum 20 simvol olmalidir.")
	@NotEmpty(message="Bos qoymaq olmaz!")
	private String username;
	@Size(min=2,message="Ad minimum 2 simvol olmalidir!")
	@Size(max=20,message="Ad maksimum 20 simvol olmalidir.")
	@NotEmpty(message="Bos qoymaq olmaz!")
	private String password;
}
