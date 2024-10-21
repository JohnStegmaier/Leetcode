package dev.stegmaier.leetcode.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import dev.stegmaier.leetcode.models.Question;
import dev.stegmaier.leetcode.services.QuestionService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private QuestionService questionService; // Use @MockBean instead of @Mock

  @Test
  void testQuestionsList() throws Exception {
    // Arrange
    Question question1 = new Question(1, "Sample Question 1", "/questions/sample1");
    Question question2 = new Question(2, "Sample Question 2", "/questions/sample2");

    List<Question> questions = Arrays.asList(question1, question2);

    when(questionService.getAllQuestions()).thenReturn(questions);

    // Act & Assert
    mockMvc
        .perform(get("/questions"))
        .andExpect(status().isOk())
        .andExpect(view().name("questions"))
        .andExpect(model().attributeExists("questions"))
        .andExpect(model().attribute("questions", questions));

    verify(questionService, times(1)).getAllQuestions();
  }
}
