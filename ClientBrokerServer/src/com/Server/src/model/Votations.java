package com.Server.src.model;

import com.Server.src.events.NewCandidate;
import com.Server.src.events.Vote;
import com.Server.src.jsonhandlers.JsonToObject;
import com.Server.src.jsonhandlers.ObjectToJSON;

import java.util.ArrayList;

public class Votations extends Model {
  static Votations votations;

  private ArrayList<Candidate> candidates;

  private Votations() {
    super();
    candidates = JsonToObject.loadObjects();
  }

  public synchronized static Votations getInstance() {
    if (votations == null) {
      votations = new Votations();
    }

    return votations;
  }

  public void addVoteToCandidate(int id) {
    Candidate candidate = candidates.get(id - 1);
    candidate.incrementVotes();
    System.out.println("Vote to " + candidate.getName());
    ObjectToJSON.saveObjects(candidates);
    notify(new Vote());
  }

  public void addCandidate(Candidate candidate) {
    int id = candidates.size();
    candidate.setId(id + 1);
    candidates.add(candidate);
    ObjectToJSON.saveObjects(candidates);
    notify(new NewCandidate());
  }

  public ArrayList<Candidate> getCandidates() {
    return candidates;
  }

  public void setCandidates(ArrayList<Candidate> candidates) {
    this.candidates = candidates;
  }
}
