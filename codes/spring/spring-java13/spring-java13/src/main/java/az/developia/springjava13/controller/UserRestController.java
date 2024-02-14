package az.developia.springjava13.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.StudentEntity;
import az.developia.springjava13.component.TeacherEntity;
import az.developia.springjava13.dto.StudentDTO;
import az.developia.springjava13.dto.TeacherDTO;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*") // sayta her yerde daxil ola bilmek ucun ulduz simvolundan istifade olunur,yeni
							// her kese daxil olmaq icazesi verilir. general api'ler adlanir
@RequiredArgsConstructor
public class UserRestController {

	
	private final TeacherRepository teacherRepository;
	
	
	private final StudentRepository studentRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@PostMapping(path = "/teacher")
	@ApiOperation(value="Muellimin muellim ve user olaraq qeydiyyati uchun olan api ve onun huquqlari")
	public void createTeacher(@RequestBody TeacherDTO d) {

		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		Optional<UserEntity> findById = userRepository.findById(d.getUsername());

		if (findById.isPresent()) { // br- burda validasiya ile bagli sehv deyil ona gore binding result null edilir
			throw new OurRuntimeException(null, "bu username artiq var");
		}

		TeacherEntity e = new TeacherEntity();
		e.setId(d.getId());
		e.setName(d.getName());
		e.setSurname(d.getSurname());
		e.setUsername(d.getUsername());
		teacherRepository.save(e);

		UserEntity user = new UserEntity();
		user.setUsername(d.getUsername());
		
		String raw=d.getPassword();
		String pass="{bcrypt}"+encoder.encode(raw);
		user.setPassword(pass);
		user.setEnabled(1); // 1 olduqda enabled aktiv 0 olduqda deaktiv olur
		user.setEmail(d.getEmail());
		user.setType("teacher");
		userRepository.save(user);
		
		
		AuthorityEntity a1=new AuthorityEntity();
		a1.setUsername(user.getUsername());
		a1.setAuthority("ROLE_ADD_STUDENT");
		authorityRepository.save(a1);
		
	}

	@GetMapping(path = "/login")
	@ApiOperation(value="Login prosesi")
	public void login() {

	}
	
	
	@PostMapping(path = "/student")
	@PreAuthorize(value="hasAuthority('ROLE_ADD_STUDENT')")
	@ApiOperation(value="Student'in student ve user olaraq qeydiyyati uchun olan api,hemcinin onun huquqlari")
	public void createStudent(@Valid @RequestBody StudentDTO d, BindingResult br) {
		if(br.hasErrors()) {
			throw new OurRuntimeException(br, "Melumatlarin tamligi pozulub");
		}
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		Optional<UserEntity> findById = userRepository.findById(d.getUsername());

		if (findById.isPresent()) { // br- burda validasiya ile bagli sehv deyil ona gore binding result null edilir
			throw new OurRuntimeException(null, "bu username artiq var");
		}

		StudentEntity e = new StudentEntity();
		e.setName(d.getName());
		e.setSurname(d.getSurname());
		e.setUsername(d.getUsername());
		
		String username=SecurityContextHolder.getContext().getAuthentication().getName();  //Telebeni qeyd eden muellimin username'ni qaytarir
		TeacherEntity operatorTeacher=teacherRepository.findByUsername(username);
		Integer teacherId=operatorTeacher.getId();
		
		e.setTeacherId(teacherId);
		studentRepository.save(e);

		UserEntity user = new UserEntity();
		user.setUsername(d.getUsername());
		
		String raw=d.getPassword();
		String pass="{bcrypt}"+encoder.encode(raw);
		user.setPassword(pass);
		user.setEnabled(1); // 1 olduqda enabled aktiv 0 olduqda deaktiv olur
		user.setEmail(d.getEmail());
		user.setType("student");
		userRepository.save(user);
		
		
		AuthorityEntity a1=new AuthorityEntity();
		a1.setUsername(user.getUsername());
		a1.setAuthority("ROLE_UPDATE_STUDENT");
		authorityRepository.save(a1);
		
		//{noop} ile de password'u sifrelemek olar
		
	}
}
