package az.developia.testApp.dto;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	@Id
	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
}
