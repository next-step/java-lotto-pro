package stringcalcurator;

public class StringCalcurator {
  StringCalculatorParsor stringCalculratorParsor;

  public StringCalcurator() {
    this.stringCalculratorParsor = new StringCalculatorParsor();
  }

  public Integer calcurate(String calcuratingString) {
    CalcuratorNumbers calcuratorNumbers  = this.stringCalculratorParsor.parse(calcuratingString);

    return calcuratorNumbers.sum();
  }
}
