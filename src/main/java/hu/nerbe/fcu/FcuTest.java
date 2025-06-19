package hu.nerbe.fcu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FcuTest {

  @TempDir
  Path tempDir;

  Path sourceFile;
  Path destinationFile;
  FileCopier fileCopier = new FileCopier();

  @BeforeEach
  void setUp() throws IOException {
    sourceFile = tempDir.resolve("original.txt");
    Files.writeString(sourceFile, "Original content");
    Path copyDirectory = tempDir.resolve("copy");
    Files.createDirectories(copyDirectory);
    destinationFile = copyDirectory.resolve("copy.txt");

    fileCopier = new FileCopier();
    fileCopier.sourcePath = sourceFile.toString();
    fileCopier.copyPath = copyDirectory.toString();
  }

  @Test
  public void isExists_SourceFileExists_test() {

    assertTrue(fileCopier.isExist(), "Исходный файл должен существовать и быть обычным файлом.");
  }
}
