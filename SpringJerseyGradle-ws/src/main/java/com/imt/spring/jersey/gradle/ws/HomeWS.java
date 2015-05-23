/**
 * 
 */
package com.imt.spring.jersey.gradle.ws;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author imti
 *
 */
@Component
@Path("/home")
public class HomeWS {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public @ResponseBody Response getHomePage(
			@Context HttpServletRequest request) {
		return Response.ok().build();

	}
}
