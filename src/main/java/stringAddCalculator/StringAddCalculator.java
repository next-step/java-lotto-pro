package stringAddCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static stringAddCalculator.Utils.Validation.*;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 0;

        if (isNotNullAndEmpty(input)){
            result = 0;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        splitAndSum(br.readLine());
    }
}
