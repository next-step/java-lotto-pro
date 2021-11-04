package lotto.component;

import java.util.Scanner;

/**
 * 가이드문구에따른 사용자입력 받는 역할.
 */
public class TextEdit implements CuiComponent {
  private final String printText;
  private String value;

  private Scanner sc;

  public TextEdit(String  printText) {
    this.printText =  printText;
    this.sc = new Scanner(System.in);
  }

  @Override
  public void render() {
    System.out.println(this.printText);

    this.value = this.sc.nextLine();
  }

  public String getValue() {
    return this.value;
  }
}
