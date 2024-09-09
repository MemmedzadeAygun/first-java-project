package az.developia.libraryproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryproject.DTO.UserDTO;
import az.developia.libraryproject.model.UserDetailModel;
import az.developia.libraryproject.model.UserModel;
import az.developia.libraryproject.repository.UserDetailRepository;
import az.developia.libraryproject.repository.UserRepository;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins="*")
public class UserRestcontroller {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	

	@PostMapping(path="/librarian")
	public void createUser(@RequestBody UserDTO udto) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

		
		UserDetailModel userdetail=new UserDetailModel();
		userdetail.setId(udto.getId());
		userdetail.setName(udto.getName());
		userdetail.setSurname(udto.getSurname());
		userdetail.setEmail(udto.getEmail());
		userdetail.setUsername(udto.getUsername());
		userDetailRepository.save(userdetail);
		
		
		
		UserModel umodel=new UserModel();
		umodel.setUsername(udto.getUsername());
		
		String raw=udto.getPassword();
		String pass="{bcrypt}"+encoder.encode(raw);
		umodel.setPassword(pass);
		userRepository.save(umodel);
		
		
	}
	
	
	@GetMapping(path="/login")
	public void login() {
		
	}
	
//	
//	@PostMapping(path="/student")
//	@PreAuthorize(value="hasAuthority('ROLE_ADD_STUDENT')")
//	public void createStudent(@RequestBody StudentDTO sdto) {
//		
//		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//		
//		StudentModel smodel=new StudentModel();
//		smodel.setId(sdto.getId());
//		smodel.setName(sdto.getName());
//		smodel.setSurname(sdto.getSurname());
//		smodel.setPhone(sdto.getPhone());
//		smodel.setAddres(sdto.getAddres());
//		smodel.setUsername(sdto.getUsername());
//		smodel.setLibrarian(getUser());
//		studentRepository.save(smodel);
//		System.out.println(smodel);
//		
//		UserModel umodel=new UserModel();
//		umodel.setUsername(sdto.getUsername());
//		
//		String raw=sdto.getPassword();
//		String pass="{bcrypt}"+encoder.encode(raw);
//		umodel.setPassword(pass);
//		umodel.setEnabled(1);
//		userRepository.save(umodel);
//		
		
//	}
	
//	private String getUser() {
//		return SecurityContextHolder.getContext().getAuthentication().getName();
//	}
}
