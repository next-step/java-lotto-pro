package calculator;

public class CalculatorInput {
  private final String input;

  public CalculatorInput(String input) {
    this.input = input;
  }

  public String getInput() {
    return input;
  }

  public boolean isNullOrEmpty() {
    if (input == null) {
      return true;
    }

    return input.isEmpty();
  }

  public boolean isNumber() {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public String[] split() {
    return StringSeparator.split(input);
  }
}
