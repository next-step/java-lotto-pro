package calculator.domain;

import static calculator.utils.DelimiterUtils.hasCustomDelimiter;
import static calculator.utils.DelimiterUtils.splitByCustomDelimiter;

import calculator.utils.DelimiterUtils;

/**
 * @author : choi-ys
 * @date : 2022/05/13 2:48 오후
 */
public class CalculatorTarget {

    private DelimiterType delimiterType;
    private String delimiterRegex;
    private String[] values;

    public CalculatorTarget(String given) {
        this.delimiterType = findDelimiterType(given);
        this.delimiterRegex = extractDelimiterRegex(given);
        this.values = splitByDelimiterRegex(given);
    }

    public String getDelimiterRegex() {
        return delimiterRegex;
    }

    public String[] getValues() {
        return values;
    }

    public DelimiterType getDelimiterType() {
        return delimiterType;
    }

    private DelimiterType findDelimiterType(String given) {
        if (hasCustomDelimiter(given)) {
            return DelimiterType.CUSTOM;
        }
        return DelimiterType.NORMAL;
    }

    private String extractDelimiterRegex(String given) {
        if (this.delimiterType.isCustom()) {
            return DelimiterUtils.extractCustomDelimiter(given);
        }
        return DelimiterUtils.extractDelimiterRegex(given);
    }

    private String[] splitByDelimiterRegex(String given) {
        if (hasCustomDelimiter(given)) {
            return splitByCustomDelimiter(given);
        }
        return given.split(delimiterRegex);
    }

    public int addition() {
        int total = 0;
        for (String value : this.values) {
            total += Integer.parseInt(value);
        }
        return total;
    }
}
