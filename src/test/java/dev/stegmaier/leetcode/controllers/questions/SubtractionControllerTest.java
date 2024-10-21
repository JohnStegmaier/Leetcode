package dev.stegmaier.leetcode.controllers.questions;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import dev.stegmaier.leetcode.services.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SubtractionControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private MathService mathService; // Changed from @Mock to @MockBean

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testSubtractionPage() throws Exception {
    mockMvc
        .perform(get("/questions/subtraction"))
        .andExpect(status().isOk())
        .andExpect(view().name("questions/subtraction"))
        .andExpect(model().attributeExists("description"));
  }

  @Test
  void testHandleSubtractionSuccess() throws Exception {
    when(mathService.subtract("8,3")).thenReturn(5);

    mockMvc
        .perform(
            post("/questions/subtraction")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("numbers", "8,3"))
        .andExpect(status().isOk())
        .andExpect(view().name("questions/subtraction"))
        .andExpect(model().attribute("result", "Result: 5"));

    verify(mathService, times(1)).subtract("8,3");
  }

  @Test
  void testHandleSubtractionInvalidInput() throws Exception {
    doThrow(new IllegalArgumentException("Invalid input")).when(mathService).subtract(anyString());

    mockMvc
        .perform(
            post("/questions/subtraction")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("numbers", "invalid input"))
        .andExpect(status().isOk())
        .andExpect(view().name("questions/subtraction"))
        .andExpect(
            model()
                .attribute(
                    "result", "Invalid input. Please enter two numbers separated by a comma."));

    verify(mathService, times(1)).subtract("invalid input");
  }
}
