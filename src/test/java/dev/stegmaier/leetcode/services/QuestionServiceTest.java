package dev.stegmaier.leetcode.services;

import static org.junit.jupiter.api.Assertions.*;

import dev.stegmaier.leetcode.models.Question;
import java.util.List;
import org.junit.jupiter.api.Test;

class QuestionServiceTest {

  private final QuestionService questionService = new QuestionService();

  @Test
  void testGetAllQuestions() {
    // Retrieve the list of questions
    List<Question> questions = questionService.getAllQuestions();

    // Verify the size of the list
    assertEquals(3, questions.size(), "Expected 3 questions in the list");

    // Verify the details of each question
    Question q1 = questions.get(0);
    assertEquals(1, q1.getId());
    assertEquals("Addition Question", q1.getTitle());
    assertEquals("/questions/addition", q1.getUrl());

    Question q2 = questions.get(1);
    assertEquals(2, q2.getId());
    assertEquals("Subtraction Question", q2.getTitle());
    assertEquals("/questions/subtraction", q2.getUrl());

    Question q3 = questions.get(2);
    assertEquals(3, q3.getId());
    assertEquals("Parsing A Boolean Expression", q3.getTitle());
    assertEquals("/questions/1106-Parsing-A-Boolean-Expression", q3.getUrl());
  }
}
