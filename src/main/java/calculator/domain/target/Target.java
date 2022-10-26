package calculator.domain.target;

import calculator.domain.target.splitter.BasicSplitter;
import calculator.domain.target.splitter.CalculatorSplitter;
import calculator.domain.target.splitter.CustomSplitter;
import calculator.domain.target.validation.CalculatorValidator;
import calculator.domain.target.validation.PositiveNumberValidator;

public class Target {

    private String target;
    private CalculatorSplitter splitter;
    private CalculatorValidator validator;

    public Target(String target) {
        this.target = target;
        this.splitter = new CustomSplitter(new BasicSplitter());
        this.validator = new PositiveNumberValidator();
    }

    public int[] target() {
        return target == null || target.isEmpty() ? new int[]{0} : isNotNullAndNotEmptyThenSplit();
    }

    private int[] isNotNullAndNotEmptyThenSplit() {
        String[] split = splitter.split(target);
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = isValidatedThenParseInt(split[i]);
        }
        return result;
    }

    private int isValidatedThenParseInt(String split) {
        String target = split.trim();
        validator.validate(target);
        return Integer.parseInt(target);
    }
}
