/*package com.airelogic.springbootmongodbexample.controllers;


import java.util.Collections;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.airelogic.springbootmongodbexample.models.User;
import com.airelogic.springbootmongodbexample.repositories.UserRepository;
import com.airelogic.springbootmongodbexample.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	User mockUser = new User("Narasimha", "Kotnala", "narasimha.kotnala@yahoo.com","kot");
	
	String exampleUserJson = "{\"firstName\":\"Narasimha\",\"lastName\":\"Kotnala\",\"userName\":\"narasimha.kotnala@yahoo.com\",\"password\":\"kot\"}";
	
	
	

	@Test
	public void retrieveUserByUserName() throws Exception {
		
		Mockito.when(userService.getByUserName(Mockito.anyString())).thenReturn(mockUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/getUserByUserName").accept(org.springframework.http.MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		
		String expected = "{firstName:Narasimha,lastName:Kotnala,userName:narasimha.kotnala@yahoo.com,password:kot}";
		
		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
		
	}
	
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserRepository userRepository;
	
	public void contextLoads() {
		
		Mockito.when(userRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
		
		//MvcResult mvcResult = MockMvcRequestBuilders.get("/api/v1/getUserByUserName").accept(org.springframework.http.MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getUserByUserName")
				                      .accept(MediaType.APPLICATION_JSON);
		
		
		
		
	}
	
	
	
	
	
	
}
*/