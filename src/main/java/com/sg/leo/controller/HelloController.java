package com.sg.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/jsp")
	public String jsp(Model model) {
		System.out.println("JSP 파일 호출됨");
		model.addAttribute("username", "스프링을 처음시작합니다");
		return "hellojsp";
	}
}
