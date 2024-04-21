package az.developia.libraryproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class UserModel {

	@Id
	private String username;
	private String password;
	private Integer enabled;
	private String type;
}
