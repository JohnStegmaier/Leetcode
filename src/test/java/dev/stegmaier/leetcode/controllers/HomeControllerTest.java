package dev.stegmaier.leetcode.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void testHomePage() throws Exception {
    // Perform a GET request to "/"
    mockMvc
        .perform(get("/"))
        // Verify that the correct view is returned
        .andExpect(view().name("home"))
        // Verify that the "welcomeMessage" attribute is added to the model
        .andExpect(model().attribute("welcomeMessage", "Welcome to the Home Page!"))
        // Verify the HTTP status is 200 (OK)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
