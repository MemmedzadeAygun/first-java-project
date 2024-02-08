package az.developia.springjava13.component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;



import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id sahesinin avtomatik artan deyere malik olmasina sebeb										// olur.
	private Integer id;

	@Size(min = 2, max = 40, message = "ad min 2 max 40 simvol ola biler")
	private String name;
	private Integer price;
	private String author;
	private Integer pageCount;


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", pageCount="
				+ pageCount + "]";
	}

}

