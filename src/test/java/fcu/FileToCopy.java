package fcu;

import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "fcu",
    mixinStandardHelpOptions = true,
    version = "fcu 1.0",
    description = "Copies a source file to a destination directory.")

public class FileToCopy implements Callable<Integer> {

  @CommandLine.Parameters(index = "0", description = "The source file to copy.")
  String sourcePath = "/home/coder/checking/original";

  @CommandLine.Parameters(index = "1", description = "Destination of Copy File name")
  String copyPath = "/home/coder/checking/copy";


  public void getCopy() {
    isExist();
    try {
      Files.copy(Path.of(sourcePath), Paths.get(copyPath, "copy.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
    catch (IOException e) {
      throw new IllegalArgumentException("File not found!");
    }
  }

  public boolean isExist() {
    return Files.exists(Paths.get(sourcePath)) && Files.isRegularFile(Paths.get(sourcePath));
  }

  @Override
  public Integer call() {
//    getCopy();
    return 0;
  }

  public static void main(String... args) {
    int exitCode = new CommandLine(new FileToCopy()).execute(args);
    System.exit(exitCode);
  }
}

