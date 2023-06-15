package com.sg.leo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.leo.domain.Post;
import com.sg.leo.domain.User;
import com.sg.leo.dto.ResponseDTO;
import com.sg.leo.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	@GetMapping({"/", ""})
	public String getPostList(Model model) {
		model.addAttribute("postList",postService.getPostList());
		return "zblogindex";
	}
	
	@GetMapping("/auth/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/post")
	public @ResponseBody ResponseDTO<?> insertPost(@RequestBody Post post,
			HttpSession session) {
		User blogprincipal = (User)session.getAttribute("blogprincipal");
		post.setUser(blogprincipal);
		postService.insertPost(post);
		return new ResponseDTO<>(HttpStatus.OK.value(), "새로운포스트 등록");
	}
}
