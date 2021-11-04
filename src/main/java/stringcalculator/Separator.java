package stringcalculator;

/**
 * 문자열에 입력된 숫자를 추출시 사용되는 구분자.
 */
public class Separator {
  private final String item;

  public Separator(String item) {
    this.item = item;
  }

  public String value() {
    return item;
  }
}
