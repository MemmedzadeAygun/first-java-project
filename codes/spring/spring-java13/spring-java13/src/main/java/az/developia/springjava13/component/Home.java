package az.developia.springjava13.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(value = "prototype")
public class Home {
private Integer id;
private String address;
private String color;

public Home() {
	System.out.println("Home object created");
	this.id = 30;
	this.address = "A21";
	this.color = "Grey";
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}
@PostConstruct
public void init() {
	System.out.println("init method");
}
@PreDestroy
public void destroy() {
	System.out.println("destroy method");
}
}


