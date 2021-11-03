package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 주어진 문자열에대해 구분자문와 숫자문를 구분하며
 * 구분된 항목을 통해 숫자들을 추출한다.
 */
public class Parser {
  private static final String CUSTOMER_SEPARATOR_PARSING_PATTERN = "^//(.)\n(.*)$";
  private static final int REGEX_GROUP_SEPARATOR_INDEX = 1;
  private static final int REGEX_GROUP_NUMBER_INDEX = 2;

  private final Separators defaultSeparators;

  public Parser() {
    this.defaultSeparators = generateDefaultSeparators();
  }

  private Separators generateDefaultSeparators() {
    List<Separator> separators = new ArrayList<>();

    separators.add(new Separator(","));
    separators.add(new Separator(":"));

    return new Separators(separators);
  }

  /**
   * 문자열을 통해 계산에 사용되는 숫자를 추출한다.
   *
   * @param calculatorText 구분자와 숫자가 포함된 문자열
   * @return 계산에 사용되는 숫자
   */
  public Numbers parse(String calculatorText) {
    ParsingElement parsingElement = generateParsingElementWithCustomSeparator(calculatorText)
                                    .orElse(new ParsingElement(calculatorText, this.defaultSeparators));

    return generateNumbers(parsingElement);
  }

  private Optional<ParsingElement> generateParsingElementWithCustomSeparator(String calculatorText) {
    Matcher matcher = Pattern.compile(CUSTOMER_SEPARATOR_PARSING_PATTERN).matcher(calculatorText);

    if (matcher.find()) {
      Separators separators = new Separators(this.defaultSeparators);
      separators.add(new Separator(matcher.group(REGEX_GROUP_SEPARATOR_INDEX)));

      String numberText = matcher.group(REGEX_GROUP_NUMBER_INDEX);
      return Optional.of(new ParsingElement(numberText, separators));
    }

    return Optional.ofNullable(null);
  }

  private Numbers generateNumbers(ParsingElement parsingElement) {
    return new Numbers(Stream.of(getNumberBySeperators(parsingElement))
                                        .map(Number::new)
                                        .collect(Collectors.toList()));
  }

  private String[] getNumberBySeperators(ParsingElement parsingElement) {
    String seperatorRegex = getSeperatorRegex(parsingElement.getSeparators().value());

    return parsingElement.getNumberText().split(seperatorRegex);
  }

  private String getSeperatorRegex(String separator) {
    return "[" + replaceSpecialCharacter(separator) + "]";
  }

  private String replaceSpecialCharacter(String separator) {
    return separator.replace("[", "\\[")
                    .replace("]", "\\]");
  }
}
