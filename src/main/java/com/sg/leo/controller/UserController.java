package com.sg.leo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.leo.domain.RoleType;
import com.sg.leo.domain.User;
import com.sg.leo.dto.ResponseDTO;
import com.sg.leo.exception.ZblogException;
import com.sg.leo.repository.UserRepository;
import com.sg.leo.service.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public @ResponseBody String insertUser(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return user.getUsername() + "님 회원가입성공";
	}
	
	@GetMapping("/user/get/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		User findUser = userRepository.findById(id).orElseThrow(()->{
			return new ZblogException(id + "회원없음");
		});
		
		return findUser;
	}
	
	@DeleteMapping("/user/{id}")
	public @ResponseBody String delteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return id + "번 회원삭제 성공";
	}
	
	@GetMapping("/user/list")
	public @ResponseBody List<User> getuserList(){
		return userRepository.findAll();
	}
	
	@GetMapping("/auth/insertUser")
	public String insertUser() {
		return "user/insertUser";
	}
	
	@Autowired
	private UserService userSerice;
	@PostMapping("/auth/insertUser")
	public @ResponseBody ResponseDTO<?> insertUsers(@RequestBody User user){
		
		User findUser = userSerice.getUser(user.getUsername());
		if(findUser.getUsername() == null) {
			// 같은 username회원 없음, 회원가입 진행
			userSerice.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), 
					user.getUsername() + "님 회원가입 성공했어요");
		}else {
			// 중복된 username있음, 에러메시지 표시
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), 
					user.getUsername() + "님 이미 회원임 또는 username 사용중");
		}
		
	}
}
