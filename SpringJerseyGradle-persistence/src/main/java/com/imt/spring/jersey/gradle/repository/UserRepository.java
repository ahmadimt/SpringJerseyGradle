/**
 * 
 */
package com.imt.spring.jersey.gradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imt.spring.jersey.gradle.entity.User;

/**
 * @author imti
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
