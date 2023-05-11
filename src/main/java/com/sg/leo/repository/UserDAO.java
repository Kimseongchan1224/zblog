package com.sg.leo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sg.leo.domain.User;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(User user) {
		mybatis.insert("insertUser", user);
	}
	public void updateUser(User user) {
		mybatis.update("updateUser", user);
	}
	public void deleteUser(User user) {
		mybatis.delete("deleteUser", user);
	}
	public User getuser(User user) {
		return mybatis.selectOne("getUser", user);
	}
	
	public List<User> getUserList() {
		return mybatis.selectList("getUserList");
	}
}