package az.developia.springjava13.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SalesmanDTO {

	@Min(value = 0, message = "menfi olmaz")
	private Integer id;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 simvol ola biler")
	private String name;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 simvol ola biler")
	private String surname;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 simvol ola biler")
	private String username;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 simvol ola biler")
	private String password;

	@Pattern(regexp = "[a-z]+@[a-z]+\\.[a-z]{2,4}", message = "emaili duz yaz")
	private String email;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
