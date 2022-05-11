package calculator.model;

public class StringAddCalculator {

    public static int splitAndSum(String text) throws RuntimeException{
        if (isEmpty(text)) {
            return 0;
        }

        StringPattern pattern = StringPattern.determine(text);
        Separator separator = new Separator(pattern, text);
        Numbers numbers = new Numbers(separator.separate());
        return numbers.sumNumbers();
    }

    public static boolean isEmpty(String text) {
        return (text == null) || text.isEmpty();
    }

}
