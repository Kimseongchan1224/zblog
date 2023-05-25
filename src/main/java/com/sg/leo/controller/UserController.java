package com.sg.leo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.leo.domain.RoleType;
import com.sg.leo.domain.User;
import com.sg.leo.exception.ZblogException;
import com.sg.leo.repository.UserRepository;

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
}
