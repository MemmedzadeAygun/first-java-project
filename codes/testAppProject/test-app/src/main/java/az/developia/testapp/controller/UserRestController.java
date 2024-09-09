//package az.developia.testapp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import az.developia.testapp.dto.UserDTO;
//import az.developia.testapp.model.UserDetailModel;
//import az.developia.testapp.model.UserModel;
//import az.developia.testapp.repository.UserDetailRepository;
//import az.developia.testapp.repository.UserRepository;
//
//@RestController
//@RequestMapping(path="/users")
//@CrossOrigin(origins="*")
//public class UserRestController {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private UserDetailRepository userDetailRepository;
//	
//	@PostMapping(path="/user")
//	public String addUser(@RequestBody UserDTO userDto) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		UserDetailModel userDetail=new UserDetailModel();
//		userDetail.setId(userDto.getId());
//		userDetail.setName(userDto.getName());
//		userDetail.setSurname(userDto.getSurname());
//		userDetail.setEmail(userDto.getEmail());
//		userDetail.setUsername(userDto.getUsername());
//		userDetailRepository.save(userDetail);
//		
//		UserModel user=new UserModel();
//		user.setUsername(userDto.getUsername());
//		
//		String raw=userDto.getPassword();
//		String pass="{bcrypt}"+encoder.encode(raw);
//		user.setPassword(pass);
//		userRepository.save(user);
//		
//		return "User Added Successfully";
//	}
//	
//	
//	@GetMapping(path = "/login")
//	public void login() {
//
//	}
//}
