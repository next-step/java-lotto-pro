package stringAddCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static stringAddCalculator.Utils.Validation.*;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (isNotNullAndEmpty(input)){
            return 0;
        }
        if (isNumber(input)) {
            return Integer.parseInt(input);
        }
        if (!input.startsWith("//")) {
            return splitSumNormal(input);
        }
        return -1;
    }
    
    public static int splitSumNormal(String input) {
        String[] numbers = input.split(",|:");
        return addArr(numbers);
    }
    
    public static int addArr(String[] tokens) {
        int result = 0;
        for (String s : tokens) {
            isNumberAndSizeOne(s);
            result += Integer.parseInt(s);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        splitAndSum(br.readLine());
    }
}
