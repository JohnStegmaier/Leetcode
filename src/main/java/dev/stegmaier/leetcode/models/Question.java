package dev.stegmaier.leetcode.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

  private int id;
  private String title;
  private String url;
}
