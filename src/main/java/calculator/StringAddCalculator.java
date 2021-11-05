package calculator;


public class StringAddCalculator {

    public static int stringAdd(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parseNumber = StringParseNumber.parseNumber(number);
            sum += parseNumber;
        }
        return sum;
    }

}
