package az.developia.springjava13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.SalesmanEntity;
import az.developia.springjava13.dto.SalesmanDTO;
import az.developia.springjava13.entity.User2Entity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.SalesmanRepository;
import az.developia.springjava13.repository.User2Repository;

@RestController
@RequestMapping(path = "/userss")
@CrossOrigin(origins = "*")
public class User2RestController {

	@Autowired
	private SalesmanRepository salesmanRepository;

	@Autowired
	private User2Repository user2Repository;

	@PostMapping(path = "/seller")
	public void createSalesman(@RequestBody SalesmanDTO a) {
		
		Optional<User2Entity> findById = user2Repository.findById(a.getUsername());

		if (findById.isPresent()) { // br- burda validasiya ile bagli sehv deyil ona gore binding result null edilir
			throw new OurRuntimeException(null, "bu username artiq var");
		}

		SalesmanEntity seller = new SalesmanEntity();
		seller.setId(a.getId());
		seller.setName(a.getName());
		seller.setSurname(a.getSurname());
		seller.setUsername(a.getUsername());
		salesmanRepository.save(seller);

		
		User2Entity user2 = new User2Entity();
		user2.setUsername(a.getUsername());
		user2.setEmail(a.getEmail());
		user2.setEnabled(1);
		user2.setPassword(a.getPassword());
		user2.setType("seller");
		
		user2Repository.save(user2);
	}

	@GetMapping(path = "/Login")
	public void Login() {

	}

}
