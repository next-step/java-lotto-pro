package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 주어진 문자열에대해 구분자문와 숫자문를 구분하며 
 * 구분된 항목을 통해 숫자들을 추출한다.
 */
public class StringCalculatorParser {
  private static final String CUSTOMER_SEPARATOR_PARSING_PATTERN = "^//(.)\n(.*)$";

  private final Separators defaultSeparators;

  public StringCalculatorParser() {
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
  public CalculatorNumbers parse(String calculatorText) {    
    Matcher m = Pattern.compile(CUSTOMER_SEPARATOR_PARSING_PATTERN).matcher(calculatorText);
    
    if (m.find()) {
      Separators calculatorSeparators = new Separators(this.defaultSeparators);
      calculatorSeparators.add(new Separator(m.group(1)));

      String numberText = m.group(2);
      ParsingElement parsingElement = new ParsingElement(numberText, calculatorSeparators);
      return generateCalculatorNumbers(parsingElement);
    }
    
    ParsingElement parsingElement = new ParsingElement(calculatorText, this.defaultSeparators);
    return generateCalculatorNumbers(parsingElement);
  }

  private CalculatorNumbers generateCalculatorNumbers(ParsingElement parsingElement) {
    return new CalculatorNumbers(Stream.of(getNumberBySeperators(parsingElement))
                                        .map(CalculatorNumber::new)
                                        .collect(Collectors.toList()));
  }

  private String[] getNumberBySeperators(ParsingElement parsingElement) {
    String seperatorRegex = getSeperatorRegex(parsingElement.getSeparators().value());

    return parsingElement.getNumberText().split(seperatorRegex);
  }

  private String getSeperatorRegex(String separator) {
    return "[" + replaceSpecialCharater(separator) + "]";
  }

  private String replaceSpecialCharater(String separator) {
    return separator.replace("[", "\\[")
                    .replace("]", "\\]");
  }
}
