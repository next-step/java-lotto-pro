package lotto.infrastructure.component;

/**
 * 설정된 문자열을 화면에 출력하는 역활.
 */
public class MarginLabel implements CuiComponent {
  Integer marginCount;

  public MarginLabel() {
    this.marginCount = 0;
  }

  @Override
  public void render() {
    System.out.print("\n".repeat(this.marginCount));
  }

  public void setMarginCount(Integer marginCount) {
    this.marginCount = marginCount;
  }
}
