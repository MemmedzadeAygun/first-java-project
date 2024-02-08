package az.developia.springjava13.component;

import org.springframework.stereotype.Component;

@Component(value = "myComp1")
public class Computer {
	private Integer id;
	private String model;
	private String color;

	public Computer() {
		this.id = 2;
		this.model = "g62";
		this.color = "Green";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
