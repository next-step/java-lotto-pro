package step2;

public class StringCalculator {
    private final String inputValue;
    private final StringValidation stringValidation;
    private final SplitManager stringSplit;
    public final static int NUMBER_ZERO = 0;

    public StringCalculator(String inputValue) {
        this.inputValue = inputValue;
        stringValidation = new StringValidation(inputValue);
        stringSplit = new SplitManager();
    }

    public int result() {
        try {
            stringValidation.isNullOrEmptyByThrow();
            stringValidation.isNegativeByThrow();
            Spliter spliter = stringSplit.findSpliter(inputValue);
            return sum(spliter.split());
        } catch (IllegalArgumentException e) {
            return NUMBER_ZERO;
        }
    }

    private int sum(String[] split) {
        int result = 0;
        for (int index = 0; index < split.length; index++) {
            result += Integer.parseInt(split[index]);
        }
        return result;
    }

}
