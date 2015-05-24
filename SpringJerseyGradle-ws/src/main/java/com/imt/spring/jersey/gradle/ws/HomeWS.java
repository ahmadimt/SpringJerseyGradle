/**
 * 
 */
package com.imt.spring.jersey.gradle.ws;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imt.spring.jersey.gradle.entity.User;
import com.imt.spring.jersey.gradle.service.base.UserService;

/**
 * @author imti
 *
 */
@Component
@Path("/home")
public class HomeWS {

	@Autowired
	private UserService userService;

	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getHomePage(@Context HttpServletRequest request,
			@QueryParam(value = "id") String id) {
		List<User> users = userService.getUserList();
		return Response.ok(users).build();

	}
}
