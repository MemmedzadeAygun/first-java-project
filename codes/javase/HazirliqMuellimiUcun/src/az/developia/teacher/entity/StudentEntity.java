package az.developia.teacher.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class StudentEntity {
	private Integer id;
	private String name;
	private String surname;
	private String phone;
	private LocalDate birthday;
	
	public StudentEntity(Integer id, String name, String surname, String phone, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.birthday = birthday;
	}
	public StudentEntity() {
		// TODO Auto-generated constructor stub.
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birthday, id, name, phone, surname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntity other = (StudentEntity) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(surname, other.surname);
	}
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone
				+ ", birthday=" + birthday + "]";
	}
	public void setBirthday(LocalDateTime localDateTime) {
		
		
	}
	
	
}
