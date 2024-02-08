package az.developia.springjava13.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "userss")
public class User2Entity {

	@Id
	private String username; // primarykey

	private String password;
	private Integer enabled;
	private String type;
	private String email;

}
