package hu.nerbe.fcu;

import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "file-copier",mixinStandardHelpOptions = true, version = "fcu 1.0",
        description = "File copier")
public class FileCopier implements Callable<Integer> {

  @CommandLine.Parameters(index = "0", description = "File name")
  String fileName;

//
//  @Override
//  public void run(){
//    isExists();
//    try {
//      Files.copy(Path.of(SOURCE_PATH), Paths.get(COPY_PATH,"gitIgnoreCopy.txt"), StandardCopyOption.REPLACE_EXISTING);
//    }
//    catch (IOException e) {
//      throw new RuntimeException(e);
//    }
//
//  }
//  public boolean isExists() {
//    return Files.exists(Paths.get(SOURCE_PATH)) && Files.isRegularFile(Paths.get(SOURCE_PATH));
//  }

  @Override
  public Integer call() throws Exception {
    // method call
    System.out.println(fileName + " This is my file");

    return 0;
  }
  public static void main(String... args) {
    int exitCode = new CommandLine(new FileCopier()).execute(args);
    System.exit(exitCode);
  }
}

