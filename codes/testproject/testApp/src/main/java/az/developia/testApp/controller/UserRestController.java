package az.developia.testApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.testApp.dto.UserDto;
import az.developia.testApp.model.UserDetail;
import az.developia.testApp.model.UserModel;
import az.developia.testApp.repository.UserDetailRepository;
import az.developia.testApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@PostMapping
	public UserModel addUser(@RequestBody UserDto dto) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		UserModel savedUser=new UserModel();
		String raw=dto.getPassword();
		String pass="{bcrypt}"+encoder.encode(raw);
		savedUser.setPassword(pass);
		savedUser.setUsername(dto.getUsername());

		userRepository.save(savedUser);
		
		UserDetail userDetail=new UserDetail();
		userDetail.setId(dto.getId());
		userDetail.setName(dto.getName());
		userDetail.setSurname(dto.getSurname());
		userDetail.setEmail(dto.getEmail());
		userDetail.setUsername(dto.getUsername());
		userDetailRepository.save(userDetail);
		
		return savedUser;
	}
	
	
	@GetMapping(path="/login")
	public void login() {
		
	}
}
