package az.developia.bookshopping.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {

	@Size(min=1,message="Istifadeci adi minimum 1 simvol olmalidir")
	@Size(max=30,message="Istifadeci adi maksimum 30 simvol olmalidir")
	@NotEmpty(message="Bos qoymaq olmaz")
	private String username;
	@Size(min=1,message="Sifre minimum 1 simvol olmalidir")
	@Size(max=30,message="Sifre maksimum 30 simvol olmalidir")
	@NotEmpty(message="Bos qoymaq olmaz")
	private String password;
	
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
