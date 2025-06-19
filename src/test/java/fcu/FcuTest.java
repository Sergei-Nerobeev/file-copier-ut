package fcu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FcuTest {

  @TempDir
  Path tempDir;
  FileToCopy fileToCopy;
  Path sourceFile;
  Path destinationFile;

  @BeforeEach
  void setUp() throws IOException {
    sourceFile = tempDir.resolve("original.txt");
    Files.writeString(sourceFile, "Original content");
    Path copyDirectory = tempDir.resolve("copy");
    Files.createDirectories(copyDirectory);
    destinationFile = copyDirectory.resolve("copy.txt");

    fileToCopy = new FileToCopy();
    fileToCopy.sourcePath = sourceFile.toString();
    fileToCopy.copyPath = copyDirectory.toString();
  }

  @Test
  void isExists_SourceFileExists_test() {

    assertTrue(fileToCopy.isExist(), "Исходный файл должен существовать и быть обычным файлом.");
  }
}
