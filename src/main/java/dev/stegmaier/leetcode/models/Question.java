package dev.stegmaier.leetcode.models;

public class Question {
  private int id;
  private String title;
  private String url;

  public Question(int id, String title, String url) {
    this.id = id;
    this.title = title;
    this.url = url;
  }

  // Getters and setters
  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }
}
