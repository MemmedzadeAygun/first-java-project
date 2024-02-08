package az.developia.springjava13.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

	@Id
	private String username; // primarykey

	private String password;
	private Integer enabled; // deaktiv etmek uchundur. Meselen isci isden cixdiqda o bazadan cixarilmir.
								// sadece dondurulur ve ise geri dondukde ise aktiv edilir
	private String type;
	private String email;

	
}
