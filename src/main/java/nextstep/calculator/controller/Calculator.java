package nextstep.calculator.controller;

import nextstep.calculator.domain.CalculatorElement;
import nextstep.calculator.domain.SeparatorStrategy;
import nextstep.calculator.selector.SeparatorStrategySelector;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Calculator {

    private static final Integer DEFAULT_NULL_OR_EMPTY_VALUE = 0;

    private final String inputText;
    private final CalculatorElement calculatorElement;
    private final SeparatorStrategy separatorStrategy;


    public Calculator(String inputText) {
        this.inputText = inputText;
        this.calculatorElement = new CalculatorElement();
        this.separatorStrategy = new SeparatorStrategySelector(inputText).selectSeparatorStrategy();

    }

    public Integer calculate() {

        if (StringUtils.isEmpty(this.inputText)) {
            return DEFAULT_NULL_OR_EMPTY_VALUE;
        }

        List<String> elements = this.separatorStrategy.getSeparatedInputs(this.inputText);
        this.calculatorElement.validateElements(elements);

        return this.calculatorElement.addAllElements();
    }
}
