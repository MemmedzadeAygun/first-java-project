package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.StudentResponse;
import az.developia.springjava13.component.StudentEntity;
import az.developia.springjava13.component.TeacherEntity;
import az.developia.springjava13.dto.StudentDTO;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;

@RestController
@RequestMapping(path = "/students")
public class StudentRestController {

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private AuthorityRepository authorityrepository;
	
	@Autowired
	private TeacherRepository teacherrepository;

	@GetMapping
	@PreAuthorize(value="hasAuthority('ROLE_GET_STUDENT')")
	public StudentResponse getStudents() {
		StudentResponse response = new StudentResponse();
		String username=SecurityContextHolder.getContext().getAuthentication().getName();  //Telebeni qeyd eden muellimin username'ni qaytarir
		TeacherEntity operatorTeacher=TeacherRepository.findByUsername(username);
		Integer teacherId=operatorTeacher.getId();
		
		
		List<StudentEntity> list=repository.findAllByTeacherId(teacherId);
		
		list.stream().map(s->{
			return s.getName();
		}).filter(s->
			s.contains("a")
		)
		
		.forEach(System.out::println);
		
//		for(StudentEntity s: list) {
//			System.out.println(s.getName());
//		}
		
		response.setStudents(repository.findAll());
		response.setUsername("Aygun");
		return response;	
	}

	@PostMapping
	@PreAuthorize(value="hasAuthority('ROLE_ADD_STUDENT')")
	public void add(@Valid @RequestBody StudentDTO s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "Melumatlarin tamligi pozulub");
		}
		// System.out.println(s);
		
		String username=SecurityContextHolder.getContext().getAuthentication().getName();  //Telebeni qeyd eden muellimin username'ni qaytarir
		TeacherEntity operatorTeacher=TeacherRepository.findByUsername(username);
		Integer teacherId=operatorTeacher.getId();
		
		if(s.getTeacherId()!=teacherId) {
			throw new OurRuntimeException(null, "basqa muellime telebe qeydiyyat etmek ,ogurluq olmaz!");
		}
		

		StudentEntity st = new StudentEntity();
		st.setId(null);
		st.setName(s.getName());
		st.setSurname(s.getSurname());
		st.setTeacherId(s.getTeacherId());

		repository.save(st);

		// bu s obyektini bazaya gonder
		// try {//ORM(Object Relational Mapping)=> JPA(Java Persistence API-obyektlerin
		// bazaya yazilmasi ucun -qaydalar toplusu) =>Hibernate(JPA qaydalarini tetbiq
		// eden kitabxana-esas isi gorur)
		// Connection conn=datasource.getConnection();
		// Statement st=conn.createStatement();
		// st.executeUpdate("insert into students (name,surname)
		// values('"+s.getName()+"','"+s.getSurname()+"');");
		// conn.close();
		// }
		// catch(Exception e) {

		// }
	}

	// 0, null, 10-not found, found
	@PutMapping
	@PreAuthorize(value="hasAuthority('ROLE_UPDATE_STUDENT')")
	public void update(@Valid @RequestBody StudentEntity s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "Melumatlarin tamligi pozulub");
		}

		if (s.getId() == null || s.getId() <= 0) {
			throw new OurRuntimeException(br, "id mutleqdir");
		}

		if (repository.findById(s.getId()).isPresent()) { // olmayan id'ye muraciet etdikde
			repository.save(s);
		} else {
			throw new OurRuntimeException(br, "bu id tapilmadi");
		}

	}

	// POST-qeydiyyat edir
	// PUT redakte edir
	// DELETE-silir
	// GET-data qaytarir

	// /students/8
	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value="hasAuthority('ROLE_DELETE_STUDENT')")
	public void delete(@PathVariable Integer id) {
		// id null
		// id not found
		
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operator=TeacherRepository.findByUsername(username);
		if(operator==null) {
			throw new OurRuntimeException(null, "muellim tapilmadi");
		}
		Integer teacherId=operator.getId();
		

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		Optional<StudentEntity> finded=repository.findById(id);
		//StudentEntity finded1=repository.findById(id).orElseThrow(()->new OurRuntimeException(null,"Bu telebeni sile bilmezsen"));
		if (finded.isPresent()) { // olmayan id'ye muraciet etdikde mes.999
			StudentEntity en=finded.get();  //Optional get methodu bize bir student obyekti qaytarir
			if(en.getTeacherId()==teacherId) {
				repository.deleteById(id);
				userrepository.deleteById(en.getUsername());
				authorityrepository.deleteUserAuthorities(en.getUsername());
				
			}else {
				throw new OurRuntimeException(null,"Bu telebeni sile bilmezsen");
			}
			
	
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value="hasAuthority('ROLE_GET_STUDENT')")
	public StudentEntity findById(@PathVariable Integer id) {

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		Optional<StudentEntity> o = repository.findById(id);
		if (o.isPresent()) { // olmayan id'ye muraciet etdikde
			return o.get();
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

	}
}
