package dev.stegmaier.leetcode.controllers.questions;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import dev.stegmaier.leetcode.services.LeetCodeQuestions.Q1106BooleanParsingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Q1106ParsingABooleanExpressionController.class)
class Q1106ParsingABooleanExpressionControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private Q1106BooleanParsingService booleanParsingService;

  @Test
  void testQuestion1106PageLoads() throws Exception {
    mockMvc
        .perform(get("/questions/1106-Parsing-A-Boolean-Expression"))
        .andExpect(status().isOk())
        .andExpect(view().name("questions/1106-Parsing-A-Boolean-Expression"))
        .andExpect(
            content().string(org.hamcrest.Matchers.containsString("Parsing a Boolean Expression")));
  }

  @Test
  void testHandleQuestion1106Input() throws Exception {
    // Mocking service result
    when(booleanParsingService.parseExpression("!(t)")).thenReturn(false);

    mockMvc
        .perform(post("/questions/1106-Parsing-A-Boolean-Expression").param("expression", "!(t)"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("result", "Result: false"))
        .andExpect(view().name("questions/1106-Parsing-A-Boolean-Expression"));
  }

  @Test
  void testHandleQuestion1106Input_InvalidExpression() throws Exception {
    // Mocking service to throw an IllegalArgumentException
    when(booleanParsingService.parseExpression("invalid")).thenThrow(new IllegalArgumentException());

    mockMvc
            .perform(post("/questions/1106-Parsing-A-Boolean-Expression").param("expression", "invalid"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("result", "Invalid input. Please enter a valid boolean expression."))
            .andExpect(view().name("questions/1106-Parsing-A-Boolean-Expression"));
  }
}
