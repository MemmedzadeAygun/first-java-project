package az.developia.libraryproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryproject.DTO.LibrarianDTO;
import az.developia.libraryproject.DTO.StudentDTO;
import az.developia.libraryproject.exception.MyRuntimeException;
import az.developia.libraryproject.model.AuthorityModel;
import az.developia.libraryproject.model.LibrarianModel;
import az.developia.libraryproject.model.StudentModel;
import az.developia.libraryproject.model.UserModel;
import az.developia.libraryproject.repository.AuthorityRepository;
import az.developia.libraryproject.repository.LibrarianRepository;
import az.developia.libraryproject.repository.StudentRepository;
import az.developia.libraryproject.repository.UserRepository;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins="*")
public class UserRestcontroller {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LibrarianRepository librarianRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;

	
	@PostMapping(path="/librarian")
	public void createLibrarian(@RequestBody LibrarianDTO ldto) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		LibrarianModel lmodel=new LibrarianModel();
		lmodel.setId(ldto.getId());
		lmodel.setName(ldto.getName());
		lmodel.setSurname(ldto.getSurname());
		lmodel.setPhone(ldto.getPhone());
		lmodel.setAddres(ldto.getAddres());
		lmodel.setUsername(ldto.getUsername());
		librarianRepository.save(lmodel);
		
		
		UserModel umodel=new UserModel();
		umodel.setUsername(ldto.getUsername());
		
		String raw=ldto.getPassword();
		String pass="{bcrypt}"+encoder.encode(raw);
		umodel.setPassword(pass);
		umodel.setEnabled(1);
		umodel.setType("librarian");
		userRepository.save(umodel);
		
		
		AuthorityModel amodel=new AuthorityModel();
		amodel.setUsername(umodel.getUsername());
		amodel.setAuthority("ROLE_ADD_STUDENT");
		authorityRepository.save(amodel);
		
	}
	
	
	@GetMapping(path="/login")
	public void login() {
		
	}
	
	
	@PostMapping(path="/student")
	@PreAuthorize(value="hasAuthority('ROLE_ADD_STUDENT')")
	public void createStudent(@RequestBody StudentDTO sdto) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		StudentModel smodel=new StudentModel();
		smodel.setId(sdto.getId());
		smodel.setName(sdto.getName());
		smodel.setSurname(sdto.getSurname());
		smodel.setPhone(sdto.getPhone());
		smodel.setAddres(sdto.getAddres());
		smodel.setUsername(sdto.getUsername());
		smodel.setLibrarian(getUser());
		studentRepository.save(smodel);
		System.out.println(smodel);
		
		UserModel umodel=new UserModel();
		umodel.setUsername(sdto.getUsername());
		
		String raw=sdto.getPassword();
		String pass="{bcrypt}"+encoder.encode(raw);
		umodel.setPassword(pass);
		umodel.setEnabled(1);
		umodel.setType("student");
		userRepository.save(umodel);
		
		
		AuthorityModel amodel=new AuthorityModel();
		amodel.setUsername(umodel.getUsername());
		amodel.setAuthority("ROLE_UPDATE_STUDENT");
		authorityRepository.save(amodel);
		
	}
	
	private String getUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
