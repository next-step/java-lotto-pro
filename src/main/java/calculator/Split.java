package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {

  private static final String DEFAULT_SPLIT_SEPARATORS= ",|:";
  private static final Pattern CUSTOM_SPLIT_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final int CUSTOM_PATTERN_DELIMITER_INDEX = 1;
  private static final int CUSTOM_PATTERN_TEXT_INDEX = 2;

  private static  boolean isValidInput(String input) {

    if(input == null || input.isEmpty()) {
      return false;
    }

    return true;
  }

  private static  String[] parseInput(String input) {

    if(!isValidInput(input)) {
      return new String[]{};
    }

    Matcher matcher = CUSTOM_SPLIT_SEPARATOR_PATTERN.matcher(input);

    if (matcher.find()) {
      String customToken = matcher.group(CUSTOM_PATTERN_DELIMITER_INDEX);
      return matcher.group(CUSTOM_PATTERN_TEXT_INDEX).split(customToken);
    }

    return input.split(DEFAULT_SPLIT_SEPARATORS);
  }

  public static String[] getStringArray(String input) {
    return parseInput(input);
  }

}
