package calculator;

import static calculator.ErrorMessage.*;

public class StringAddCalculator {
  private static final int ZERO = 0;
  private static final String NEGATIVE_NUMBER_PATTERN = "-\\d+";
  private static final String NOT_NUMBER_PATTERN = "[^\\d+]";

  private StringAddCalculator() {}

  public static int splitAndSum(String input) {
    CalculatorInput calculatorInput = new CalculatorInput(input);

    if (calculatorInput.isNullOrEmpty()) {
      return ZERO;
    }
    if (calculatorInput.isNumber()) {
      return stringToInt(calculatorInput.getInput());
    }

    return sum(calculatorInput.split());
  }

  private static int sum(String[] splitInput) {
    int result = ZERO;

    for (String s : splitInput) {
      result += stringToInt(s);
    }

    return result;
  }

  private static int stringToInt(String string) {
    checkStringIsValidNumber(string);
    return Integer.parseInt(string);
  }

  private static void checkStringIsValidNumber(String string) {
    if (string.matches(NEGATIVE_NUMBER_PATTERN)) {
      throw new RuntimeException(NEGATIVE_NUMBER_ERROR);
    }
    if (string.matches(NOT_NUMBER_PATTERN)) {
      throw new RuntimeException(NOT_NUMBER_ERROR);
    }
  }

}
