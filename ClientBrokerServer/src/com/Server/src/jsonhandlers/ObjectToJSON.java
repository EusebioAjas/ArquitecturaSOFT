package com.Server.src.jsonhandlers;

import com.Server.src.exceptions.JsonFormatException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ObjectToJSON {
  private static String PATH = "src/com/Server/src/files/candidates.json";

  public static <T> void saveObjects(ArrayList<T> objects) {
    Gson gson = new Gson();
    JsonElement element = gson.toJsonTree(objects, new TypeToken<List<T>>() {
    }.getType());

    if (!element.isJsonArray()) {
      try {
        throw new JsonFormatException();
      } catch (JsonFormatException e) {
        System.out.println(e.getMessage());
      }
    }

    JsonArray jsonArray = element.getAsJsonArray();
    try {
      FileWriter file = new FileWriter(PATH);
      file.write(jsonArray.toString());
      file.flush();
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
