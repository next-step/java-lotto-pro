package calculator;

public class StringAddCalculator {

  public static int splitAndSum(String input) {
    Split split = new Split(input);

    String[] stringArray = split.getStringArray();

    StringSum stringSum = new StringSum(stringArray);

    return stringSum.getSum();
  }

}
