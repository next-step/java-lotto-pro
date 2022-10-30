package calculator.domain.target;

import calculator.domain.target.splitter.BasicSplitter;
import calculator.domain.target.splitter.CalculatorSplitter;
import calculator.domain.target.splitter.CustomSplitter;
import calculator.domain.target.validation.CalculatorValidator;
import calculator.domain.target.validation.PositiveNumberValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Target {

    private String target;
    private CalculatorSplitter splitter;
    private CalculatorValidator validator;

    public Target(String target) {
        this.target = target;
        this.splitter = new CustomSplitter(new BasicSplitter());
        this.validator = new PositiveNumberValidator();
    }

    public List<Integer> target() {
        return target == null || target.isEmpty() ? Collections.singletonList(0) : isNotNullAndNotEmptyThenSplit();
    }

    private List<Integer> isNotNullAndNotEmptyThenSplit() {
        String[] splits = splitter.split(target);
        List<Integer> result = new ArrayList<>();
        Arrays.stream(splits).forEach(split -> result.add(isValidatedThenParseInt(split)));
        return result;
    }

    private int isValidatedThenParseInt(String split) {
        String target = split.trim();
        validator.validate(target);
        return Integer.parseInt(target);
    }
}
