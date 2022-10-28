package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String str) {
        Tokenizer tokenizer = new Tokenizer(str);
        String[] tokens = tokenizer.split();

        Numbers numbers = new Numbers();
        for (String token : tokens) {
            numbers.add(Number.valueOf(token));
        }

        Number sum = numbers.sum();

        return sum.toInt();
    }
}
