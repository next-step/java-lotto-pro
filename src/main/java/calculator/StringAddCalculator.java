package calculator;

public class StringAddCalculator {

  public static int splitAndSum(String input) {

    String[] stringArray = Split.getStringArray(input);

    return StringSum.getStringSum(stringArray);
  }

}
