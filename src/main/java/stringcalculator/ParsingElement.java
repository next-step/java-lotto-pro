package stringcalculator;

/**
 * 계산기 구문 파서의 작업 단위가되는 데이터타입.
 */
public class ParsingElement {
  private final String numberText;
  private final Separators separators;
  
  public ParsingElement(String numberText, Separators separators) {
    this.numberText = numberText;
    this.separators = new Separators(separators);
  }

  public String getNumberText() {
    return this.numberText;
  }

  public Separators getSeparators() {
    return new Separators(this.separators);
  }
}
