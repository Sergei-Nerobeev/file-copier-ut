package hu.nerbe.filecopierutility;

public class Main {
  public static void main(String[] args) {

    FileCopier copier = new FileCopier();
    if (copier.isExists()) {
      copier.start(); // Запускаем поток
      try {
        copier.join(); // Ждём завершения копирования
      }
      catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      System.out.println("Копирование завершено.");
    }
    else {
      System.out.println("Исходный файл не найден.");
    }
  }

}
