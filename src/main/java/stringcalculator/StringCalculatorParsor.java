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
public class StringCalculatorParsor {
  private static final String CUSTOMER_SEPARATOR_PARSING_PATTERN = "^//(.)\n(.*)$";

  private final Separators defaultSeparators;

  public StringCalculatorParsor() {
    this.defaultSeparators = generateDefaultSeparators();
  }
  
  private Separators generateDefaultSeparators() {
    List<Separator> separators = new ArrayList<>();
    
    separators.add(new Separator(","));
    separators.add(new Separator(":"));

    return new Separators(separators);
  }

  /**
   * 문자열을 통해 계산에 사용되는 숫자를 추출한다..
   *
   * @param string 구분자와 숫자가 포함된 문자열
   * @return 계산에 사용되는 숫자
   */
  public CalculatorNumbers parse(String string) {
    Separators calculatorSeparators = new Separators(this.defaultSeparators);
    String number = string;

    Matcher m = Pattern.compile(CUSTOMER_SEPARATOR_PARSING_PATTERN).matcher(string);
    
    if (m.find()) {
      calculatorSeparators.add(new Separator(m.group(1)));
      number = m.group(2);
    }

    return new CalculatorNumbers(generateCalculatorNumbers(number, calculatorSeparators));
  }

  private List<CalculatorNumber> generateCalculatorNumbers(String number, Separators calculatorSeparators) {
    return Stream.of(getNumberBySeperators(number, calculatorSeparators))
                  .map(CalculatorNumber::new)
                  .collect(Collectors.toList());
  }

  private String[] getNumberBySeperators(String number, Separators calculatorSeparators) {
    String seperatorRegex = getSeperatorRegex(calculatorSeparators.value());

    return number.split(seperatorRegex);
  }

  private String getSeperatorRegex(String separator) {
    return "[" + replaceSpecialCharater(separator) + "]";
  }

  private String replaceSpecialCharater(String separator) {
    return separator.replace("[", "\\[")
                    .replace("]", "\\]");
  }
}
