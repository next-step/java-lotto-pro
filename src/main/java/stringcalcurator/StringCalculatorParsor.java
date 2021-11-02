package stringcalcurator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculatorParsor {
  private final String CUSTOMER_SEPARATOR_PARSING_PATTERN;

  private final Separators separators;

  public StringCalculatorParsor() {
    this.separators = setDefaultSeparator(); 
    CUSTOMER_SEPARATOR_PARSING_PATTERN =  "^//(.)\n(.*)$";
  }

  public CalcuratorNumbers parse(String string) {
    Matcher m = Pattern.compile(CUSTOMER_SEPARATOR_PARSING_PATTERN).matcher(string);

    String number = string;
    String customerSeperator = "";

    if (m.find()) {
      customerSeperator = m.group(1);
      number = m.group(2);
    }

    return new CalcuratorNumbers(Stream.of(getNumberBySeperators(number, customerSeperator))
                                        .map(CalcuratorNumber::new)
                                        .collect(Collectors.toList())
                        );
  }

  private String[] getNumberBySeperators(String number, String customerSeperator) {
    return number.split(getSeperatorRegex(customerSeperator));
  }

  private String getSeperatorRegex(String customerSeperator) {
    return "[" + replaceSpecialCharater(this.separators.getSeparators()) + replaceSpecialCharater(customerSeperator) + "]";
  }

  private String replaceSpecialCharater(String customerSeperator) {
    return customerSeperator.replace("[", "\\[").replace("]", "\\]");
  }
  
  private Separators setDefaultSeparator() {
    List<Separator> tempSeparators = new ArrayList<>();
    
    tempSeparators.add(new Separator(","));
    tempSeparators.add(new Separator(":"));

    return new Separators(tempSeparators);
  }
}
