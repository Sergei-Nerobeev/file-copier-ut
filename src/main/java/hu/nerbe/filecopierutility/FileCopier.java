package hu.nerbe.filecopierutility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopier extends Thread {

  public static final String SOURCE_PATH = "/home/coder/Videos/gitIgnore.txt";
  public static final String COPY_PATH = "/home/coder/Templates";

  @Override
  public void run(){
    isExists();
    try {
      Files.copy(Path.of(SOURCE_PATH), Paths.get(COPY_PATH,"gitIgnoreCopy.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
  public boolean isExists() {
    return Files.exists(Paths.get(SOURCE_PATH)) && Files.isRegularFile(Paths.get(SOURCE_PATH));
  }
}

