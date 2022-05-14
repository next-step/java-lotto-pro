package stringAddCalculator;

import stringAddCalculator.domain.Numbers;
import stringAddCalculator.utils.Parse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static stringAddCalculator.utils.Validation.*;

public class StringAddCalculator {
    public static final int NULL_OR_EMPTY = 0;
    public static int splitAndSum(String input) throws IllegalAccessException {
        Numbers numbers;
        if (isNotNullAndEmpty(input)){
            return NULL_OR_EMPTY;
        }
        if (isNumber(input)) {
            return Integer.parseInt(input);
        }
        numbers = new Numbers(new Parse().checkTypeAndSplit(input));
        return numbers.sumNumbers();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(splitAndSum(br.readLine()));
    }
}
