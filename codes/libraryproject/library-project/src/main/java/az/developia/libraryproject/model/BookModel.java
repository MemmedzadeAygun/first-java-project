package az.developia.libraryproject.model;


import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Entity
@Data
@Table(name="books")
public class BookModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="It can not be empty!")
	@Size(min=2,message="Book name minimum must be 2 symbol!")
	@Size(max=40,message="Book name maximum must be 40 symbol!")
	@Column(columnDefinition="VARCHAR(30)")
	private String name;
	@Min(value=0,message="Price minimum must be 0")
	@Max(value=10_000,message="Price maximum must be 10_000")
	@NotNull(message="Bos qoymaq olmaz!")
	private Double price;
	@CreationTimestamp
	private Timestamp dateOfPublication;
	private String librarian;
}
