package lotto.infrastructure.util;

import java.util.Scanner;

public class Console {
  public static Scanner scanner = new Scanner(System.in);

  public static String nextLine() {
    return scanner.nextLine();
  }

  public static void reLoadScanner() {
    scanner = new Scanner(System.in);
  }
}
