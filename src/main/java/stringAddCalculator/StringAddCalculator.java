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
        if (isNumberAndSizeOne(input)) {
            return Integer.parseInt(input);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        splitAndSum(br.readLine());
    }
}
