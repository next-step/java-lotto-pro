package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static int splitAndSum(String input) {

    if(input == null || input.isEmpty()) {
      return 0;
    }

    String[] parsedInput = parseInput(input);

    validateInput(parsedInput);

    Integer result = sum(parsedInput);

    return result;
  }


  private static String[] parseInput(String input) {

    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

    if (matcher.find()) {
      String customToken = matcher.group(1);
      return matcher.group(2).split(customToken);
    }

    return input.split(",|:");
  }

  private static void validateInput(String[] input) {

    for(String value: input) {
      try {

        int intValue = Integer.parseInt(value);
        validateNegativeNumber(intValue);


      } catch (Exception e) {

        System.out.println(e);

        throw new RuntimeException("Not 숫자");

      }

    }

  }

  private static int sum(String[] input) {

    int result = 0;

    for(String value : input) {

      result = result + Integer.parseInt(value);
    }

    return result;
  }

  private static void validateNegativeNumber(Integer input) {

    if (input < 0) {
      throw new RuntimeException("Input 에서 음수값이 전달되었습니다.");
    }

  }


}
