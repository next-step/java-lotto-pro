package lotto.infrastructure.component;

import java.util.Scanner;
import lotto.infrastructure.util.Console;

/**
 * 가이드문구에따른 사용자입력 받는 역할.
 */
public class TextEdit implements CuiComponent {
  private String printText = "";
  private String value = "";
  private boolean isRenderingTopMargin = true;

  public static Scanner scanner = new Scanner(System.in);

  public TextEdit() {
  }

  public void setPrintText(String printText) {
    this.printText = printText;
  }

  public TextEdit(String printText) {
    this.printText = printText;
  }

  public void setTopMargin(Boolean isHasTopMargin) {
    this.isRenderingTopMargin = isHasTopMargin;
  }

  @Override
  public void render() {
    if (isRenderingTopMargin) {
      System.out.println(this.printText);
      this.value = Console.nextLine();
      return;
    }

    System.out.print(this.printText);
    this.value = Console.nextLine();
  }

  public String getValue() {
    return this.value;
  }
}
