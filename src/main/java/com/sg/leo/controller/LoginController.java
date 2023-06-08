package com.sg.leo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.leo.domain.User;
import com.sg.leo.dto.ResponseDTO;
import com.sg.leo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@GetMapping("/auth/login")
	public String bloglogin() {
		return "system/login";
	}
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/login")
	public @ResponseBody ResponseDTO<?> login(@RequestBody User user, HttpSession session) {
		User findUser = userService.getUser(user.getUsername());
		
		if(findUser.getUsername() != null) {
			if(user.getPassword().equals(findUser.getPassword())) {
				// 로그인성공
				session.setAttribute("blogprincipal", findUser);
				return new ResponseDTO<>(HttpStatus.OK.value(), 
						user.getUsername() + "님 로그인성공 by UserController /auth/insertUser");
			}else {
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), 
						user.getPassword() + "와 비밀번호다름  by UserController /auth/insertUser");	
			}
		
		}else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), 
					user.getUsername() + "님 아이디없음, 회원가입바람,  by UserController /auth/insertUser");		
			
		}
	}
}
