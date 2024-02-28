package az.developia.studentcrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
