package lotto.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputUtils {
  private static Scanner scanner;

  private InputUtils() {}

  public static String readLine() {
    if (scanner == null) {
      scanner = new Scanner(System.in);
    }

    String input;

    try {
      input = scanner.nextLine();
    } catch (NoSuchElementException exception) {
      input = null;
    }

    return input;
  }
}
