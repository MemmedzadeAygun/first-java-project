package az.developia.libraryproject.DTO;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	@Id
	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
}
