package com.Server.src.model;

public class Candidate {
  private int id;
  private String name;
  private int votes;

  public Candidate(String name, int votes) {
    this.name = name;
    this.votes = votes;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getVotes() {
    return votes;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setVotes(int votes) {
    this.votes = votes;
  }

  public void incrementVotes() {
    votes++;
  }

  @Override
  public String toString() {
    return getId() + ", " + getName() + ", " + getVotes();
  }
}
