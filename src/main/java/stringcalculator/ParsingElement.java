package stringcalculator;

/**
 * 계산기 구문 파서의 작업 단위가되는 데이터타입.
 */
public class ParsingElement {
  private final String naturalNumberText;
  private final Separators separators;

  public ParsingElement(String numberText, Separators separators) {
    this.naturalNumberText = numberText;
    this.separators = new Separators(separators);
  }

  public String getNaturalNumberText() {
    return this.naturalNumberText;
  }

  public Separators getSeparators() {
    return new Separators(this.separators);
  }
}
