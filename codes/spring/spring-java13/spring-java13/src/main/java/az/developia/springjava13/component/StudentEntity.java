package az.developia.springjava13.component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity // basina bu annotasiya yazilmis class'dan avtomatik table yaradir
@Table(name = "students") // name'i students olan table yaradir
@Getter
@Setter
public class StudentEntity {

	@Id // hiberante bazada avtomatik id'ni primary key teyin edir
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id'ni autoincrement olaraq teyin edir
	private Integer id;

	@Size(min = 2, max = 40, message = "ad min 2 max 40 simvol ola biler")
	private String name;

	@Size(min = 2, max = 40, message = "ad min 2 max 40 simvol ola biler")
	private String surname;
	
	private Integer teacherId;
}
