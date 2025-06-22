package dev.stegmaier.leetcode.controllers.questions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import dev.stegmaier.leetcode.services.LeetCodeQuestions.Q3085MinimumDeletionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Q3085MinimumDeletionstoMakeStringKSpecialController.class)
class Q3085MinimumDeletionstoMakeStringKSpecialControllerTest {
  @Autowired private MockMvc mockMvc;

  @MockitoBean private Q3085MinimumDeletionService minimumDeletionService;

  @Test
  void testQuestion3085PageLoads() throws Exception {
    mockMvc
        .perform(get("/questions/3085-Minimum-Deletions-To-Make-String-K-Special"))
        .andExpect(status().isOk())
        .andExpect(view().name("questions/3085-Minimum-Deletions-To-Make-String-K-Special"))
        .andExpect(
            content()
                .string(
                    org.hamcrest.Matchers.containsString(
                        "Minimum Deletions To Make String K-Special")));
  }

  @Test
  void testHandleQuestion3085Input() throws Exception {
    // Mocking service result
    when(minimumDeletionService.getMinimumDeletions("aaaabbbccc", 12)).thenReturn(0);

    mockMvc
        .perform(
            post("/questions/3085-Minimum-Deletions-To-Make-String-K-Special")
                .param("expression", "aaaabbbccc")
                .param("kValue", "12"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("result", "minimum number of deletions: 0"))
        .andExpect(view().name("questions/3085-Minimum-Deletions-To-Make-String-K-Special"));
  }

  @Test
  void testHandleQuestion3085Input_InvalidExpression() throws Exception {
    // Mocking service to throw an IllegalArgumentException
    when(minimumDeletionService.getMinimumDeletions("invalid", 12))
        .thenThrow(new IllegalArgumentException());

    mockMvc
        .perform(
            post("/questions/3085-Minimum-Deletions-To-Make-String-K-Special")
                .param("expression", "invalid")
                .param("kValue", "12"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("result", "Invalid input. Please enter a valid input."))
        .andExpect(view().name("questions/3085-Minimum-Deletions-To-Make-String-K-Special"));
  }
}
