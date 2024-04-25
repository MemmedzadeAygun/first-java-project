package az.developia.testApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
