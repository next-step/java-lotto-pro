package study;

public class StringAddCalculator {

    public static final int ZERO = 0;

    public static int splitAndSum(String text) {
        String[] tokens = Delimiters.split(text);

        Numbers numbers = new Numbers();
        for (String token : tokens) {
            numbers.add(Number.validator(token));
        }

        return numbers.sumAllValue().toInt();
    }


}
