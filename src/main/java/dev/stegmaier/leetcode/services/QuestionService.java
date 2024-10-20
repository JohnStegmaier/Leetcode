package dev.stegmaier.leetcode.services;

import dev.stegmaier.leetcode.models.Question;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

    // Method to retrieve all questions (for now, we're hardcoding them)
    public List<Question> getAllQuestions() {
        return Arrays.asList(
                new Question(1, "Addition Question", "/questions/addition"),
                new Question(2, "Subtraction Question", "/questions/subtraction"),
                new Question(3, "Parsing A Boolean Expression", "/questions/1106-Parsing-A-Boolean-Expression")
        );
    }
}

