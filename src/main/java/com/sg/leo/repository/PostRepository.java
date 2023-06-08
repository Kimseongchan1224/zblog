package com.sg.leo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.leo.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
