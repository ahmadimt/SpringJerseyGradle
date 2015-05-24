/**
 * 
 */
package com.imt.spring.jersey.gradle.service.base;

import java.util.List;

import com.imt.spring.jersey.gradle.entity.User;

/**
 * @author imti
 *
 */
public interface UserService {

	/**
	 * @param id
	 * @return
	 */
	User getUserById(Long id);

	/**
	 * @return
	 */
	List<User> getUserList();
}
