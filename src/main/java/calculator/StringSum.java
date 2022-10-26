package calculator;

public class StringSum {

  public final static String ERROR_MESSAGE_BY_NOT_INT_VALUE = "숫자가 아닌 값이 전달되었습니다.";
  public final static String ERROR_MESSAGE_BY_NEGATIVE_INT_VALUE = "Input 에서 음수값이 전달되었습니다.";

  private int sum;

  public int getSum() {
    return sum;
  }

  public StringSum(String[] stringArray) {
    this.sum = sum(stringArray);
  }

  public int sum(String[] stringArray) {

    int sum = 0;

    for(String value: stringArray) {
      sum += convertIntValue(value);
    }

    return sum;
  }

  private int convertIntValue(String input) {

    try {
      int intValue = Integer.parseInt(input);
      validateNegativeNumber(intValue);

      return intValue;
    } catch (NumberFormatException e) {
      throw new RuntimeException(ERROR_MESSAGE_BY_NOT_INT_VALUE);
    }

  }

  private static void validateNegativeNumber(Integer input) {

    if (input < 0) {
      throw new RuntimeException(ERROR_MESSAGE_BY_NEGATIVE_INT_VALUE);
    }

  }



}
