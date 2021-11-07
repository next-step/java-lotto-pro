package lotto.infrastructure.component;

import java.util.Scanner;

/**
 * 가이드문구에따른 사용자입력 받는 역할.
 */
public class TextEdit implements CuiComponent {
  private String printText = "";
  private String value = "";

  public static Scanner scanner = new Scanner(System.in);

  public TextEdit() {
  }

  public void setPrintText(String printText) {
    this.printText = printText;
  }

  public TextEdit(String printText) {
    this.printText = printText;
  }

  @Override
  public void render() {
    System.out.println(this.printText);
    this.value = scanner.nextLine();
  }

  public String getValue() {
    return this.value;
  }
}
