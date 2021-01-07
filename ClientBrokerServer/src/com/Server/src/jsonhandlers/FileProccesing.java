package com.Server.src.jsonhandlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProccesing {
  private static String PATH = "src/com/Server/src/files/candidates.json";

  public String getInfo() throws IOException {
    File file = new File(PATH);
    String content = new String(Files.readAllBytes(Paths.get(PATH)));
    return content;
  }
}
