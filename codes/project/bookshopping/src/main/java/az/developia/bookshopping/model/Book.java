package az.developia.bookshopping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	@NotEmpty(message="Bos qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=30,message="Maksimum 30 simvol yazmaq olar")
	@Column(columnDefinition="VARCHAR(30)")
	private String name;
	@Column(columnDefinition="VARCHAR(300)")
	@Size(max=300,message="Maksimum 300 simvol yazmaq olar")
	private String description;
	@Min(value=0,message="Minimum 0 yazmaq olar")
	@Max(value=1000,message="Maksimum 1000 yazmaq olar")
	@NotNull(message="Bos qoymaq olmaz")
	private Double price;
	@Column(columnDefinition="VARCHAR(30)")
	@Size(max=30,message="Maksimum 30 simvol yazmaq olar")
	private String author;
	@Min(value=0,message="Minimum 0 yazmaq olar")
	@Max(value=1000,message="Maksimum 1000 yazmaq olar")
	private Integer pagesCount;
	private String image;
	private String username;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPagesCount() {
		return pagesCount;
	}
	public void setPagesCount(Integer pagesCount) {
		this.pagesCount = pagesCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", author="
				+ author + ", pagesCount=" + pagesCount + ", image=" + image + ", username=" + username + "]";
	}
	
	
}
