/**
 * 
 */
package com.imt.spring.jersey.gradle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imt.spring.jersey.gradle.entity.User;
import com.imt.spring.jersey.gradle.repository.UserRepository;
import com.imt.spring.jersey.gradle.service.base.UserService;

/**
 * @author imti
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUserList() {

		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {

		return userRepository.findOne(id);
	}

}
