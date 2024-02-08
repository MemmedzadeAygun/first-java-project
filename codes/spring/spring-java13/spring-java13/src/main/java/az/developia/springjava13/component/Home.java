package az.developia.springjava13.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope(value = "prototype")
@Getter
@Setter
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

	@PostConstruct
	public void init() {
		System.out.println("init method");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy method");
	}
}
