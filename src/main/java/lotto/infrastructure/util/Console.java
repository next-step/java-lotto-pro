package lotto.infrastructure.util;

import java.util.Scanner;

public class Console {
  private static Scanner scanner = new Scanner(System.in);

  private Console() {
    throw new IllegalAccessError("유틸 클래스이므로 생성자를 이용할 수 없습니다.");
  }

  public static String nextLine() {
    return scanner.nextLine();
  }

  public static void reLoadScanner() {
    scanner = new Scanner(System.in);
  }
}
