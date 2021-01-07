package com.Server.src.jsonhandlers;

import com.Server.src.model.Candidate;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JsonToObject {
  private static String PATH = "src/com/Server/src/files/candidates.json";

  public static ArrayList<Candidate> loadObjects() {
    Gson gson = new Gson();
    Candidate[] result = null;
    ArrayList<Candidate> objects = null;

    try {
      BufferedReader br = new BufferedReader(new FileReader(PATH));
      result = gson.fromJson(br, Candidate[].class);
      objects = new ArrayList<>();
      objects.addAll(Arrays.asList(result));
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return objects;
  }
}
