public class StringAddCalculator {

    private static final int LENGTH_ZERO = 0;

    public static int splitAndSum(String input) {
        int length = checkLength(input);
        if(length > LENGTH_ZERO){
            Splitter splitter = new Splitter(input);
            Numbers numbers = splitter.addNumbers(splitter.getFractionByDelimiter(input));
            return numbers.calculateSum().getNumber();
        }
        return length;
    }

    public static int checkLength(String input){
        if(input == null || input.length() == LENGTH_ZERO){
            return 0;
        }

        return input.length();
    }

}
