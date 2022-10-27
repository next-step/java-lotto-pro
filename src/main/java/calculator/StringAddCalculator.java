package calculator;

public class StringAddCalculator {

    private static int DEFAULT_VALUE = 0;

    public static int splitAndSum(String input) {
        if(NumberValidator.isEmpty(input)){
            return DEFAULT_VALUE;
        }

        String[] stringFormatNumbers = StringSplitter.split(input);
        NumberValidator.validateNumbers(stringFormatNumbers);

        return sumStringFormatNumbers(stringFormatNumbers);
    }

    private static int sumStringFormatNumbers(String[] stringFormatNumbers){
        int sum = 0;
        for(String str : stringFormatNumbers){
            sum += Integer.parseInt(str);
        }
        return sum;
    }

}
