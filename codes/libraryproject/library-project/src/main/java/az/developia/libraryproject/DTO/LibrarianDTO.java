package az.developia.libraryproject.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class LibrarianDTO {

	@Id
	private Integer id;
	private String name;
	private String surname;
	private String phone;
	private String addres;
	private String username;
	private String password;
}
