package az.developia.studentcrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Bosh qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazilmalidir!")
	@Size(max=30,message="Maksimum 30 simvol yazilmalidir!")
	private String name;
	
	@NotEmpty(message="Bosh qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazilmalidir!")
	@Size(max=30,message="Maksimum 30 simvol yazilmalidir!")
	private String surname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
