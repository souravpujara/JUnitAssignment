package com.assignment.test;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.assignment.rest.controller.EmployeeController;
import com.assignment.rest.controller.EmployeeDAO;
import com.assignment.rest.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;


import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@SpringBootTest(classes={EmployeeController.class})
@AutoConfigureMockMvc
public class ApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private RestTemplate restTemplate;
    
	@MockBean
	private EmployeeDAO employeeDAO;
	


	@Test
	public void testData() {
		
	        try {
	        	
				mockMvc.perform(get("/employees/get/")).andDo(print())
				        .andExpect(status().isOk());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}


	@Test
	public void testMockData() {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("soru");
		emp.setLastName("pujara");
        when(employeeDAO.getEmployee()).thenReturn(emp);

	        try {
	        	
	        	 String id = employeeDAO.getEmployee().getFirstName();
	             assertEquals("soru",id);
	        	
	        	
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	  @Test
	    public void saveEmployees() throws JsonProcessingException, Exception {
		  ObjectMapper Obj = new ObjectMapper(); 
		    Employee employee1 = new Employee(null, "Adam", "Gilly", "test@email.com");
	        final String baseUrl = "http://localhost:8080/employees/";
	        URI uri = new URI(baseUrl);
	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
	        		  .contentType(MediaType.APPLICATION_JSON)
	        		                  .accept(MediaType.APPLICATION_JSON)
	        		  .content(Obj.writeValueAsString(employee1))).andReturn();
	        
	        int status = result.getResponse().getStatus();
	        assertEquals(status,201);
	
	    }
	
}
