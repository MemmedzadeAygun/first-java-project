package az.developia.springjava13.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "authorities")
@Entity
public class AuthorityEntity {

	@Id // hiberante bazada avtomatik id'ni primary key teyin edir
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id'ni autoincrement olaraq teyin edir
	private Integer id;

	private String username;
	
	private String authority; // deaktiv etmek uchundur. Meselen isci isden cixdiqda o bazadan cixarilmir.
								// sadece dondurulur ve ise geri dondukde ise aktiv edilir

}

