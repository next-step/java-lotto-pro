package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("(//)([^0-9])(\n)(.*)");
  private static final int REGEX_CUSTOM_DELIMITER_INDEX = 2;
  private static final int REGEX_CUSTOM_DELIMITER_STRINGS_INDEX = 4;
  private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

  public static String[] split(String input) {
    if (hasCustomDelimiter(input)) {
      return separatedByCustomDelimiter(input);
    }

    return separatedByDefaultDelimiter(input);
  }

  private static String[] separatedByDefaultDelimiter(String input) {
    return input.split(DEFAULT_DELIMITER_REGEX);
  }

  private static String[] separatedByCustomDelimiter(String input) {
    Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
    customDelimiterMatcher.matches();
    String customDelimiter = customDelimiterMatcher.group(REGEX_CUSTOM_DELIMITER_INDEX);
    String numberString = customDelimiterMatcher.group(REGEX_CUSTOM_DELIMITER_STRINGS_INDEX);
    return numberString.split(customDelimiter);
  }

  private static boolean hasCustomDelimiter(String input) {
    return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
  }
}
