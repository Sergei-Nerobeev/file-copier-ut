package fcutest;

import fcu.FileToCopy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FcuTest {

  @TempDir
  Path tempDir;

  FileToCopy fileToCopy;
  Path sourceFile;
  Path destinationFile;
  Path destinationDirectory;

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
    destinationDirectory = tempDir.resolve("copy");
  }

  @Test
  void isExists_SourceFileExists_test() {

    assertTrue(fileToCopy.isExist(), "Исходный файл должен существовать и быть обычным файлом.");
  }

  @Test
  void isNotExists_SourceFileExists_test() {

    fileToCopy.sourcePath = tempDir.resolve("non_existent_source.txt").toString();

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> fileToCopy.getCopy("copy.txt"),
            "Должно быть выброшено IllegalArgumentException, так как исходный файл не существует."
        );

    assertEquals("File not found!", thrown.getMessage(), "Сообщение исключения должно совпадать.");
  }

  @Test
  void getCopy_CopiesFileSuccessfully_test() throws IOException {

    fileToCopy.getCopy("copy.txt");

    assertTrue(Files.exists(destinationFile), "Файл назначения должен быть создан.");
    assertTrue(Files.isRegularFile(destinationFile), "Файл назначения должен быть обычным файлом.");

    String copiedContent = Files.readString(destinationFile);
    assertEquals("Original content", copiedContent, "Содержимое скопированного файла должно совпадать с оригиналом.");
  }

  @Test
  void getCopy_OverwritesExistingFile_test() throws Exception {
    Files.writeString(destinationFile, "Old content.");

    fileToCopy.getCopy("copy.txt");

    String copiedContent = Files.readString(destinationFile);
    assertEquals("Original content", copiedContent, "Существующий файл должен быть перезаписан.");
  }

  @Test
  void verifyNumberOfCopiedFiles_isTen_test() throws IOException {

    int numberOfCopies = 10;

    for (int i = 0; i < numberOfCopies; i++) {
      String uniqueName = "Number " + i + " .txt";
      fileToCopy.getCopy(uniqueName);
    }
    List<Path> copiedFiles = Files.list(destinationDirectory)
                                  .filter(Files::isRegularFile)
                                  .toList();

    assertEquals(numberOfCopies, copiedFiles.size());

  }
}
