package lotto.utils;

public enum DoubleSplit {
    TWO_DECIMAL_PLACES(100.0);


    private final double digit;

    DoubleSplit(double digit) {
        this.digit = digit;
    }

    public double getDigit() {
        return digit;
    }
}
