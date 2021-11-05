package lotto.infrastructure.component;

/**
 * 설정된 문자열을 화면에 출력하는 역활.
 */
public class Label implements CuiComponent {
  private String printText;

  public Label() {
    this.printText = "";
  }

  public Label(String printText) {
    this.printText = printText;
  }

  @Override
  public void render() {
    System.out.println(this.printText);
  }

  public void setPrintText(String printText) {
    this.printText = printText;
  }
}
