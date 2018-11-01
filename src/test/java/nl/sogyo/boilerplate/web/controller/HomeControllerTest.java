package nl.sogyo.boilerplate.web.controller;

import org.junit.Test;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.springframework.test.web.server.setup.MockMvcBuilders.*;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

/**
 * Spring MVC - Controller Test
 * Designed after http://rstoyanchev.github.com/spring-31-and-mvc-test/
 * 
 * @author rsteenbergen
 */
public class HomeControllerTest {

	@Test
	public void testJspOnly() throws Exception {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");

		standaloneSetup(new HomeController()).setViewResolvers(viewResolver).build()
			.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(model().size(1))
				.andExpect(model().attributeExists("serverTime"))
				.andExpect(forwardedUrl("/WEB-INF/home.jsp"));
	}
}