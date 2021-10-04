package com.example.assessment;

import com.example.assessment.controller.CustomerControllerTest;
import com.example.assessment.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class AssessmentApplicationTests extends CustomerControllerTest {

  @Override
  @Before
  public void setUp() {
    super.setUp();
  }

  @Test
  public void getAllCustomer_success() throws Exception {
    String url = "/create/customer";
    MvcResult mvcResult =
        mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);

    String content = mvcResult.getResponse().getContentAsString();
    Customer customer = mapFromJson(content, Customer.class);
  }
}
