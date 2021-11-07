package calculator.domain;

public class Result {

    private final int result;

    public Result(String[] values) {
        int result = 0;
        for (String value : values) {
            result+=getValidatedNumber(value);
        }
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    private int getValidatedNumber(String value) {
        try {
            return validationCheck(value);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private int validationCheck(String value) throws Exception {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new Exception();
        }
        return number;
    }
}
