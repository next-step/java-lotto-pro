package calculator;

import calculator.domain.Number;
import calculator.module.Separator;

public class StringAddCalculator {

    private StringAddCalculator() {}

    public static int splitAndSum(String input){
        return Separator.separate(input)
                .splitSeparated()
                .getNumberList()
                .stream()
                .mapToInt(Number::getNumber)
                .sum();
    }
}
